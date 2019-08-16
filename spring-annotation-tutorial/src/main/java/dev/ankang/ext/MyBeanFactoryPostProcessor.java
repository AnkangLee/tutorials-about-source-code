package dev.ankang.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;
/**
 * BeanPostProcessor：bean的后置处理器，bean创建对象初始化前后进行拦截工作的
 *
 * BeanFactoryPostProcessor：BeanFactory的后置处理器，在BeanFactory的标准初始化之后调用
 * 所有bean的定义已经保存加载到BeanFactory，但是bean的实例还未创建。
 *
 * 原理：
 * 1. ioc容器初始化
 *    // Invoke factory processors registered as beans in the context.
 *    invokeBeanFactoryPostProcessors(beanFactory);
 *
 * 2. 获取所有的 BeanFactoryPostProcessor
 *    getBeanFactoryPostProcessors()
 *
 * 4. 执行BeanFactoryPostProcessor的postProcessBeanFactory方法
 *    invokeBeanFactoryPostProcessors(nonOrderedPostProcessors, beanFactory);
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


    /**
     * Modify the application context's internal bean factory after its standard
     * initialization. All bean definitions will have been loaded, but no beans
     * will have been instantiated yet. This allows for overriding or adding
     * properties even to eager-initializing beans.
     * @param beanFactory the bean factory used by the application context
     * @throws org.springframework.beans.BeansException in case of errors
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyPostProcessorBeanFactory...");

        int count = beanFactory.getBeanDefinitionCount();
        System.out.println("当前的BeanFactory中有" + count + "个Bean");

        Stream.of(beanFactory.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
