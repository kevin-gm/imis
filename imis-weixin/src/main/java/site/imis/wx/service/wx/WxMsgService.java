package site.imis.wx.service.wx;

import site.imis.wx.dto.wx.message.WxMessage;

import java.util.Map;

/**
 * Created by kevin无道 on 2017/8/23.
 */
public interface WxMsgService {

    WxMessage handleWxReq(Map<String, String> reqMap);
}