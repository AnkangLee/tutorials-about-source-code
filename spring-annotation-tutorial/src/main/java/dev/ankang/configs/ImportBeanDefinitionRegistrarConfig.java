package dev.ankang.configs;

import dev.ankang.thirdparty.Green;
import dev.ankang.thirdparty.Red;
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
@Import(value = {Red.class, Green.class, CustomImportBeanDefinitionRegistrar.class})
public class ImportBeanDefinitionRegistrarConfig {
}
