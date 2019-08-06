package dev.ankang.design.principle.interfacesegregation;

import org.junit.Test;

/**
 * 用多个专门的接口而不是十一哦给你单一的总接口
 * 客户端不应该依赖它不需要的接口
 *
 * 注意适度原则
 */
public class DogTest {

    @Test
    public void dogAction(){
        Dog dog = new Dog();
        dog.eat();
        dog.swim();
    }
}