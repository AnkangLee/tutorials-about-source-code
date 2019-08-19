package dev.ankang.configs;

import dev.ankang.thirdparty.Blue;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 我们把所有需要添加到容器中的bean通过BeanDefinitionRegistry里面的registerBeanDefinition方法来手动的进行注册
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry               BeanDefinition注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        //判断IOC容器里面是否含有这两个组件
        boolean redBeanDef = registry.containsBeanDefinition("dev.ankang.thirdparty.Red");
        boolean greenBeanDef = registry.containsBeanDefinition("dev.ankang.thirdparty.Green");

        //如果有的话，我就把Blue的bean的实例给注册到IOC容器中
        if (redBeanDef && greenBeanDef) {
            //指定bean的定义信息，参数里面指定要注册的bean的类型：Blue.class
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Blue.class);
            //注册一个bean，并且指定bean名
            registry.registerBeanDefinition("blue", rootBeanDefinition);
        }
    }
}
