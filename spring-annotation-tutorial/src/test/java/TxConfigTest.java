import dev.ankang.tx.TxConfig;
import dev.ankang.tx.services.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxConfigTest {

    @Test
    public void txTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();
    }
}