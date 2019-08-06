package dev.ankang.design.principle.singleresponsibility.interfacelevel;

public class JavaCourse implements ICourseContent,ICourseManager {
    @Override
    public String getCourseName() {
        return "java course";
    }

    @Override
    public byte[] getCourseVideo() {
        return "this is fake java course".getBytes();
    }

    @Override
    public void studyCourse() {
        System.out.println("study java course");
    }

    @Override
    public void refundCourse() {
        System.out.println("refund java course cost");
    }
}
