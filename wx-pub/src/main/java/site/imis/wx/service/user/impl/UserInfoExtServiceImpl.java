package site.imis.wx.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.imis.wx.model.user.UserInfoExt;
import site.imis.wx.repository.user.UserInfoExtRepository;
import site.imis.wx.service.user.UserInfoExtService;

/**
 * Created by kevin无道 on 2017/8/17.
 */
@Service
public class UserInfoExtServiceImpl implements UserInfoExtService {

    @Autowired
    private UserInfoExtRepository userInfoExtRepository;

    public void listUsersBirthInfo(int interval) {
        //获取生日符合条件的，阴历阳历用union
        UserInfoExt infoExt = userInfoExtRepository.findByUserId("kevin");
        System.out.println(infoExt.getBirthday());
    }
}