package site.imis.wx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by kevin无道 on 2017/8/16.
 */
@SpringBootApplication
@MapperScan(basePackages = {"xyz.coloured.imis.wx.repository"})
public class WxApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxApplication.class, args);
    }
}