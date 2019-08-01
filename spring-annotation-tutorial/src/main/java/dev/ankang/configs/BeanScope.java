package dev.ankang.configs;

import dev.ankang.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * description : Scope这个注解来指定作用域的范围：这个就相当于在xml文件中配置的<bean>标签里面指定scope=“prototype” 属性
 * last-modified : 2019-08-01
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
@Configuration
public class BeanScope {

    @Bean
    public Person person() {
        System.out.println("init person...");
        Person person = new Person("zhangsanfeng", 18);
        return person;
    }

    @Bean
    @Scope("prototype")
    public Person childen() {
        System.out.println("init child...");
        Person child = new Person("wahaha", 3);
        return child;
    }
}
