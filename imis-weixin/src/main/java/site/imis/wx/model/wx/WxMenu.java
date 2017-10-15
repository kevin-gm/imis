package site.imis.wx.model.wx;

import java.util.List;

/**
 *  微信菜单实体类
 * Created by kevin无道 on 2017/8/24.
 */
public class WxMenu {

    private String id;
    private String name;
    private String type;
    private String level;
    private String parentId;
    private String btnKey;
    private String url;
    private String mediaId;
    private String appId;
    private String status;
    private String pagePath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private List<WxMenu> childs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getBtnKey() {
        return btnKey;
    }

    public void setBtnKey(String btnKey) {
        this.btnKey = btnKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<WxMenu> getChilds() {
        return childs;
    }

    public void setChilds(List<WxMenu> childs) {
        this.childs = childs;
    }
}