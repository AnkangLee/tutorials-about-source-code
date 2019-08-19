package dev.ankang.lifecycle;

import dev.ankang.beans.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
@Configuration
@ComponentScan("dev.ankang.beans")
public class InitAndDisposableConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car() {
        return new Car("BMW");
    }
}
