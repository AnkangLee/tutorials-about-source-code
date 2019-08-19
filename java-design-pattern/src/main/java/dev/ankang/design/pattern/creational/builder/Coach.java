package dev.ankang.design.pattern.creational.builder;

import lombok.Setter;

@Setter
public class Coach {
    private CourseBuilder courseBuilder;

    public Course makeCourse(String courseName,String coursePPT,
                             String courseVideo,String courseArticle,String courseQA) {
        this.courseBuilder.buildCourseName(courseName);
        this.courseBuilder.buildCoursePPT(coursePPT);
        this.courseBuilder.buildCourseVideo(courseVideo);
        this.courseBuilder.buildCourseArticle(courseArticle);
        this.courseBuilder.buildCourseQA(courseQA);

        return this.courseBuilder.makeCourse();
    }
}
