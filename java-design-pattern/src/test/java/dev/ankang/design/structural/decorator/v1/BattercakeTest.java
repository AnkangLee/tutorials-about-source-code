package dev.ankang.design.structural.decorator.v1;


import org.junit.Test;

public class BattercakeTest {

    @Test
    public void getBattercake() {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getDesc()+"销售价格:"+battercake.cost());

        Battercake battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getDesc()+"销售价格:"+battercakeWithEgg.cost());

        Battercake battercakeWithEggSausage = new BattercakeWithEggSausage();
        System.out.println(battercakeWithEggSausage.getDesc()+"销售价格:"+battercakeWithEggSausage.cost());
    }
}