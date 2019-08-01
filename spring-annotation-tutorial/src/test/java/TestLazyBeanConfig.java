import dev.ankang.beans.Person;
import dev.ankang.configs.LazyBeanConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * description :
 * last-modified : 2019-08-01
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class TestLazyBeanConfig {

    private AnnotationConfigApplicationContext ac;

    @Before
    public void setUp() throws Exception {
        ac = new AnnotationConfigApplicationContext(LazyBeanConfig.class);
        System.out.println("IOC init completed...");
    }

    @Test
    public void testBeanLifeCycle() {
        Person child = (Person) ac.getBean("children");
    }
}
