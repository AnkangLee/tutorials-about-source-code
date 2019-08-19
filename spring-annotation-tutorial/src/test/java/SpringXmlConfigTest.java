import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description :
 * last-modified : 2019-08-01
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class SpringXmlConfigTest {


    /**
     * xml 文件配置的方式使用spring
     */
    @Test
    public void testSpringXmlConfig() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(ac.getBean("person"));
    }
}
