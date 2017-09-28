package site.imis.wx.repository.wx;

import site.imis.wx.model.wx.WxMenu;
import site.imis.wx.qo.wx.WxMenuQO;

import java.util.List;

/**
 *  微信菜单数据层接口
 * Created by kevin无道 on 2017/8/24.
 */
public interface WxMenuRepository {

    List<WxMenu> loadWxMenu(WxMenuQO wxMenuQO);
}