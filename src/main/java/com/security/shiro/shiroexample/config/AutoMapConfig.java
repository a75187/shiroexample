package com.security.shiro.shiroexample.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.security.shiro.shiroexample.mybatis.mapper.scanner.MapperScannerConfigurer;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
 import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;

import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by yoara on 2017/8/23.
 */
@Configuration
public class AutoMapConfig {

    @Bean(name="mysqlCreateScheduler")
    public ScheduledExecutorService mysqlCreateScheduler(){
        ScheduledExecutorFactoryBean scheduledExecutorFactoryBean = new ScheduledExecutorFactoryBean();
        scheduledExecutorFactoryBean.setPoolSize(50);
        return scheduledExecutorFactoryBean.getObject();
    }

    @Bean(name="mysqlDefaultDataSource",initMethod = "init",destroyMethod = "close")
    public DruidDataSource mysqlDefaultDataSource(){
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://172.16.62.139:3307/user");
        source.setUsername("root");
        source.setPassword("root");
        source.setInitialSize(10);
        source.setMinIdle(10);
        source.setMaxActive(1000);
        source.setMaxWait(30000);
        source.setTimeBetweenEvictionRunsMillis(300000);
        source.setMinEvictableIdleTimeMillis(30000);
        source.setPoolPreparedStatements(false);
        Properties properties = new Properties();
        properties.setProperty("druid.stat.sql.MaxSize","3000");
        source.setConnectProperties(properties);
        source.setValidationQuery("select 'x'");

        source.setCreateScheduler(mysqlCreateScheduler());
        return source;
    }

    //@Bean(name="mysqlDataSource")
    public DruidDataSource mysqlDataSource(){
        DruidDataSource defaultDataSource = mysqlDefaultDataSource();
        //多库切换
        //DynamicDataSource source = new DynamicDataSource();
        //Map<Object, Object> targetDataSources =
        //        ImmutableMap.of("defaultDataSource",defaultDataSource);
        //source.setTargetDataSources(targetDataSources);
        //source.setDefaultTargetDataSource(defaultDataSource);

        return defaultDataSource;
    }

    @Bean(name="mysqlSqlSessionFactory")
    public SqlSessionFactory mysqlSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        VFS.addImplClass(SpringBootVFS.class);

        Properties properties = new Properties();
        properties.setProperty("cacheEnabled","false");
        properties.setProperty("lazyLoadingEnabled","false");
        properties.setProperty("multipleResultSetsEnabled","true");
        properties.setProperty("useColumnLabel","true");
        properties.setProperty("useGeneratedKeys","false");
        properties.setProperty("defaultExecutorType","SIMPLE");
        properties.setProperty("defaultStatementTimeout","25000");
        bean.setConfigurationProperties(properties);
        bean.setDataSource(mysqlDataSource());
        bean.setTypeAliasesPackage("com.security.shiro.shiroexample.dao");
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath*:mybatisfils/*.xml"));
        return bean.getObject();
    }

    @Bean(name="mysqlJdbcTemplate")
    public JdbcTemplate mysqlJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(mysqlDataSource());
        return jdbcTemplate;
    }

    @Bean(name="mapperScannerConfigurer")
    public MapperScannerConfigurer autoMapperScanner(){
        MapperScannerConfigurer orgMapperScanner = new MapperScannerConfigurer();
        orgMapperScanner.setBasePackage("com.security.shiro.shiroexample.dao");
        return orgMapperScanner;
    }
}
