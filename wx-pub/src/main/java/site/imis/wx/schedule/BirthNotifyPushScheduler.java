package site.imis.wx.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by kevin无道 on 2017/8/17.
 */
@Component
public class BirthNotifyPushScheduler {

    @Scheduled(cron = "1 0 0 */5 * *")
    public void loadAndPushUsersBirthInfo() {
        //获取所有符合条件的用户信息
    }
}