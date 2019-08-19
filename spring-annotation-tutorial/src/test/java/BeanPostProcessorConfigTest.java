import dev.ankang.lifecycle.BeanPostProcessorConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class BeanPostProcessorConfigTest {

    /**
     * 在执行exposedObject = initializeBean(beanName, exposedObject, mbd)方法之前先调用了populateBean(beanName, mbd, instanceWrapper)
     * <p>
     * populateBean(beanName, mbd, instanceWrapper)给bean进行属性赋值
     * exposedObject = initializeBean(beanName, exposedObject, mbd) 初始化方法，在这个初始化方法内部包括了前置处理器、初始化方法、后置处理器的调用：
     * <p>
     * 前置处理器执行
     * wrappedBean = applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
     * 初始化方法执行
     * invokeInitMethods(beanName, wrappedBean, mbd);
     * 后置处理器执行
     * wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
     */
    @Test
    public void testLifeCycleConfig() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);
        System.out.println("容器创建完成");
        applicationContext.close();
    }
}