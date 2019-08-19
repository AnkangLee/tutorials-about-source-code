package dev.ankang.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
@Component
public class Dog {
    public Dog() {
        System.out.println("Dog...Contructor...");
    }

    /**
     * 在bean创建完成并且属性赋值完成，来执行初始化方法
     */
    @PostConstruct
    public void init() {
        System.out.println("Dog...@PostConstruct...");
    }

    /**
     * 在容器销毁bean之前通知我们来进行清理工作
     */
    @PreDestroy
    public void destroy() {
        System.out.println("Dog...@PreDestroy...");
    }
}
