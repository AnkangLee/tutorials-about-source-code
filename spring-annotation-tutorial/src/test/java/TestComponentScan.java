import dev.ankang.configs.ComponentScanConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * description :
 * last-modified : 2019-08-01
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class TestComponentScan {

    private AnnotationConfigApplicationContext ac;

    @Before
    public void initSpringContext() {
        ac = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
    }

    /**
     * 获取 spring 容器中的所有 beans
     * 这里会扫描到带 @Configuration 注解的类，原因是 {@link Configuration} 被 {@link Component} 注解过
     */
    @Test
    public void testComponentScan() {
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
