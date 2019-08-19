---
typora-copy-images-to: assets
---

# servlet3.0-与SpringMVC整合分析

1. web容器在启动的时候，会扫描每个jar包下的META-INF/services/javax.servlet.ServletContainerInitializer

2. 加载第一步中文件指定的类SpringServletContainerInitializer

   > ```java
   > org.springframework.web.SpringServletContainerInitializer
   > ```

3. spring的应用一启动会加载感兴趣的WebApplicationInitializer接口的下的所有组件

   > @HandlesTypes(WebApplicationInitializer.class)

4. 为WebApplicationInitializer组件创建对象（组件不是接口，不是抽象类）

   > ```java
   > if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) &&
   >       WebApplicationInitializer.class.isAssignableFrom(waiClass)) {
   >       initializers.add((WebApplicationInitializer) waiClass.newInstance());
   > }
   > ```

5. WebApplicationInitializer的继承关系图

![](.\assets\AbstractContextLoaderInitializer.png)

- AbstractContextLoaderInitializer#createRootApplicationContext() 创建根容器
- AbstractDispatcherServletInitializer#registerDispatcherServlet()
  1. createServletApplicationContext() 创建web的ioc容器
  2. createDispatcherServlet() 创建DispatcherServlet
  3. servletContext.addServlet(servletName, dispatcherServlet) 注册DispatcherServlet
- AbstractAnnotationConfigDispatcherServletInitializer: 注解方式配置的DispatcherServlet初始化器
  - createRootApplicationContext() 根据传入**getRootConfigClasses()** 创建根容器
  - createServletApplicationContext() 根据传入**getServletConfigClasses()** 创建web的ioc容器

  
  

#### 总结

以注解方式来启动SpringMVC；

1. 继承AbstractAnnotationConfigDispatcherServletInitializer
2. 实现抽象方法指定DispatcherServlet的配置信息

