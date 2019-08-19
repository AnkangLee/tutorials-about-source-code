import dev.ankang.beans.Person;
import dev.ankang.configs.ConditionalBeanConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * description :
 * last-modified : 2019-08-01
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class ConditionalBeanConfigTest {

    private AnnotationConfigApplicationContext ac;

    @Before
    public void initSpringContext() {
        ac = new AnnotationConfigApplicationContext(ConditionalBeanConfig.class);
    }

    /**
     * 测试时候需要配置环境变量 -Dos.name=linux
     */
    @Test
    public void testConditionalBeanConfig() {
        Map<String, Person> persons = ac.getBeansOfType(Person.class);
        persons.values().forEach(System.out::println);
    }

}
