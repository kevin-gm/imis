package site.imis.wx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import site.imis.wx.dto.wx.TestModel;
import site.imis.wx.service.wx.WxMenuService;

/**
 * Created by kevin无道 on 2017/8/21.
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private WxMenuService wxMenuService;

    @RequestMapping(value = "/v1", method = RequestMethod.GET)
    public TestModel get(String p1) {
        System.out.println("test step into get....");
        System.out.println("p1...." + p1);
        return new TestModel("hello", "world");
    }

    @RequestMapping(value = "/v1", method = RequestMethod.POST)
    public TestModel post(String p1, String p2) {
        System.out.println("test step into post....");
        System.out.println("p1...." + p1);
        System.out.println("p2...." + p2);
        return new TestModel("hellop", "worldp");
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String testReq() {
        wxMenuService.loadAndPushWxMenu();
        return "success";
    }
}