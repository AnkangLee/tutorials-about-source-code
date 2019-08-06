package dev.ankang.design.principle.dependenceinversion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ** 依赖倒置原则的核心就是：面向接口编程 **
 *
 * 高层模块不应该依赖底层模块，二者都应该依赖其抽象
 * - 抽象不应该依赖于细节，细节应该依赖于抽象
 * - 针对接口编程，不应该针对实现编程
 */
public class TomTest {

    /**
     * 通过具体的方法来注入接口的具体实现
     */
    @Test
    public void studyCourse() {
        Tom tom = new Tom();
        tom.studyCourse(new JavaCourse());
        tom.studyCourse(new FECourse());
    }


    /**
     * 通过constructor来注入接口的具体实现
     */
    @Test
    public void studyCourseV2() {
        Tom tom = new Tom(new JavaCourse());
        tom.studyCourse();
    }

    /**
     * 通过setter方法来注入接口的具体实现
     */
    @Test
    public void studyCourseV3() {
        Tom tom = new Tom();
        tom.setCourse(new FECourse());
        tom.studyCourse();
    }
}