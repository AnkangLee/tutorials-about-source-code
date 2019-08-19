package dev.ankang.configs;

import dev.ankang.beans.Person;
import dev.ankang.condition.LinuxCondition;
import dev.ankang.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * description :
 * last-modified : 2019-08-01
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
@Configuration
public class ConditionalBeanConfig {

    @Bean("bill")
    @Conditional({WindowsCondition.class})
    public Person windowsFather() {
        return new Person("Bill Gates", 62);
    }

    @Bean("linus")
    @Conditional({LinuxCondition.class})
    public Person linuxFather() {
        return new Person("linus", 48);
    }
}
