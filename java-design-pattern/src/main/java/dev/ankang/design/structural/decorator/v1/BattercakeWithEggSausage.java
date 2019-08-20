package dev.ankang.design.structural.decorator.v1;

public class BattercakeWithEggSausage extends BattercakeWithEgg {
    @Override
    protected String getDesc() {
        return super.getDesc() + "一个香肠";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}
