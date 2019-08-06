package dev.ankang.design.principle.dependenceinversion;

public class FECourse implements ICourse {
    @Override
    public void studyCourse() {
        System.out.println("study FE course...");
    }
}
