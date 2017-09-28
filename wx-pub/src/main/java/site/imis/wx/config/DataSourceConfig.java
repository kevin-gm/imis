/*
package xyz.coloured.imis.wx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

*/
/**
 * Created by kevin无道 on 2017/8/19.
 *//*

@Configuration
@MapperScan(basePackages = {"xyz.coloured.imis.wx.repository"})
public class DataSourceConfig {

    */
/**
     * 配置数据源
     * @return
     *//*

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Bean
    //配置事物管理
    public DataSourceTransactionManager masterTransactionManager() throws SQLException {
        return new DataSourceTransactionManager(dataSource());
    }
}*/
