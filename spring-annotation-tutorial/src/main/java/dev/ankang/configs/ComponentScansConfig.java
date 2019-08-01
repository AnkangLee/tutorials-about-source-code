package dev.ankang.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

/**
 * ComponentScan这个注解是可以重复定义的：来指定不同的扫描策略
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
@Configuration
@ComponentScans(value = {
        @ComponentScan(value = "dev.ankang", includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = {
                                Service.class
                        })
        }, useDefaultFilters = false),
        @ComponentScan(value = "dev.ankang", includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        classes = {
                                SpringAnnotationConfig.class
                        }
                )
        }, useDefaultFilters = false)

})
public class ComponentScansConfig {
}
