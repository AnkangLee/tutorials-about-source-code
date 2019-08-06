package dev.ankang.design.principle.singleresponsibility.classlevel;

import org.junit.Test;

/**
 * 类层面的单一职责要考虑实际情况，不能过多的使用单一职责原则
 *
 * 如果类过多的话，会引起类爆炸的现象
 */
public class MovableTest {

    @Test
    public void mainMoveMode() {
        FlyBird flyBird = new FlyBird();
        flyBird.mainMoveMode("大雁");

        WalkBird walkBird = new WalkBird();
        walkBird.mainMoveMode("鸵鸟");
    }
}