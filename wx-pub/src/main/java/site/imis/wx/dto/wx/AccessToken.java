package site.imis.wx.dto.wx;

/**
 * 微信请求需要的Token对象
 * Created by kevin无道 on 2017/8/27.
 */
public class AccessToken {

    private String token;
    private long expiresIn;
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public long getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
}