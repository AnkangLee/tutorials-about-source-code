package dev.ankang.configs;

import dev.ankang.filters.ClassNameFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 自定义匹配规则FilterType.CUSTOM
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
@ComponentScan(value = "dev.ankang", includeFilters = {
        @ComponentScan.Filter(
                type = FilterType.CUSTOM,
                classes = {
                        ClassNameFilter.class
                })
}, useDefaultFilters = false)
@Configuration
public class ComponentScanWithCustomTyperFilter {
}
