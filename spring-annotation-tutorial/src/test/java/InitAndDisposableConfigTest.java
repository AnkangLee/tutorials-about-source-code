import dev.ankang.lifecycle.InitAndDisposableConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class InitAndDisposableConfigTest {

    @Test
    public void testLifeCycleConfig() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(InitAndDisposableConfig.class);
        System.out.println("容器创建完成");
        applicationContext.close();
    }
}