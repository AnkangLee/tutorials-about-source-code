package dev.ankang.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * ComponentScan 可以指定包含哪些组件, 里面传是一个 {@link ComponentScan.Filter}[]数组
 * FilterType.ANNOTATION表示的包含的规则 ：按照注解的方式来进行排除
 * classes = {Controller.class,Service.class}表示的是标有这些注解的类给纳入 spring 管理
 *
 * 在用xml文件配置的方式来进行配置的时候，还要禁用掉默认的配置规则，只包含哪些组件的配置才能生效
 * <context:component-scan base-package=“dev.ankang” use-default-filters=“false”/>
 * 在 ComponentScan 注解中可以用 useDefaultFilters = false
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
@ComponentScan(value = "dev.ankang", includeFilters = {
        @ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                classes = {
                        Controller.class,
                        Service.class
                }
        )
}, useDefaultFilters = false)
@Configuration
public class ComponentScanWithIncludeFilters {
}
