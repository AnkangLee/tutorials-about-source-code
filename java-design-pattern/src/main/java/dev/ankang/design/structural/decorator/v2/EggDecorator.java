package dev.ankang.design.structural.decorator.v2;

public class EggDecorator extends ADecorator {
    public EggDecorator(ABattercake battercake) {
        super(battercake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + "加一个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() + 1;
    }
}
