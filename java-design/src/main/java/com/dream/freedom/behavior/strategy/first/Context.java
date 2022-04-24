package com.dream.freedom.behavior.strategy.first;

/**
 * 定义一个环境类
 */
public class Context {

    Weapon weapon;

    /**
     * 构造函数
     */
    public Context(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }


    public void gun() {
        weapon.gun();
    }

}
