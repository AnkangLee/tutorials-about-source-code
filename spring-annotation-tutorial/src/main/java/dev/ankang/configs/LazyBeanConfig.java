package dev.ankang.configs;

import dev.ankang.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * description :
 * last-modified : 2019-08-01
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
@Configuration
public class LazyBeanConfig {


    /**
     * 作用域为单例的bean
     * 默认在容器启动的时候创建实例对象
     * @return
     */
    @Bean
    public Person person() {
        System.out.println("init person...");
        Person person = new Person("zhangsanfeng", 18);
        return person;
    }

    /**
     * 使用 Lazy 注解，
     * 当我们调用了getBean()方法获取的时候，bean的实例对象才会被创建
     */
    @Lazy
    @Bean
    public Person children() {
        System.out.println("init child...");
        Person child = new Person("wahaha", 3);
        return child;
    }
}
