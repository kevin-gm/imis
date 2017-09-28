package site.imis.wx.repository.user;

import site.imis.wx.model.user.UserBirthInfoPush;
import site.imis.wx.model.user.UserInfoExt;
import site.imis.wx.qo.user.BirthDateQO;

import java.util.List;

/**
 * Created by kevin无道 on 2017/8/17.
 */
public interface UserInfoExtRepository {

    UserInfoExt findByUserId(String userId);

    /**
     * 查询日期范围内生日的用户列表<br/>
     * 阳历与阴历生日需业务逻辑判断处理，减少SQL的逻辑
     * @param birthDateQO 查询对象
     * @return
     */
    List<UserBirthInfoPush> findBirthBetweenMonthDay(BirthDateQO birthDateQO);
}