package site.imis.wx.dto.wx.message;

/**
 *  微信消息格式基础对象
 * Created by kevin无道 on 2017/8/23.
 */
public class WxMessage {

    /**
     * 接收方微信号
     */
    private String ToUserName;
    /**
     * 发送方帐号
     */
    private String FromUserName;
    /**
     * 消息创建时间
     */
    private Long CreateTime;
    /**
     * 消息类型
     * @see
     */
    private String MsgType;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}