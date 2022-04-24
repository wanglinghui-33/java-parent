package com.dream.freedom.behavior.strategy.first;

/**
 * 狙击枪
 */
public class SniperRifle implements Weapon {

    @Override
    public void gun() {
        System.out.println("前方800米有敌人，使用狙击枪击毙敌人");
    }
}
