package dev.ankang.configs;

import dev.ankang.beans.ColorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
@Configuration
public class FactoryBeanConfig {
    /**
     * 给容器中注册组件：
     * 1）扫描+组件标注注解（@Controller/@Service/@Repository/@Component）
     * 【局限于要求是自己写的类，如果导入的第三方没有添加这些注解，那么就注册不上了】
     * <p>
     * 2）@Bean[导入的第三方包里面的组件]
     * 3）@Import[快速的给容器中导入一个组件]
     * （1）@Import(要导入容器中的组件);容器中就会自动的注册这个组件，id默认是全类名
     * （2）ImportSelector ：返回需要的组件的全类名的数组；
     * （3）ImportBeanDefinitionRegistrar : 手动注册bean到容器中
     * <p>
     * 4）使用Spring提供的FactoryBean（工厂bean）
     * （1）默认获取到的是工厂bean调用getObject创建的对象
     * （2）要获取工厂bean本身，我们需要给id前面加上一个“&”符号：&colorFactoryBean
     */
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }
}
