package dev.ankang.tx;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


/**
 * 声明式事务
 *
 * 1. 导入相关依赖：数据源、数据库驱动、Spring-jdbc模块
 * 2. 配置数据源、JdbcTemplate（Spring提供简化数据库操作的工具）操作数据
 * 3. 给方法上标注@Transactional注解表示当前的方法是一个事务方法
 * 4. @EnableTransactionManagement 开启基于注解的事务管理功能
 * 5. 配置事务管理器来控制事务
 */

/**
 * 原理分析
 *
 * 1. @EnableTransactionManagement
 *    利用注解导入的TransactionManagementConfigurationSelector 为容器导入两个组件
 *    AutoProxyRegistrar.class 和 ProxyTransactionManagementConfiguration.class
 *
 * 2. AutoProxyRegistrar 为容器注入 InfrastructureAdvisorAutoProxyCreator
 *    实现了SmartInstantiationAwareBeanPostProcessor，利用 postProcessAfterInitialization 返回一个代理对象
 *
 * 3. ProxyTransactionManagementConfiguration
 *    1. 注入 事务增强器 internalTransactionAdvisor
 *    2. 注入 事务属性信息 AnnotationTransactionAttributeSource
 *    3. 注入 事务拦截器 TransactionInterceptor implements MethodInterceptor (实现了方法拦截器接口)
 *
 * 4. TransactionInterceptor 的流程
 *    1. getTransactionAttributeSource().getTransactionAttribute(method, targetClass); 获取事务属性信息
 *    2. determineTransactionManager(txAttr); 如果没有指定，返回beanFactory.getBean(PlatformTransactionManager.class);
 *    3. invocation.proceedWithInvocation(); 执行目标方法
 *       - 抛异常 completeTransactionAfterThrowing(txInfo, ex);
 *         直接回滚事务 txInfo.getTransactionManager().rollback(txInfo.getTransactionStatus());
 *
 *       - 正常返回 commitTransactionAfterReturning(txInfo);
 *         提交事务 txInfo.getTransactionManager().commit(txInfo.getTransactionStatus());
 *
 */
@ComponentScan({"dev.ankang.tx"})
@PropertySource("classpath:dbconfig.properties")
@Configuration
@EnableTransactionManagement
public class TxConfig {

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String password;

    @Value("${db.driverClass}")
    private String driverClass;

    @Value("${db.jdbcUrl}")
    private String jdbcUrl;


    //数据源
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        //Spring会的@Configuration类会做特殊的处理：给容器中添加组件，多次调用都是从容器中找组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    //注册事务管理器在容器中
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
