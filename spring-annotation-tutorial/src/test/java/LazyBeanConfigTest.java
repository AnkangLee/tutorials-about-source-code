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
public class LazyBeanConfigTest {

    private AnnotationConfigApplicationContext ac;

    @Before
    public void setUp() throws Exception {
        ac = new AnnotationConfigApplicationContext(LazyBeanConfig.class);
        System.out.println("IOC init completed...");
    }

    /**
     * 当bean的作用域为多例的时候，
     * 在获取的时候，才会创建对象
     * 在IOC容器关闭的时候，不进行销毁
     */
    @Test
    public void testBeanLifeCycle() {
        Person child = (Person) ac.getBean("children");
    }
}
