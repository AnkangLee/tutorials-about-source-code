package dev.ankang.lifecycle;

import dev.ankang.beans.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class LifeCycleConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car("benz");
    }

    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car linken() {
        return new Car("linken");
    }

}
