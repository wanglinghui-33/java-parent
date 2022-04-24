package com.dream.freedom.behavior.strategy.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 核心工厂类-- 该工厂管理所有策略接口的实现类
 * <p>
 * 该工厂类使用内部类的方式实现单利模式
 */
public class FeeServiceFactory {

    private Map<Integer, FeeService> map;

    // 构造方法
    private FeeServiceFactory() {
        List<FeeService> list = new ArrayList<>();
        // 把所有的实现类实例都添加到这个集合中
        list.add(new OrdinaryMember());
        list.add(new JuniorMember());
        list.add(new IntermediateMember());
        list.add(new SeniorMember());
        map = new ConcurrentHashMap<>();
        // 第一种存放方式
        //map.put(MemberEnum.ORDINARY_MEMBER.getCode(), new OrdinaryMember());
        // 第二种存放方式
        for (FeeService feeService : list) {
            map.put(feeService.getType(), feeService);
        }
    }

    public static FeeServiceFactory getInstance() {
        return Holder.instance;
    }

    /**
     * 根据会员级别type，从map中获取响应的策略实现类
     *
     * @param type 会员级别的类型
     * @return 返回具体的实现类型
     */
    public FeeService getFee(Integer type) {
        return map.get(type);
    }

    /**
     * 内部类实现单利
     */
    public static class Holder {
        //内部类什么时候加载？
        static FeeServiceFactory instance = new FeeServiceFactory();

    }


}
