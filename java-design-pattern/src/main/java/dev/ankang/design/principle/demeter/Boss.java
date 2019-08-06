package dev.ankang.design.principle.demeter;

/**
 * Boss的这个类是不需要了解Course的这个类
 * Course这个类直接发生关系的是TeamLeader的这个类
 */
public class Boss {
    public void commandCheckNumber(TeamLeader teamLeader) {
        teamLeader.checkNumberOfCourses();
    }
}
