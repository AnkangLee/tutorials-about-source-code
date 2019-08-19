package dev.ankang.configs;

import dev.ankang.thirdparty.Blue;
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
@Import({Blue.class, ClassNameImportSelector.class})
public class ClassNameImportSelectorConfig {
}
