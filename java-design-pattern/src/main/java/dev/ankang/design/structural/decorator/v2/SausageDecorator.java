package dev.ankang.design.structural.decorator.v2;

public class SausageDecorator extends ADecorator {
    public SausageDecorator(ABattercake battercake) {
        super(battercake);
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + "加一根香肠";
    }
}
