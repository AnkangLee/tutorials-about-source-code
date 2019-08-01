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

    @Bean
    public Person person(){
        return new Person("zhangsanfeng", 18);
    }
}
