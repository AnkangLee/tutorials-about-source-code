package dev.ankang.design.structural.decorator.v2;

public class ADecorator extends ABattercake {

    private ABattercake battercake;

    public ADecorator(ABattercake battercake) {
        this.battercake = battercake;
    }

    @Override
    protected String getDesc() {
        return battercake.getDesc();
    }

    @Override
    protected int cost() {
        return battercake.cost();
    }
}
