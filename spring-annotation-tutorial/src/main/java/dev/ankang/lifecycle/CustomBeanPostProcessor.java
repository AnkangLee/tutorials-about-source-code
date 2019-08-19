package dev.ankang.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {

    /**
     * 调用getBeanPostProcessors()方法找到容器里面的所有的BeanPostProcessor，挨个遍历，
     * 调用BeanPostProcessor的postProcessBeforeInitialization方法，
     * 一旦调用postProcessBeforeInitialization方法的返回值为null的时候，就直接跳出遍历，
     * 后面的BeanPostProcessor 的postProcessBeforeInitialization也就不会执行了
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization..." + beanName + "=>" + bean);
        return bean;
    }


    /**
     * 调用getBeanPostProcessors()方法找到容器里面的所有的BeanPostProcessor，挨个遍历，
     * 调用BeanPostProcessor的postProcessAfterInitialization方法，
     * 一旦调用postProcessAfterInitialization方法的返回值为null的时候，就直接跳出遍历，
     * 后面的BeanPostProcessor 的postProcessAfterInitialization也就不会执行了
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization..." + beanName + "=>" + bean);
        return bean;
    }
}
