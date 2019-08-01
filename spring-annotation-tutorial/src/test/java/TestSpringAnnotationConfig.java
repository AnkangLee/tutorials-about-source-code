import dev.ankang.beans.Person;
import dev.ankang.configs.SpringAnnotationConfig;
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
public class TestSpringAnnotationConfig {

    private AnnotationConfigApplicationContext ac;

    @Before
    public void initSpringContext() {
        ac = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
    }

    /**
     * 注解的方式使用spring
     * <p>
     * 这里是new了一个AnnotationConfigApplicationContext对象，以前new的ClassPathXmlApplicationContext对象
     * 的构造函数里面传的是配置文件的位置，而现在AnnotationConfigApplicationContext对象的构造函数里面传的是
     * 配置类的类型
     */
    @Test
    public void testSpringAnnotationConfig() {
        System.out.println(ac.getBean("person"));
    }

    /**
     * 获取spring容器中bean的定义信息
     */
    @Test
    public void testGetBeanNamesForTypeFromSpring() {
        String[] names = ac.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
    }

}
