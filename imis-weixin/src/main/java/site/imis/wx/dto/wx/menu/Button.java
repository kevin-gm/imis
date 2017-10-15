package site.imis.wx.dto.wx.menu;

/**
 *  微信菜单对应的每一个菜单，实际每一个菜单在微信api是一个button
 * Created by kevin无道 on 2017/8/24.
 */
public class Button {

    //菜单类型
    private String type;
    //菜单名称
    private String name;
    //二级菜单
    private Button[] sub_button;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }
}