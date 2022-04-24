package com.dream.freedom.behavior.strategy;

/**
 * 策略模式：一个类的行为或算法可以在运行时更改，这种类型的设计模式属于行为模式
 *   1：何时使用：  一个系统有多个类，而区分它们的只是它们的行为时
 *   2：方法： 将这些算法封装成一个一个的类，任意的替换
 *   3：优点： 算法可以自由切换/避免使用多重条件判断（如果不用策略模式我们可能会使用多重条件语句，不利于维护）/ 扩展性良好，增加一个策略只需要实现一个接口即可
 *   4：缺点： 策略数量会增多，每个策略都是一个类，复用的可能性小/所有的策略都需要对外暴露
 *   5：使用场景：
 *      多个类只有算法或行为上稍有不同的场景
 *      算法需要自由切换的场景
 *      需要屏蔽算法规则的场景
 *   6：应用实例：
 *      出行方式，自行车、汽车等，每一种出行方式都是一个策略
 *      商场促销方式，打折、满减等
 *      Java AWT中的LayoutManager，即布局管理器
 *   7：注意事项：
 *      如果一个系统的策略多于四个，就需要考虑使用混合模式来解决策略类膨胀的问题
 *
 * 策略模式-定义一个枪的接口--策略对象
 * 实际开发中，如果if else 条件判断过多的问题，过多就是逻辑混乱，很容易出错
 *
 * 策略模式不是解决if else ，不是用于分支选择的，策略模式其实是的代码更加简洁合理
 *
 *
 *
 * （一）策略模式有3个东西：
 *      context （调用策略接口方法的环境类）他会维护一个Strategy的引用，用于调用实际的接口方法
 *      strategy （策略接口）定义支持所有算法的公共接口
 *      XXStrategy (具体策略实现类）实现Strategy接口中的具体算法
 *
 */
public class StrategyDoc {

}