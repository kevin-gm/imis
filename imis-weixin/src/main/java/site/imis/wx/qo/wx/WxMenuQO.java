package site.imis.wx.qo.wx;

/**
 *  微信菜单查询参数对象
 * Created by kevin无道 on 2017/8/24.
 */
public class WxMenuQO {

    private String status;
    private String level;
    private String type;

    public WxMenuQO() {}

    public WxMenuQO(String status) {
        this.status = status;
    }

    public WxMenuQO(String status, String level, String type) {
        this.status = status;
        this.level = level;
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}