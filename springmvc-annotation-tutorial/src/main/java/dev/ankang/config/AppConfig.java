package dev.ankang.config;

import dev.ankang.interceptor.MyFirstInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

@ComponentScan(value = "dev.ankang", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
}, useDefaultFilters = false)
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {
        //将SpringMVC处理不了的请求交给tomcat，专门针对于静态资源的，这个时候，静态资源就是可以访问的
        defaultServletHandlerConfigurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //我们也可以自己来写规则
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyFirstInterceptor()).addPathPatterns("/**");
    }
}
