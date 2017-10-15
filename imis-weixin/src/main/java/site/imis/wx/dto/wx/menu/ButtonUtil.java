package site.imis.wx.dto.wx.menu;

import site.imis.wx.enums.WxMenuTypeEnum;
import site.imis.wx.model.wx.WxMenu;

/**
 * Created by kevin无道 on 2017/8/27.
 */
public class ButtonUtil {

    /**
     * 通过菜单类型，构建具体的菜单对象<br/>
     * 约定数据库存键，值为下划线类型，类名称为值得驼峰结构，首字母大写。
     * @param type
     * @return
     */
    public static Button generatorByType(String type) {
        //获取类型键对应的值，数据库存的是键
        String typeValue = WxMenuTypeEnum.getValue(type);
        //将类型值（下划线类型）转成驼峰型
        String camelTypeValue = StringUUtil.underlineToCamel(typeValue);
        //再将类型值首字母大写，即得到对应的类名称
        camelTypeValue = StringUUtil.upperFistLetter(camelTypeValue) + "Button";
        //构造类完整路径
        camelTypeValue = "xyz.coloured.imis.wx.dto.wx.menu." + camelTypeValue;
        //通过反射，获取对应的实例
        Object obj = ReflectUtil.genInstance(camelTypeValue);
        if(obj != null) {
            Button btn = (Button)obj;
            btn.setType(typeValue);
            return btn;
        }
        //TODO 后续自定义异常后，此处需要修改
        throw new IllegalArgumentException("类型参数不正确，找不到对应的类");
    }

    /**
     * 根据获取的内容，针对不同类型的菜单分别设置参数
     * @param btn
     * @param menu
     */
    public static void setButtonValue(Button btn, WxMenu menu) {
        btn.setName(menu.getName());
        if(btn instanceof ClickButton) {
            ((ClickButton) btn).setKey(menu.getBtnKey());
        } else if(btn instanceof ViewButton) {
            ((ViewButton) btn).setUrl(menu.getUrl());
        }
    }
}