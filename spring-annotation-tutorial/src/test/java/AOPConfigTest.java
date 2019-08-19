import dev.ankang.aop.MathCalculator;
import dev.ankang.configs.AOPConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPConfigTest {

    @Test
    public void testAop(){

        /**
         * 1. @EnableAspectJAutoProxy 开启AOP功能
         *
         * 2. @EnableAspectJAutoProxy 会给容器中注册一个后置处理器 AnnotationAwareAspectJAutoProxyCreator
         *
         * 3. 容器的创建流程registerBeanPostProcessors() 注册后置处理器
         *    - 创建AnnotationAwareAspectJAutoProxyCreator对象
         *
         * 4. 容器的创建流程finishBeanFactoryInitialization() 初始化剩下的单实例bean
         *    - 创建业务逻辑组件和切面组件
         *    - AnnotationAwareAspectJAutoProxyCreator拦截组件的创建过程
         *    - 组件创建完之后，判断组件是否需要增强, 如果是则将切面的通知方法包装成增强器（Advisor）并创建业务逻辑组件的代理对象
         *
         * 5. 执行目标方法
         *    - CglibAopProxy.intercept()
         *      - 得到目标方法的拦截器链（增强器包装成拦截器MethodInterceptor）
         *      - 利用拦截器的链式机制，依次进入每一个拦截器进行执行
         */
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);

        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);

        mathCalculator.div(1, 1);
    }
}