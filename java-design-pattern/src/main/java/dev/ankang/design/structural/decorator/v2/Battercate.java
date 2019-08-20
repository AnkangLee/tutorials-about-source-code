package dev.ankang.design.structural.decorator.v2;

public class Battercate extends ABattercake {
    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
