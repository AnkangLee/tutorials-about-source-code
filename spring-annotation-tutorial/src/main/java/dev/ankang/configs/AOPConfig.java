package dev.ankang.configs;

import dev.ankang.aop.LogAspects;
import dev.ankang.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * AOP三步：
 * 1. 将业务逻辑组件和切面类都加入到容器中；告诉Spring哪个是切面类（@Aspect）
 * 2. 在切面类上的每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
 * 3. 开启基于注解的aop模式；@EnableAspectJAutoProxy
 */
@EnableAspectJAutoProxy
@Configuration
public class AOPConfig {

    /**
     *  AOP:【动态代理】
     *      能在程序运行期间动态的将某段代码片段切入到指定的方法指定位置进行运行的编程方式；
     *
     *  1. 导入aop模块，Spring AOP：(spring-aspects)
     *
     *  2. 定义一个业务逻辑类（MathCalculator），在业务逻辑运行的时候将日志进行打印（方法之前、方法运行结束、包括方法出现异常等等）
     *
     *  3. 定义一个日志切面类（LogAspects）：切面类里面的方法需要动态感知MathCalculator.div运行到哪里了然后执行
     *
     *     切面类里面的方法就是通知方法：
     *       - 前置通知（@Before）：logStart，在目标方法（div）运行之前运行
     *       - 后置通知（@After）：logEnd，在目标方法（div）运行之前运行
     *       - 返回通知（@AfterReturning）：logReturn，在目标方法（div）执行返回（无论是正常返回还是异常返回）之后运行
     *       - 异常通知（@AfterThrowing）：logException，在目标方法（div）出现异常之后运行
     *       - 环绕通知（@Around）：动态代理，手动推进目标方法运行（joinPoint.procced()）
     *
     *  4. 给切面类的目标方法标注何时何地运行（通知注解）
     *
     *  5. 将切面类和业务逻辑类（目标方法所在的类）都加入到容器中；
     *
     *  6. 必须要告诉Spring哪一个类是切面类（只要给切面类上加上一个注解：@Aspect）
     *
     *  7. 给配置类中加入@EnableAspectJAutoProxy：开启基于注解的aop模式
     */


    /**
     * AOP原理：【看给容器中注册了什么组件，这个组件的功能是什么, 这个组件什么时候工作，？】
     *
     * 1. @EnableAspectJAutoProxy的作用
     *    利用@Import(AspectJAutoProxyRegistrar.class)给容器中导入AspectJAutoProxyRegistrar
     *
     *    1.1 AspectJAutoProxyRegistrar 做了什么
     *        AspectJAutoProxyRegistrar 给容器注入了自定义bean
     *          - beanName: internalAutoProxyCreator
     *          - beanDefinition: AnnotationAwareAspectJAutoProxyCreator
     *
     * 2. AnnotationAwareAspectJAutoProxyCreator的功能
     *
     *    2.1分析继承关系
     *       AnnotationAwareAspectJAutoProxyCreator 重写【initBeanFactory】
     *         ▼ AspectJAwareAdvisorAutoProxyCreator
     *             ▼ AbstractAdvisorAutoProxyCreator
     *                 ▼ AbstractAdvisorAutoProxyCreator 重写setBeanFactory --> initBeanFactory
     *                     ▼ AbstractAutoProxyCreator
     *                        ▶ ProxyProcessorSupport
     *                        ▶ SmartInstantiationAwareBeanPostProcessor 继承自【BeanPostProcessor】
     *                        ▶ BeanFactoryAware 通过 setBeanFactory 注入BeanFactory
     *
     *    2.2 AnnotationAwareAspectJAutoProxyCreator 创建、注册和调用
     *
     *        1. 传入配置类，创建ioc容器
     *
     *        2. 注册配置类，调用refresh（）刷新容器
     *
     *        3. registerBeanPostProcessors(beanFactory) 注册bean的后置处理器来方便拦截bean的创建
     *           3.1 获取ioc容器中需要创建对象的所有BeanPostProcessor
     *           3.2 给容器中注入BeanPostProcessorChecker
     *           3.3 优先注册实现了PriorityOrdered接口的BeanPostProcessor
     *           3.4 再给容器中注册实现了Ordered接口的BeanPostProcessor
     *               * 注入bean名为 internalAutoProxyCreator 的 BeanPostProcessor【AnnotationAwareAspectJAutoProxyCreatorAnnotationAwareAspectJAutoProxyCreator】
     *                 1. Create bean instance.
     *                 2. populateBean 给bean的各种属性赋值
     *                 3. initializeBean 初始化bean
     *                    - invokeAwareMethods() 处理Aware接口的方法回调
     *                    - applyBeanPostProcessorsBeforeInitialization 调用 beanProcessor.postProcessBeforeInitialization
     *                    - invokeInitMethods() 执行自定义的初始化方法
     *                    - applyBeanPostProcessorsAfterInitialization 调用 beanProcessor.postProcessAfterInitialization
     *
     *           3.5 注册没实现优先级接口的BeanPostProcessor
     *           3.6 把BeanPostProcessor注册到BeanFactory中
     *
     *        4. finishBeanFactoryInitialization 完成BeanFactory初始化工作，创建剩下的单实例bean
     *
     *          【BeanPostProcessor是在Bean对象创建完成初始化前后调用的】
     *          【InstantiationAwareBeanPostProcessor是在创建Bean实例之前先尝试用后置处理器返回对象的】
     *          【AnnotationAwareAspectJAutoProxyCreator在所有bean创建之前会有一个拦截，
     *           InstantiationAwareBeanPostProcessor，会调用postProcessBeforeInstantiation()】
     *
     *           1. getBean -> doGetBean -> getSingleton -> getObject -> createBean
     *              doGetBean 先从缓存取，取不到再去调 getSingleton // Eagerly check singleton cache for manually registered singletons.
     *
     *           2. createBean->resolveBeforeInstantiation //Give BeanPostProcessors a chance to return a proxy instead of the target bean instance
     *              希望后置处理器在此能返回一个代理对象；如果能返回代理对象就使用，如果不能就 doCreateBean
     *              bean = applyBeanPostProcessorsBeforeInstantiation(targetType, beanName);
     *              if (bean != null) {
     *                  bean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
     *              }
     *           3. doCreateBean(beanName, mbdToUse, args);真正的去创建一个bean实例
     *
     *    2.3 AnnotationAwareAspectJAutoProxyCreator.InstantiationAwareBeanPostProcessor 的作用
     *        - 每一个bean创建之前，都会调用postProcessBeforeInstantiation()
     *          1. 判断当前bean是否在advisedBeans中（保存了所有需要增强bean）
     *          2. 判断当前bean是否是基础类型的Advice、Pointcut、Advisor、AopInfrastructureBean，或者是否是切面（@Aspect）
     *          3. shouldSkip
     *             - 获取候选的增强器（切面里面的通知方法）【增强器是InstantiationModelAwarePointcutAdvisor】
     *               判断每一个增强器如果是 AspectJPointcutAdvisor 类型则返回true
     *             - return false
     *
     *        - 通过 postProcessAfterInitialization 创建代理对象
     *          wrapIfNecessary(bean, beanName, cacheKey);
     *          - 获取当前bean的所有增强器（通知方法）
     *            1. 找到候选的所有的增强器（找哪些通知方法是需要切入当前bean方法的） findCandidateAdvisors
     *            2. 获取到能在bean使用的增强器 findAdvisorsThatCanApply
     *            3. 给增强器排序 sortAdvisors
     *          - 保存当前bean在advisedBeans中 advisedBeans.put
     *          - Create proxy if we have advice
     *            1. 获取所有增强器（通知方法）getAdvicesAndAdvisorsForBean
     *            2. 保存到proxyFactory proxyFactory.addAdvisors(advisors);
     *            3. createAopProxy spring自动判断创建哪种代理
     *              - JdkDynamicAopProxy
     *              - ObjenesisCglibAopProxy
     *
     *        - 给容器中返回当前组件使用cglib增强了的代理对象；
     *
     * 3. 目标方法的执行
     *
     *    1. CglibAopProxy.intercept(); 拦截目标方法的执行
     *
     *    2. 根据ProxyFactory对象获取将要执行的目标方法拦截器链
     *       List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);
     *       1. 遍历所有的增强器，将其转为Interceptor registry.getInterceptors(advisor)
     *          - 如果是MethodInterceptor，直接加入到集合中 interceptors.add((MethodInterceptor) advice);
     *          - 如果不是，使用AdvisorAdapter将增强器转为MethodInterceptor adapter.getInterceptor(advisor)
     *          - 转换完成返回MethodInterceptor数组 interceptors.toArray(new MethodInterceptor[interceptors.size()]);
     *
     *    3. 如果没有拦截器链，直接执行目标方法
     *
     *    4. 如果有拦截器链 // We need to create a method invocation...
     *       retVal = new CglibMethodInvocation(proxy, target, method, args, targetClass, chain, methodProxy).proceed();
     *
     *    5. 拦截器链的触发过程 【拦截器链的机制，保证通知方法与目标方法的执行顺序】
     *       1. 如果没有拦截器执行执行目标方法，或者拦截器的索引和拦截器数组-1大小一样（指定到了最后一个拦截器）执行目标方法
     *       2. 链式获取每一个拦截器，拦截器执行invoke方法，每一个拦截器等待下一个拦截器执行完成返回以后再来执行
     *
     */

    //将业务逻辑类加入到容器中
    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    //将切面类加入到容器中
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
