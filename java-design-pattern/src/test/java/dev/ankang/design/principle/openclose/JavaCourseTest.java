package dev.ankang.design.principle.openclose;

import org.junit.Test;

/**
 * ** 依赖倒置原则的核心就是：面向抽象编程而不是面向具体的实现编程 **
 *
 * 一个软件实体如类 模块和函数应该对扩展开放，对修改关闭
 *  - 用抽象构建框架，用实现扩展细节
 */
public class JavaCourseTest {

    @Test
    public void test(){
        ICourse course = new JavaCourse(1,"java", 348D);
        System.out.println(course);
    }

    /**
     * 通过继承了基类，对基类进行扩展
     * 对扩展是开发的，对修改接口和基类是关闭的（越是基层的模块的修改影响的范围是越大的）
     *
     */
    @Test
    public void testDiscount(){
        ICourse course = new JavaDiscountCourse(1,"java", 348D);
        System.out.println(course.toString() + " discoutPrice = " + ((JavaDiscountCourse) course).getDiscountPrice());
    }
}