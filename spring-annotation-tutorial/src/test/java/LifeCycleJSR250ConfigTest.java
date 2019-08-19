import dev.ankang.lifecycle.LifeCycleJSR250Config;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class LifeCycleJSR250ConfigTest {

    @Test
    public void testLifeCycleConfig() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleJSR250Config.class);
        System.out.println("容器创建完成");
        applicationContext.close();
    }
}