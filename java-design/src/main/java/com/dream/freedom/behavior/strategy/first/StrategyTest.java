package com.dream.freedom.behavior.strategy.first;

public class StrategyTest {

    public static void strategyTest(){

        //使用构造函数默认选择使用狙击枪
        Context context = new Context(new SniperRifle());
        context.gun();

        //使用get和set切换其他策略
        System.out.println("前方发0米发现一个敌人");
        context.setWeapon(new Pistol());
        context.gun();

        System.out.println("前方40米发现大量敌人");
        context.setWeapon(new MachineGun());
        context.gun();


    }


}
