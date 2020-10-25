package com.weiyi.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 声明式事物
 * 环境搭建：
 * 1。导入相关依赖
 * 数据源，数据库驱动，spring-jdbc模块
 * 2。配置数据源，jdbcTemplate(spring提供的简化数据库操作的工具)操作数据
 * 3。给方法上标注表示@Transactional当前方法是一个事务方法
 * 4。@EnableTransactionManagement开启基于注解的事务管理功能
 * 5。配置事务管理器PlatformTransactionManager来控制事务
 *
 *
 * 原理：
 * 1。@EnableTransactionManagement
 *       利用@Import(TransactionManagementConfigurationSelector.class)给容器导入两个组件
 *       AutoProxyRegistrar
 *       ProxyTransactionManagementConfiguration
 * 2。AutoProxyRegistrar 做了什么：
 *       给容器中注册一个InfrastructureAdvisorAutoProxyCreator组件；
 *       InfrastructureAdvisorAutoProxyCreator:？
 *       利用后置处理器机制在对象创建以后，包装对象，返回一个代理对象(增强器)，代理对象利用拦截器链进行调用
 * 3。ProxyTransactionManagementConfiguration 做了什么：
 *       1。给容器中注册事务增强器，事务增强器要用事务注解的信息，AnnotationTransactionAttributeSource解析事务注解
 *       2。事务拦截器：
 *          TransactionInterceptor：保存了事务属性信息，事务管理器；他是一个MethodInterceptor
 *          在目标方法执行的时候；
 *             执行拦截器链；
 *             事务拦截器：
 *                 1。先获取事务相关的属性
 *                 2。在获取PlatformTransactionManager，如果事先没有添加指定任何transactionManager，
 *                    最终会从容器中按照类型获取一个PlatformTransactionManager；
 *                 3。执行目标方法
 *                    如果异常，获取到事务管理器，利用事务管理器进行回滚操作；
 *                    如果正常，利用事务管理器，提交事务；
 *
 */
@EnableTransactionManagement
@ComponentScan(value = {"com.weiyi.tx"})
@Configuration
public class TxConfig {
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("histmysqlallinmd");
        dataSource.setJdbcUrl("jdbc:mysql://47.93.218.60:3306/test");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        //spring对@Configuration类会特殊处理，给容器中加组件的方法，多次调用只会从容器中找组件而已
        return new JdbcTemplate(dataSource());
    }
    @Bean
    public PlatformTransactionManager platformTransactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());

    }
}
