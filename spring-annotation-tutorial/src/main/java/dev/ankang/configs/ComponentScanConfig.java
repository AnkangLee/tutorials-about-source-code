package dev.ankang.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ComponentScan("dev.ankang") 相当于是xml配置文件里面的
 * <context:component-scan base-package="dev.ankang"/>
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
@ComponentScan("dev.ankang")
@Configuration
public class ComponentScanConfig {
}
