package com.dream.freedom.behavior.strategy.first;

/**
 * 机关枪
 */
public class MachineGun implements Weapon {

    private int num;
    private String name;

    public MachineGun() {
        this(12);

    }

    public MachineGun(int num) {
        this(num,"12");
    }

    public MachineGun(int num,String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public void gun() {
        System.out.println("切换机关枪击毙敌人");
    }
}
