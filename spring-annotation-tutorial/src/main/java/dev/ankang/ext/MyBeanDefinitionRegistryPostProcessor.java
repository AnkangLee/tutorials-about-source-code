package dev.ankang.ext;

import dev.ankang.thirdparty.Blue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry();
 *
 * 在所有bean定义信息将要被加载，bean实例还未创建的时候，优先于BeanFactoryPostProcessor执行(见原理分析3.4两步)
 * 可以利用BeanDefinitionRegistryPostProcessor给容器中再额外添加一些组件
 *
 * 原理：
 * 1. ioc容器初始化
 *    // Invoke factory processors registered as beans in the context.
 *    invokeBeanFactoryPostProcessors(beanFactory);
 *
 * 2. 获取所有的 BeanFactoryPostProcessor
 *    getBeanFactoryPostProcessors()
 *
 * 3. 执行BeanDefinitionRegistryPostProcessor的postProcessBeanDefinitionRegistry方法
 *    invokeBeanDefinitionRegistryPostProcessors(currentRegistryProcessors, registry);
 *
 * 4. 执行BeanFactoryPostProcessor的postProcessBeanFactory方法
 *    invokeBeanFactoryPostProcessors(nonOrderedPostProcessors, beanFactory);
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {


    /**
     * Modify the application context's internal bean definition registry after its
     * standard initialization. All regular bean definitions will have been loaded,
     * but no beans will have been instantiated yet. This allows for adding further
     * bean definitions before the next post-processing phase kicks in.
     * @param registry the bean definition registry used by the application context
     * @throws org.springframework.beans.BeansException in case of errors
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量" + registry.getBeanDefinitionCount());
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Blue.class);
        registry.registerBeanDefinition("newBlue", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanDefinitionRegistryPostProcessor...bean的数量" + beanFactory.getBeanDefinitionCount());

    }
}
