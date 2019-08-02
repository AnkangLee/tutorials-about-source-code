import dev.ankang.configs.FactoryBeanConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class FactoryBeanConfigTest {

    @Test
    public void testFactoryBeanConfig() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);

        Stream.of(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println("init completed....");
        //工厂bean获取的是调用getObject方法创建的对象
        Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型：" + colorFactoryBean.getClass());

        //如果我们就想要获取这个工厂bean，我们就可以在id的前面加上一个"&"符号
        Object colorFactoryBean2 = applicationContext.getBean("&colorFactoryBean");
        System.out.println("bean的类型：" + colorFactoryBean2.getClass());
    }
}