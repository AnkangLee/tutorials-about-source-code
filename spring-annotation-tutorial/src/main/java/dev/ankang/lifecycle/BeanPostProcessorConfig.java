package dev.ankang.lifecycle;

import dev.ankang.beans.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
@Configuration
@Import({CustomBeanPostProcessor.class})
public class BeanPostProcessorConfig {

    /**
     * bean的生命周期：bean的创建->初始化->销毁的过程
     * 容器管理bean的生命周期：
     * 我们可以自定义初始化方法和销毁的方法：容器在bean进行到当前的生命周期的时候，来调用我们自定义的初始化方法和销毁方法
     * 构造（对象创建）：
     * 单实例：在容器启动的时候创建对象
     * 多实例：在每次获取的时候来创建对象
     * 初始化方法：
     * 对象创建完成，并赋值好，调用初始化方法
     * 销毁方法：
     * 单实例的bean:在容器关闭的时候进行销毁
     * 多实例的bean:容器不会管理这个bean,容器不会调用销毁的方法
     * <p>
     * 1. 指定初始化方法和销毁方法；
     * - 我们可以通过@Bean(initMethod = "init",destroyMethod = "destroy")来指定初始化方法和销毁方法
     * 相当于xml配置文件bean标签里面的 init-method="" 和 destroy-method="" 属性
     * <p>
     * 2. 通过bean实现
     * - InitializingBean（定义初始化逻辑）
     * - DisposableBean（定义销毁逻辑）；
     * <p>
     * 3. 可以使用JSR250规范里面定义的两个注解：
     * - @PostConstruct :在bean创建完成并且属性赋值完成，来执行初始化方法
     * - @PreDestroy ：在容器销毁bean之前通知我们来进行清理工作
     * <p>
     * 4. BeanPostProcessor接口：bean的后置处理器
     * - postProcessBeforeInitialization：在初始化之前工作
     * - postProcessAfterInitialization：在初始化之后工作
     */

    @Bean(initMethod = "init")
    public Car car() {
        return new Car("benz");
    }
}
