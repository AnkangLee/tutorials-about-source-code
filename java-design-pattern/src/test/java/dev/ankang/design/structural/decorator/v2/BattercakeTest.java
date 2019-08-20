package dev.ankang.design.structural.decorator.v2;


import org.junit.Test;

public class BattercakeTest {

    @Test
    public void getBattercake() {
        ABattercake battercake = new SausageDecorator(new SausageDecorator(new EggDecorator(new Battercate())));

        System.out.println(battercake.getDesc()+"价格为:"+battercake.cost());

    }
}