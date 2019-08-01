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

    /**
     * 注解的方式使用spring
     *
     * 这里是new了一个AnnotationConfigApplicationContext对象，以前new的ClassPathXmlApplicationContext对象
     * 的构造函数里面传的是配置文件的位置，而现在AnnotationConfigApplicationContext对象的构造函数里面传的是
     * 配置类的类型
     */
    @Test
    public void testSpringAnnotationConfig(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
        System.out.println(ac.getBean("person"));
    }


}
