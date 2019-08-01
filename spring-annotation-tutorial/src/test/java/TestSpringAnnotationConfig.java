import dev.ankang.configs.SpringAnnotationConfig;
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

    @Test
    /**
     * 注解的方式使用spring
     */
    public void testSpringAnnotationConfig(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
        System.out.println(ac.getBean("person"));
    }
}
