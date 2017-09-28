package site.imis.wx.dto.wx;

/**
 * Created by kevin无道 on 2017/8/23.
 */
public class TestModel {

    /**
     * 文本消息内容
     */
    private String Content;
    /**
     * 消息id，64位整型
     */
    private String MsgId;

    public TestModel() {}

    public TestModel(String content, String msgId) {
        Content = content;
        MsgId = msgId;
    }

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
