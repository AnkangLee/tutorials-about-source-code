import dev.ankang.lifecycle.LifeCycleConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class LifeCycleConfigTest {

    @Test
    public void testLifeCycleConfig() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("容器创建完成");
        applicationContext.close();
    }

    @Test
    public void testLifeCycleConfig4Prototype() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("容器创建完成");
        applicationContext.getBean("linken");
        applicationContext.close();
    }
}