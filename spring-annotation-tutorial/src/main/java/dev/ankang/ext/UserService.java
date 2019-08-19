package dev.ankang.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserService {


    /**
     * <p>Processing of {@code @EventListener} annotations is performed via
     * the internal {@link EventListenerMethodProcessor} bean which gets
     * registered automatically when using Java config or manually via the
     * {@code <context:annotation-config/>} or {@code <context:component-scan/>}
     * element when using XML config.
     *
     * EventListenerMethodProcessor原理
     *
     * 1. IOC 容器创建
     *
     * 2. 初始化剩下的单实例bean // Instantiate all remaining (non-lazy-init) singletons.
     *    finishBeanFactoryInitialization(beanFactory);
     *
     * 3. 创建单实例bean之后调用EventListenerMethodProcessor.afterSingletonsInstantiated()
     *
     */
    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event) {
        System.out.println("UserService监听到的事件" + event);
    }
}
