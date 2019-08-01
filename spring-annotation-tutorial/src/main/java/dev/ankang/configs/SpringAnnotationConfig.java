package dev.ankang.configs;

import dev.ankang.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description :
 * last-modified : 2019-08-01
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
@Configuration
public class SpringAnnotationConfig {


    /**
     * 相当于xml配置文件中的<bean>标签，告诉容器注册一个bean
     * 之前xml文件中<bean>标签有bean的class类型，那么现在注解方式的类型当然也就是返回值的类型
     * 之前xml文件中<bean>标签有bean的id，现在注解的方式默认用的是方法名来作为bean的id
     */
    @Bean
    public Person person() {
        return new Person("zhangsanfeng", 18);
    }

    /**
     * 通过这个value属性可以指定bean在IOC容器的id
     *
     * @return
     */
    @Bean(value = "wuji")
    public Person child() {
        return new Person("zhangwuji", 3);
    }
}
