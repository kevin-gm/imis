package site.imis.wx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by kevin无道 on 2017/8/17.
 */
@EnableScheduling
@Configuration
@ComponentScan(basePackages = "xyz.coloured.imis.wx.schedule")
public class ScheduleConfig {


}