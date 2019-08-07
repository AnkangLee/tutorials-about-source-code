package dev.ankang.design.principle.liskovsubstitution.methodoutput;

import java.util.HashMap;

public class Base {
    public HashMap method(){
        System.out.println("父类被执行");
        return new HashMap();
    }
}
