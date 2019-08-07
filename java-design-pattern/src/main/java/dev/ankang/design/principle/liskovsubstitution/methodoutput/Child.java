package dev.ankang.design.principle.liskovsubstitution.methodoutput;

import java.util.LinkedHashMap;

public class Child extends Base {

    /**
     * 子类方法实现父类的方法时，方法的输出要比父类更严格或相等
     * 如果子类实现的返回值大于父类，那么子类可能就无法完全透明的替换掉父类
     */
    @Override
    public LinkedHashMap method() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        System.out.println("子类method被执行");
        linkedHashMap.put("message","子类method被执行");
        return linkedHashMap;
    }

}
