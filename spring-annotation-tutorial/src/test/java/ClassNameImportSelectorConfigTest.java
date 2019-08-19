import dev.ankang.configs.ClassNameImportSelectorConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class ClassNameImportSelectorConfigTest {

    private AnnotationConfigApplicationContext ac;

    @Before
    public void initSpringContext() {
        ac = new AnnotationConfigApplicationContext(ClassNameImportSelectorConfig.class);
    }

    @Test
    public void testConditionalBeanConfig() {
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

}