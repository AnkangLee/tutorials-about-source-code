### Spring 的refresh()方法

1. prepareRefresh() 准备刷新

   - initPropertySources() 初始化属性设置。**空实现，子类中配置**
   - getEnvironment().validateRequiredProperties() 校验属性的合法性
   - this.earlyApplicationEvents = new LinkedHashSet<ApplicationEvent>() 保存早期的事件

2. obtainFreshBeanFactory() 获取刷新后的BeanFactory

   - refreshBeanFactory() 为beanFactory设置id

     ```java
    // 构造器中创建了一个DefaultListableBeanFactory
     public GenericApplicationContext() {
     		this.beanFactory = new DefaultListableBeanFactory();
     }
     ```
   
   - getBeanFactory() 返回GenericApplicationContext持有的BeanFactory对象
   
   - 返回beanFactory
   
3. prepareBeanFactory(beanFactory)

   - 设置BeanFactory的类加载器等
   - 注册一个后置处理器 **ApplicationContextAwareProcessor** 
   - 设置忽略自动装配特性的接口如 EnvironmentAware等（不可以通过Autowired自动注入实现类）
   - 注册可以解析的自动装配的接口如BeanFactory等（可以通过Autowired自动注入）
   - 注册一个后置处理器**ApplicationListenerDetector**
   - 添加编译时的AspectJ支持
   - 给BeanFactory中注册一些能用的组件environment、systemProperties等

4. postProcessBeanFactory在BeanFactory创建并预准备完成以后做进一步的设置 **空实现，子类中处理**

5. invokeBeanFactoryPostProcessors(beanFactory) 执行BeanFactoryPostProcessor的方法

   > BeanFactoryPostProcessor是BeanFactory的后置处理器，在BeanFactory标准初始化之后执行。
   >
   > BeanFactoryPostProcessor有一个子接口BeanDefinitionRegistryPostProcessor

   1. 执行BeanDefinitionRegistryPostProcessor的PostProcessor

      依次执行实现了PriorityOrdered->Ordered，最后执行没有实现任何接口的PostProcessor

      ```java
      postProcessor.postProcessBeanDefinitionRegistry(registry)
      ```

   2. 执行实现BeanFactoryPostProcessor的PostProcessor

      依次执行实现了PriorityOrdered->Ordered，最后执行没有实现任何接口的PostProcessor

      ```java
      postProcessor.postProcessBeanDefinitionRegistry(registry)
      ```

6. registerBeanPostProcessors**(**beanFactory**)**;注册BeanPostProcessor 拦截 bean 的创建过程

   - 获取所有的BeanPostProcessor beanFactory.getBeanNamesForType()
   - *First, register the BeanPostProcessors that implement PriorityOrdered.*
   - *Next, register the BeanPostProcessors that implement Ordered.*
   - *Now, register all regular BeanPostProcessors.*
   - Finally, re-register all internal BeanPostProcessors.* 注册所有的MergedBeanDefinitionPostProcessor
   - 最后注册一个ApplicationListenerDetector，for detecting inner beans as ApplicationListeners

7. initMessageSource

   - 获取 BeanFactory getBeanFactory()

   - 判断容器中是否一个 id 为messageSource，类型为MessageSource的组件

     - 如果有直接赋值给messageSource

     - 如果没有则创建一个DelegatingMessageSource

       > MessageSource：能按照区域信息获取出国际化配置文件中的某个key的值

   - 将上一步获取的messageSource注入到容器中，使用时候自动注入即可。

8. initApplicationEventMulticaster

   - 获取 BeanFactory getBeanFactory()
   - 判断容器中是否一个 id 为applicationEventMulticaster，类型为ApplicationEventMulticaster的组件
     - 如果有直接赋值给applicationEventMulticaster
     - 如果没有则创建一个SimpleApplicationEventMulticaster
   - 将上一步获取的applicationEventMulticaster注入到容器中，使用时候自动注入即可。

9. onRefresh 留给子类实现 // For subclasses: do nothing by default.

10. registerListeners

    - getApplicationListeners() 获取所有的ApplicationListener
    - 将监听器加入到事件派发器中 getApplicationEventMulticaster**()**.addApplicationListener**(**listener)
    - *Publish early application events* 

11. finishBeanFactoryInitialization(beanFactory) 初始化剩下的单实例bean

    > ```java
    > beanFactory.preInstantiateSingletons();
    > ```

    - 获取所有的beanNames

    - // Trigger initialization of all non-lazy singleton beans...

    - 如果实现了FactoryBean接口则调用 getBean(FACTORY_BEAN_PREFIX + beanName)

    - 否则调用getBean(beanName) 

      - ```java
        doGetBean(name, null, null, false);
        ```

      - 先从缓存中获取bean，如果获取不到再创建

        > ```java
        > Object singletonObject = this.singletonObjects.get(beanName);
        > ```

      - markBeanAsCreated(beanName) 先标记当前bean已经被创建再去创建bean

      - 获取bean定义信息 final RootBeanDefinition mbd = getMergedLocalBeanDefinition(beanName)

      - 如果当前bean依赖其他bean，则先使用getBean(dep) 创建依赖的bean

      - **开始创建bean**

        - Give BeanPostProcessors a chance to return a proxy instead of the target bean instance.

          > ```java
          > Object bean = resolveBeforeInstantiation(beanName, mbdToUse);
          > ```

          - 调用InstantiationAwareBeanPostProcessors.applyBeanPostProcessorsBeforeInstantiation 获取bean
          - 如果上一步获取到bean再调用applyBeanPostProcessorsAfterInitialization

        - 如果上一步没有返回对象则开始创建bean

          > ```java
          > Object beanInstance = doCreateBean(beanName, mbdToUse, args);
          > ```

          - 利用工厂方法或者默认构造器创建bean

          - Allow post-processors to modify the merged bean definition

            > ```java
            > applyMergedBeanDefinitionPostProcessors(mbd, beanType, beanName);
            > ```

            - 调用MergedBeanDefinitionPostProcessor.postProcessMergedBeanDefinition()

          - 属性赋值 populateBean(beanName, mbd, instanceWrapper);

            - 调用 InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation 方法
            - 调用 InstantiationAwareBeanPostProcessor.postProcessPropertyValues 方法
            - 进行属性赋值 applyPropertyValues(beanName, mbd, bw, pvs)

          - 初始化 initializeBean

            - invokeAwareMethods(beanName, bean);

            - applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);

              > ```java
              > beanProcessor.postProcessBeforeInitialization(result, beanName);
              > ```

            - invokeInitMethods(beanName, wrappedBean, mbd);

              - 调用 InitializingBean.afterPropertiesSet()
              - 调用自定义的的初始化方法 invokeCustomInitMethod(beanName, bean, mbd)

            - applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName)

              > ```java
              > beanProcessor.postProcessAfterInitialization(result, beanName);
              > ```

          - 注册bean的销毁方法

      - 将创建好的bean放入singletonObjects中缓存

12. finishRefresh()

    - initLifecycleProcessor 初始化生命周期相关的处理器
    - getLifecycleProcessor().onRefresh() 调用生命周期处理器中的onRefresh方法
    - publishEvent(new ContextRefreshedEvent(this)) 发布容器刷新完成事件
    - LiveBeansView.registerApplicationContext(this);