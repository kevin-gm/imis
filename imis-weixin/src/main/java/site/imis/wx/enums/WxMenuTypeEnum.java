package site.imis.wx.enums;

/**
 * 微信菜单类型枚举类
 * Created by kevin无道 on 2017/8/26.
 */
public enum WxMenuTypeEnum {

    CLICK("1", "click"),
    VIEW("2", "view"),
    SCANCODE_PUSH("3", "scancode_push"),
    SCANCODE_WAITMSG("4", "scancode_waitmsg"),
    PIC_SYSPHOTO("5", "pic_sysphoto"),
    PIC_SYSPHOTO_OR_ALBUM("6", "pic_photo_or_album"),
    PIC_WEIXIN("7", "pic_weixin"),
    LOCATION_SELECT("8", "location_select"),
    MEDIA_ID("9", "media_id"),
    VIEW_LIMITED("10", "view_limited");

    private String key;
    private String value;

    private WxMenuTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static String getValue(String key) {
        for (WxMenuTypeEnum ens : values()) {
            if(ens.getKey().equals(key)) {
                return ens.getValue();
            }
        }
        return null;
    }
}