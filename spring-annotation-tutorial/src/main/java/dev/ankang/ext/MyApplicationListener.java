package dev.ankang.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


/**
 * ApplicationListener：监听容器中发布的事件。事件驱动模型开发
 * public interface ApplicationListener<E extends ApplicationEvent>
 * 监听 ApplicationEvent 及其下面的子事件
 *
 *
 * 使用步骤：
 *
 * 1. 写一个监听器（ApplicationListener实现类）来监听某个事件（ApplicationEvent及其子类）
 *     @EventListener;
 *     原理：使用EventListenerMethodProcessor处理器来解析方法上的@EventListener；
 *
 * 2. 把监听器加入到容器；
 *
 * 3. 只要容器中有相关事件的发布，我们就能监听到这个事件；
 *    ContextRefreshedEvent：容器刷新完成（所有bean都完全创建）会发布这个事件；
 *    ContextClosedEvent：关闭容器会发布这个事件；
 *
 * 4. 发布一个事件：
 *    applicationContext.publishEvent()；
 *
 *
 * 事件发布流程：
 * 1. 发布事件
 *    publishEvent(new ContextRefreshedEvent(this));
 *
 * 2. 获取多播器
 *    getApplicationEventMulticaster()
 *
 * 3. 派发事件
 *    multicastEvent(applicationEvent, eventType)
 *    1. 获取所有的监听器
 *        getApplicationListeners(event, type)
 *
 *    2. 如果有Executor，可以支持使用Executor进行异步派发
 *       否则使用同步的方式直接执行listener方法
 *       listener.onApplicationEvent(event);
 *
 *
 * 事件多播器：
 *
 * 1. 创建容器 refresh();
 *
 * 2. initApplicationEventMulticaster
 *
 * 3. 判断容器中是否有applicationEventMulticaster，如果没有则新建一个加入容器
 *    this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *
 * 监听器注册：
 *
 * 1. 创建容器 refresh();
 *
 * 2. registerListeners
 *
 * 3. 根据类型拿到所有的监听器然后加入applicationEventMulticaster
 *    getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    //当容器中发布次事件，方法触发
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到的事件" + event);
    }
}
