package dev.ankang.design.pattern.creational.builder;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseBuilderTest {

    @Test
    public void makeCourse() {
        Coach coach = new Coach();
        coach.setCourseBuilder(new ActualCourseBuilder());
        Course course = coach.makeCourse("Java设计模式",
                "Java设计模式PPT",
                "Java设计模式视频",
                "Java设计模式手记",
                "Java设计模式问答");

        System.out.println(course);
    }

    @Test
    public void makeCourseV2() {
        dev.ankang.design.pattern.creational.builder.v2.Course course =
                new dev.ankang.design.pattern.creational.builder.v2.Course.CourseBuilder()
                        .courseName("Java设计模式精讲")
                        .coursePPT("Java设计模式精讲PPT")
                        .courseVideo("Java设计模式精讲视频")
                        .build();

        System.out.println(course);
    }
}