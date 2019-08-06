package dev.ankang.design.principle.demeter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 迪米特法则强调只和朋友交流，不和陌生人说话
 *
 * 朋友：
 *  - 出现在成员变量/方法的输入输出参数中的类称为成员朋友类，出现在方法体内部的类不属于朋友类。
 */
public class BossTest {

    @Test
    public void checkNumberOfCourses() {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandCheckNumber(teamLeader);
    }
}