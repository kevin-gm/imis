package site.imis.wx.dto.wx.menu;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.ParseException;
import site.imis.wx.common.consts.WxConsts;
import site.imis.wx.common.util.HttpUtil;
import site.imis.wx.dto.wx.AccessToken;

import java.io.IOException;
import java.util.Date;

/**
 * Created by kevin无道 on 2017/8/27.
 */
public class WxTokenUtil {

    private final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    private final static AccessToken WX_ACCESS_TOKEN_CACHE = new AccessToken();
    private final static Long TOKEN_INTERVAL = 7200L;

    /**
     * 获取accessToken
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static AccessToken getAccessToken(){
        long curSec = new Date().getTime();
        long cacheSec = WX_ACCESS_TOKEN_CACHE.getExpiresIn();
        if(cacheSec > 0 && curSec - cacheSec < TOKEN_INTERVAL) {
            return WX_ACCESS_TOKEN_CACHE;
        }
        String url = ACCESS_TOKEN_URL.replace("APPID", WxConsts.APPID).replace("APPSECRET", WxConsts.APPSECRET);
        JSONObject jsonObject = HttpUtil.get(url);
        if(jsonObject!=null){
            WX_ACCESS_TOKEN_CACHE.setToken(jsonObject.getString("access_token"));
            WX_ACCESS_TOKEN_CACHE.setExpiresIn(jsonObject.getInteger("expires_in"));
        }
        return WX_ACCESS_TOKEN_CACHE;
    }
}