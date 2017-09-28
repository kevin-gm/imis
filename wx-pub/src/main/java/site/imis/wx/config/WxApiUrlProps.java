package site.imis.wx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by kevin无道 on 2017/8/24.
 */
@Component
@PropertySource("classpath:wx-api.properties")
public class WxApiUrlProps {

    @Value("${wx.api.url.menu.create}")
    private String menu_create;

    public String getMenu_create() {
        return menu_create;
    }

    public void setMenu_create(String menu_create) {
        this.menu_create = menu_create;
    }
}