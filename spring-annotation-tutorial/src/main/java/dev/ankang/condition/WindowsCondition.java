package dev.ankang.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * description :
 * last-modified : 2019-08-01
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class WindowsCondition implements Condition {

    /**
     * ConditionContext : 判断条件能使用的上下文(环境)
     * AnnotatedTypeMetadata : 注释信息
     *
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //能获取当前环境的信息
        Environment environment = context.getEnvironment();

        //获取操作系统
        String property = environment.getProperty("os.name");
        if (property.contains("Windows")) {
            return true;
        }
        return false;
    }
}
