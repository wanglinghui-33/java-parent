package com.dream.freedom.behavior.strategy.first;

/**
 * 手枪
 */
public class Pistol implements Weapon {


    @Override
    public void gun() {
        System.out.println("切换手枪击毙敌人");
    }
}
