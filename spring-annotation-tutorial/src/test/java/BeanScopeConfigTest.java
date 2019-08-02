import dev.ankang.beans.Person;
import dev.ankang.configs.BeanScopeConfig;
import org.junit.Assert;
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
public class BeanScopeConfigTest {

    private AnnotationConfigApplicationContext ac;

    @Before
    public void setUp() throws Exception {
        ac = new AnnotationConfigApplicationContext(BeanScopeConfig.class);
    }

    /**
     * 当作用域为单例的时候，
     * IOC容器在启动的时候，就会将容器中所有作用域为单例的bean的实例给创建出来；
     * 以后的每次获取，就直接从IOC容器中来获取，相当于是从map.get()的一个过程
     */
    @Test
    public void testDefaultScope() {
        Person person = (Person) ac.getBean("person");
        Person duplication = (Person) ac.getBean("person");

        Assert.assertEquals(person, duplication);
    }

    /**
     * 当作用域为多例的时候，
     * IOC容器启动的时候，并不会去创建bean的实例，
     * 当我们调用getBean()获取的时候去创建bean的实例；
     * 而且每次调用的时候，都会创建bean的实例
     */
    @Test
    public void testCustomScope() {
        Person child = (Person) ac.getBean("childen");
        Person anotherChild = (Person) ac.getBean("childen");

        Assert.assertNotEquals(child, anotherChild);
    }
}
