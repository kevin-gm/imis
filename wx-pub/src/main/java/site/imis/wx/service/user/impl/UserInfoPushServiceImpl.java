package site.imis.wx.service.user.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.imis.wx.repository.user.UserInfoExtRepository;
import site.imis.wx.model.user.UserBirthInfoPush;
import site.imis.wx.qo.user.BirthDateQO;
import site.imis.wx.service.user.UserInfoPushService;
import site.imis.wx.common.util.DateUtil;
import site.imis.wx.common.util.LunarUtil;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by kevin无道 on 2017/8/19.
 */
@Service
public class UserInfoPushServiceImpl implements UserInfoPushService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserInfoPushServiceImpl.class);

    @Autowired
    private UserInfoExtRepository userInfoExtRepository;

    public void listBirthInfo() {
        //获取出生日期为今天的用户
        //获取当天的月天格式，因为生日是不考虑年份的
        String todayMonthDay = DateUtil.getMonthDay(0);
        //todayMonthDay = "1-8";
        List<UserBirthInfoPush> todays = userInfoExtRepository.findBirthBetweenMonthDay(new BirthDateQO(todayMonthDay, todayMonthDay));
        LOGGER.info("阳历生日为今天的用户数量为：" + todays.size());

        //获取今天对应的农历日期，并返回其月天格式
        //获取今天对应的农历对象
        LunarUtil.Lunar luanrToday = LunarUtil.getLunarDate(LocalDate.now());
        String lunarTodayMonthDay = DateUtil.getMonthDay(LocalDate.of(luanrToday.getYear(), luanrToday.getMonth(), luanrToday.getDay()), 0);
        List<UserBirthInfoPush> todayLunar = userInfoExtRepository.findBirthBetweenMonthDay(new BirthDateQO(lunarTodayMonthDay, lunarTodayMonthDay));
        LOGGER.info("农历生日为今天的用户数量为：" + todays.size());

        //获取生日提醒配置信息，比如配置为7，则代表㤇获取本周内除今天生日的用户
        int btw = 7;

        //还需要根据配置的类型进行处理，比如可能是未来的一个月内有谁生日。
        LocalDate dateNextDay = DateUtil.getLocalDate(1);
        LocalDate dateBtwDay = DateUtil.getLocalDate(btw);

        //获取配置期限内，阳历生日的用户
        String btwMonthDayEnd = DateUtil.getMonthDay(dateBtwDay, 0);
        String btwMonthDayBegin = DateUtil.getMonthDay(dateNextDay, 0);
        //在配置期限内，即将生日的用户
        List<UserBirthInfoPush> comings = userInfoExtRepository.findBirthBetweenMonthDay(new BirthDateQO(btwMonthDayBegin, btwMonthDayEnd));
        LOGGER.info("阳历即将生日的用户数量为:" + comings.size());

        //获取配置期限内农历生日的用户
        LunarUtil.Lunar lunarNextDay = LunarUtil.getLunarDate(dateNextDay);
        LunarUtil.Lunar lunarBtwDay = LunarUtil.getLunarDate(dateBtwDay);
        String btwMonthDayLunarEnd = DateUtil.getMonthDay(LocalDate.of(lunarNextDay.getYear(), lunarNextDay.getMonth(), lunarNextDay.getDay()), 0);
        String btwMonthDayLunarBegin = DateUtil.getMonthDay(LocalDate.of(lunarBtwDay.getYear(), lunarBtwDay.getMonth(), lunarBtwDay.getDay()), 0);
        //在配置期限内，即将生日的用户
        List<UserBirthInfoPush> comingsLunar = userInfoExtRepository.findBirthBetweenMonthDay(new BirthDateQO(btwMonthDayLunarBegin, btwMonthDayLunarEnd));
        LOGGER.info("农历即将生日的用户数量为:" + comingsLunar.size());

        //格式化，并组合信息返回（包括格式化数据类型、生肖、星座、各种描述等等）
    }
}