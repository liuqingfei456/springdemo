package com.weiyi.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.weiyi.pojo.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * profile：
 *        spring为我们提供可以根据当前环境，动态的激活和切换一系列组建的功能；
 * 开发环境，测试环境，生产环境
 * 数据源 A,B,C
 *
 * @Profile 指定组建在哪个环境的情况下才能被注册到容器，不指定，任何环境下都能注册这个组建
 *
 * 1）加了环境标识的bean，只有这个环境被激活的时候 才能注册到容器中，默认是default环境
 * 2) 注解加载配置类上 只有环境被激活，整个配置类才会被注册到容器中
 * 3) 没有标注环境标识的bean在，任何环境下都是加载的
 */
@PropertySource("classpath:/dbConfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {
    @Value("{db.user}")
    private String user;
    private StringValueResolver valueResolver;
    private String driverClass;

    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }
    @Profile("test")
    @Bean("dataSourceTest")
    public DataSource dataSourceTest(@Value("{db.password}") String passedword) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(passedword);
        dataSource.setJdbcUrl("jdbc:mysql://47.93.218.60:3306/test");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
    @Profile("dev")
    @Bean("dataSourceDev")
    public DataSource dataSourceDev(@Value("{db.password}") String passedword) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(passedword);
        dataSource.setJdbcUrl("jdbc:mysql://47.93.218.60:3306/authplat");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
    @Profile("pro")
    @Bean("dataSourcePro")
    public DataSource dataSourcePro(@Value("{db.password}") String passedword) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(passedword);
        dataSource.setJdbcUrl("jdbc:mysql://47.93.218.60:3306/rhcms");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        valueResolver=resolver;
        driverClass = valueResolver.resolveStringValue("com.mysql.jdbc.Driver");
    }
}
