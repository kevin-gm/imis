package site.imis.wx.dto.wx.message;

/**
 *  微信文本消息对象,属性需要与微信文档定义的一致
 * Created by kevin无道 on 2017/8/22.
 */
public class TextMessage extends WxMessage {

    /**
     * 文本消息内容
     */
    private String Content;
    /**
     * 消息id，64位整型
     */
    private String MsgId;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}