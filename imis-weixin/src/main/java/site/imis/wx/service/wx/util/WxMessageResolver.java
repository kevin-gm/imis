package site.imis.wx.service.wx.util;

import site.imis.wx.dto.wx.message.WxMessage;

import java.util.Map;

/**
 *  微信消息解析器
 * Created by kevin无道 on 2017/8/23.
 */
public class WxMessageResolver {

    public static WxMessage resolveReqMap(Map<String, String> reqMap) {
        String msgType = reqMap.get("MsgType");
        return null;
    }
}