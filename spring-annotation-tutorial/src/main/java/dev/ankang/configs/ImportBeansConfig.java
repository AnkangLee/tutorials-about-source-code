package dev.ankang.configs;

import dev.ankang.thirdparty.Blue;
import dev.ankang.thirdparty.Red;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * description : Import 快速的给容器中导入一个组件
 * last-modified : 2019-08-01
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
@Configuration
@Import({Red.class, Blue.class})
public class ImportBeansConfig {
}
