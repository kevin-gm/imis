package site.imis.wx.service.wx.impl;

import org.springframework.stereotype.Service;
import site.imis.wx.dto.wx.TestModel;
import site.imis.wx.dto.wx.message.WxMessage;
import site.imis.wx.service.wx.WxMsgService;
import site.imis.wx.service.wx.util.WxMessageGenerator;

import java.util.Date;
import java.util.Map;

/**
 * Created by kevin无道 on 2017/8/23.
 */
@Service
public class WxMsgServiceImpl implements WxMsgService {

    public WxMessage handleWxReq(Map<String, String> reqMap) {
        //获取消息类型
        String msgType = reqMap.get("MsgType");

        //根据业务逻辑获取结果

        //将结果转换为WxMessage对象
        WxMessage resultMsg = WxMessageGenerator.genWxMessage(msgType, new TestModel());

        //反转发送和接收对象，消息类型由业务决定
        resultMsg.setToUserName(reqMap.get("FromUserName"));
        resultMsg.setFromUserName(reqMap.get("ToUserName"));
        resultMsg.setCreateTime(new Date().getTime());

        return null;
    }
}