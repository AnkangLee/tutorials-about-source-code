package dev.ankang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@ComponentScan(value="dev.ankang",excludeFilters={
        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes={Controller.class})
})
public class RootConfig {
}
