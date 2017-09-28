package site.imis.wx.service.wx.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.imis.wx.common.consts.WxConsts;
import site.imis.wx.config.WxApiUrlProps;
import site.imis.wx.dto.wx.AccessToken;
import site.imis.wx.dto.wx.menu.Button;
import site.imis.wx.dto.wx.menu.ButtonUtil;
import site.imis.wx.dto.wx.menu.WxTokenUtil;
import site.imis.wx.repository.wx.WxMenuRepository;
import site.imis.wx.service.wx.WxMenuService;
import site.imis.wx.dto.wx.menu.Menu;
import site.imis.wx.model.wx.WxMenu;
import site.imis.wx.qo.wx.WxMenuQO;
import site.imis.wx.common.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin无道 on 2017/8/24.
 */
@Service
public class WxMenuServiceImpl implements WxMenuService {

    private final static Logger LOGGER = LoggerFactory.getLogger(WxMenuServiceImpl.class);

    @Autowired
    private WxMenuRepository wxMenuRepository;
    @Autowired
    private WxApiUrlProps wxApiUrlProps;

    @Override
    public String loadAndPushWxMenu() {
        //从数据库加载配置的微信菜单项，查询状态为可用的，默认为1 TODO 配置状态枚举类型，并优化数据库字段
        List<WxMenu> wxMenus = wxMenuRepository.loadWxMenu(new WxMenuQO("1"));

        //对数据进行格式化，将数据组装成菜单与子菜单的关系
        formatWxMenu(wxMenus);

        //转换数据对象
        Menu menu = new Menu();
        menu.setButton(genMenu(wxMenus));
        String menuStr = JSON.toJSONString(menu);
        LOGGER.info("转换后的菜单内容为：" + menuStr);

        //获取请求token
        AccessToken token = WxTokenUtil.getAccessToken();
        //通过Http调用微信api接口，上传微信菜单
        String url = wxApiUrlProps.getMenu_create().replace(WxConsts.URL_PLACEHOLDER_ACCESS_TOKEN, token.getToken());
        LOGGER.info("微信菜单创建的URL：" + url);
        JSONObject pushResult = HttpUtil.post(url, null, menuStr);
        LOGGER.info("推送菜单到微信的结果为：" + pushResult);
        return null;
    }


    /**
     * 构建微信菜单
     * @param wxMenus
     * @return
     */
    public Button[] genMenu(List<WxMenu> wxMenus) {
        Button[] btns = new Button[wxMenus.size()];
        for (int i = 0; i < wxMenus.size(); i++) {
            WxMenu wm = wxMenus.get(i);
            Button btn = generatorWxButton(wm);
            //遍历子节点
            List<WxMenu> sunMenus = wm.getChilds();
            if(sunMenus != null && sunMenus.size() > 0) {
                Button[] subs = new Button[sunMenus.size()];
                for (int j = 0; j < sunMenus.size(); j++) {
                    WxMenu sm = sunMenus.get(j);
                    subs[i] = generatorWxButton(sm);
                }
                btn.setSub_button(subs);
            }
            btns[i] = btn;
        }
        return btns;
    }

    /**
     * 格式化菜单节点
     * @param wm
     * @return
     */
    private Button generatorWxButton(WxMenu wm) {
        Button button = ButtonUtil.generatorByType(wm.getType());
        ButtonUtil.setButtonValue(button, wm);
        return button;
    }

    /**
     * 格式化菜单，数据获取时，根节点必须在前面
     * @param wxMenus
     */
    private void formatWxMenu(List<WxMenu> wxMenus) {
        List<WxMenu> newMenus = new ArrayList<WxMenu>();
        for (WxMenu wxMenu : wxMenus) {
            //如果是根菜单，TODO 修改硬编码
            if("0".equals(wxMenu.getLevel())) {
                newMenus.add(wxMenu);
            } else {
                for (WxMenu newMenu : newMenus) {
                    if(wxMenu.getParentId().equals(newMenu.getId())) {
                        if(newMenu.getChilds() == null) {
                            newMenu.setChilds(new ArrayList<WxMenu>());
                        }
                        newMenu.getChilds().add(newMenu);
                        break;
                    }
                }
            }
        }
    }
}