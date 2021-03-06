import dev.ankang.configs.*;
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
public class ComponentScanTest {

    /**
     * 获取 spring 容器中的所有 beans
     * 这里会扫描到带 @Configuration 注解的类，原因是 {@link Configuration} 被 {@link Component} 注解过
     */
    @Test
    public void testComponentScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    /**
     * 获取 spring 容器中的所有 beans
     */
    @Test
    public void testComponentScanWithExcludeFilters() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanWithExcludeFilters.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    /**
     * 获取 spring 容器中的所有 beans
     */
    @Test
    public void testComponentScanWithIncludeFilters() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanWithIncludeFilters.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void testComponentScans() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScansConfig.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void testComponentScanWithCustomTyperFilter() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentScanWithCustomTyperFilter.class);
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}
