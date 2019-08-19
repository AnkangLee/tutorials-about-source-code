package dev.ankang.design.pattern.creational.builder.v2;


import lombok.Getter;
import lombok.ToString;

@ToString
public class Course {
    private String courseName;
    private String coursePPT;
    private String courseVideo;
    private String courseArticle;
    private String courseQA;

    public Course(CourseBuilder courseBuilder) {
        this.courseArticle = courseBuilder.getCourseArticle();
        this.coursePPT = courseBuilder.getCoursePPT();
        this.courseName = courseBuilder.getCourseName();
        this.courseVideo = courseBuilder.getCourseVideo();
        this.courseQA = courseBuilder.getCourseQA();
    }

    @Getter
    public static class CourseBuilder{
        private String courseName;
        private String coursePPT;
        private String courseVideo;
        private String courseArticle;
        private String courseQA;

        public CourseBuilder courseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public CourseBuilder coursePPT(String coursePPT) {
            this.coursePPT = coursePPT;
            return this;
        }

        public CourseBuilder courseVideo(String courseVideo) {
            this.courseVideo = courseVideo;
            return this;
        }

        public CourseBuilder courseArticle(String courseArticle) {
            this.courseArticle = courseArticle;
            return this;
        }

        public CourseBuilder courseQA(String courseQA) {
            this.courseQA = courseQA;
            return this;
        }

        public Course build(){
            return new Course(this);
        }
    }
}
