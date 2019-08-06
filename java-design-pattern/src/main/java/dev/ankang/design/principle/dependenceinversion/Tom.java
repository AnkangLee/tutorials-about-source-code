package dev.ankang.design.principle.dependenceinversion;

public class Tom {

    private ICourse course;

    public Tom() {
    }

    public Tom(ICourse course) {
        this.course = course;
    }

    public void setCourse(ICourse course) {
        this.course = course;
    }

    public void studyCourse(ICourse course) {
        course.studyCourse();
    }

    public void studyCourse() {
        if (this.course != null) {
            this.course.studyCourse();
        } else {
            System.out.println("your should assign a course to tom");
        }
    }
}
