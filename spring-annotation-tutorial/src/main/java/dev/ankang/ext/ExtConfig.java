package dev.ankang.ext;

import dev.ankang.thirdparty.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("dev.ankang.ext")
public class ExtConfig {

    @Bean
    public Blue blue() {
        return new Blue();
    }
}
