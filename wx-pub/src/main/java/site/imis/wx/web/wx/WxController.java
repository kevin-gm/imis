package site.imis.wx.web.wx;

import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import site.imis.wx.dto.wx.message.WxMessage;
import site.imis.wx.service.wx.WxMsgService;
import site.imis.wx.common.util.WxCheckUtil;
import site.imis.wx.common.util.WxMessageUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 *  微信接口控制器，此api对象微信服务器配置的url，为微信后台请求本系统的入口
 * Created by kevin无道 on 2017/8/23.
 */
@RestController
@RequestMapping("/wx")
public class WxController {

    @Autowired
    private WxMsgService wxMsgService;

    private final static Logger LOGGER = LoggerFactory.getLogger(WxController.class);

    /**
     *  Get请求，主要是用来进行微信初始校验
     * @param request
     * @return
     */
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public String doGet(HttpServletRequest request) {
        //微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        String signature = request.getParameter("signature");
        //时间戳
        String timestamp = request.getParameter("timestamp");
        //随机数
        String nonce = request.getParameter("nonce");
        //随机字符串
        String echostr = request.getParameter("echostr");

        //根据微信api规则，校验参数有效性
        if(WxCheckUtil.checkWxSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return null;
    }

    /**
     * 微信请求本系统，正常请求都是POST请求，需要本系统自行根据消息类型进行判断处理
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    @RequestMapping(value = "/api", method = RequestMethod.POST)
    public String doPost(HttpServletRequest request) throws IOException, DocumentException {
        //将请求内容，转换为map对象，便于后续操作
        Map<String, String> map = WxMessageUtil.xmlToMap(request);

        //调用service接口，根据类型以及业务，进行不同的处理得到返回结果
        WxMessage returnMsg = wxMsgService.handleWxReq(map);
        //将得到的WxMessage对象转换为接口返回需要的xml字符串并返回
        return WxMessageUtil.textMessageToXml(returnMsg);
    }
}