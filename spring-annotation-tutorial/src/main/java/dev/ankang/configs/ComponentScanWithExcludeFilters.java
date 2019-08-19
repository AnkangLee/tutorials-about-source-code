package dev.ankang.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * ComponentScan 可以指定要排除哪些包, 里面传是一个 {@link ComponentScan.Filter}[]数组
 * FilterType.ANNOTATION表示的排除的规则 ：按照注解的方式来进行排除
 * classes = {Controller.class,Service.class}表示的是标有这些注解的类给排除掉
 *
 * FilterType.ASSIGNABLE_TYPE表示的排除的规则 ： 指定要排除的类
 * classes = {ComponentScanConfig.class}表示的是排除ComponentScanConfig.class类
 * @author LeeAnkang
 * @version 1.0.0
 */
@ComponentScan(value = "dev.ankang", excludeFilters = {
        @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = {
                        Controller.class,
                        Service.class
                }
        ),
        @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = {
                        ComponentScanConfig.class
                }
        )
})
@Configuration
public class ComponentScanWithExcludeFilters {
}
