package dev.ankang;

import dev.ankang.config.AppConfig;
import dev.ankang.config.RootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{AppConfig.class};
    }

    //  /:拦截所有请求（包括静态资源（xx.js,xx.png），但是不包括*.jsp）
    //  /*:拦截所有请求，连*.jsp页面都拦截；jsp页面是tomcat引擎解析的
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
