package com.grpc.server.config.datasourceconfig;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * sqlSessionFactoryRef用来指定注入一个数据源
 */
@Configuration
@MapperScan(basePackages = "com.grpc.server.dao.impl", sqlSessionFactoryRef = TestDatasourceConfig.SQL_SESSION)
public class TestDatasourceConfig {

    public static final String SQL_SESSION = "testSqlSession";

    @Value("${spring.datasource.connection-timeout}")
    private long connectionTimeout;

    @Value("${spring.datasource.maximum-pool-size}")
    private int maximumPoolSize;

    @Value("${spring.datasource.max-idle}")
    private int maxIdle;

    @Value("${spring.datasource.min-idle}")
    private int minIdle;

    @Value("${spring.datasource.validation-timeout}")
    private int validationTimeout;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public HikariConfig testHikariConfig(){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setConnectionTimeout(connectionTimeout);
        hikariConfig.setMaximumPoolSize(maximumPoolSize);
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setPoolName("test");
        return hikariConfig;
    }

    @Bean
    public DataSource testDatasource(){
        return new HikariDataSource(testHikariConfig());
    }

    @Bean(name = TestDatasourceConfig.SQL_SESSION)
    public SqlSessionFactory getSqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(testDatasource());
        //设置下划线转驼峰
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactoryBean.getObject();
    }

}
