package site.imis.wx.service.wx.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.BeanUtils;
import site.imis.wx.dto.wx.TestModel;
import site.imis.wx.dto.wx.message.WxMessage;

/**
 *  微信消息生成器
 * Created by kevin无道 on 2017/8/23.
 */
public class WxMessageGenerator {

    private final static String BASE_WX_MSG_PKG = "xyz.coloured.imis.wx.dto.wx.";
    private final static String BASE_WX_MSG_SUFFIX = "Message";

    public static WxMessage genWxMessage(String msgType, Object model) {
        //根据msgType获取对应message实例
        String className = BASE_WX_MSG_PKG + StringUUtil.upperFistLetter(msgType.toLowerCase()) + BASE_WX_MSG_SUFFIX;
        try {
            Class<?> cls = Class.forName(className);
            Object obj = cls.newInstance();
            BeanUtils.copyProperties(model, obj);
            return (WxMessage)obj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        TestModel model = new TestModel();
        model.setContent("test");
        model.setMsgId("11111");
        WxMessage msg = genWxMessage("text", model);
        System.out.print(JSON.toJSONString(msg));
    }
}