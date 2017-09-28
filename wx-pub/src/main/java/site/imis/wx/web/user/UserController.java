package site.imis.wx.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.imis.wx.service.user.UserInfoExtService;
import site.imis.wx.service.user.UserInfoPushService;

/**
 * Created by kevin无道 on 2017/8/16.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserInfoExtService userInfoExtService;
    @Autowired
    private UserInfoPushService userInfoPushService;

    @RequestMapping(value = "/birth/all")
    public void getBirthAll() {
        System.out.println("test step into....");
        userInfoExtService.listUsersBirthInfo(1);
        userInfoPushService.listBirthInfo();
    }


}