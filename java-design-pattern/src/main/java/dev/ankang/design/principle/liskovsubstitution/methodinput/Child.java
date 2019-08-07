package dev.ankang.design.principle.liskovsubstitution.methodinput;

import java.util.Map;

public class Child extends Base {

    /**
     * 缩小子类输入的范围，不能透明的替代父类
     *
     * 在传入参数时
     *  - 若参数范围在子类方法的范围之内，那么执行的便是子类方法；
     *  - 若参数范围大于子类方法范围并且小于父类方法参数范围，那么此时执行的就是父类中的方法。
     */
//    public void method(LinkedHashMap map) {
//        System.out.println("子类HashMap入参方法被执行");
//    }

    /**
     * 在使用父类的原程序中，参数的范围不可能大于父类参数所接受的最大范围，因此使用子类替换掉父类后执行的仍然是父类方法
     */
    public void method(Map map) {
        System.out.println("子类HashMap入参方法被执行");
    }
}
