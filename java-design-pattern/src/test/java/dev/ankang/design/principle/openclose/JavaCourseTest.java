package dev.ankang.design.principle.openclose;

import org.junit.Test;

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