package dev.ankang.design.principle.liskovsubstitution.methodinput;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MethodTest {

    @Test
    public void testMethodInput(){
        Child child = new Child();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        child.method(linkedHashMap);

        HashMap hashMap = new HashMap();
        child.method(hashMap);
    }
}