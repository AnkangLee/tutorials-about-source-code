package dev.ankang.design.principle.liskovsubstitution.methodoutput;

import org.junit.Test;

public class MethodTest {

    /**
     * 获取到一个linkedHashMap，可以完全透明的替换父类
     */
    @Test
    public void testMethodOutput(){
        Base child = new Child();
        System.out.println(child.method());
    }

}