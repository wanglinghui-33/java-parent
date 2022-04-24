package com.dream.freedom.recursion;

import com.alibaba.fastjson.JSON;
import com.dream.freedom.domain.RecursionDO;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecursionTest01 {


    private static List<RecursionDO> recursionDOList;
    private static List<RecursionDO> newList = new ArrayList<>();      // 拆开后的集合

    static {
        List<RecursionDO> children2 = new ArrayList<>(Arrays.asList(
                // 条件
                new RecursionDO("111", "113", 2006302, 2002001, 2005101, 2008901, "数据1"),
                // 条件
                new RecursionDO("112", "113", 2006302, 2002002, 2005101, 2008901, "数据2")
        ));

        List<RecursionDO> children1 = new ArrayList<>(Arrays.asList(
                // 条件
                new RecursionDO("111", "1", 2006302, 2002001, 2005101, 2008901, "数据1"),
                // 条件
                new RecursionDO("112", "1", 2006302, 2002002, 2005101, 2008901, "数据2"),
                // 逻辑
                new RecursionDO("113", "1", 2006301, 2005201, children2)
        ));
        recursionDOList = new ArrayList<>(Arrays.asList(
                new RecursionDO("1", "0", 2006301, 2005201, children1)
        ));
    }

    // 前端获取后，拆开保存到数据库中
    public static void recursionTest() {
        System.out.println("最初的集合" + JSON.toJSONString(recursionDOList));
        m1(recursionDOList, newList);
        newList.forEach(a -> a.setData("小米"));  //批量修改值
        System.out.println("用于保存的集合" + JSON.toJSONString(newList));

    }

    /**
     * 递归遍历数据
     *
     * @param list
     * @param newList
     */
    private static void m1(List<RecursionDO> list, List<RecursionDO> newList) {
        for (RecursionDO recursionDO : list) {
            if (recursionDO != null) {
                newList.add(recursionDO);
                List<RecursionDO> children = recursionDO.getChildren();
                if (!CollectionUtils.isEmpty(children)) {
                    m1(children, newList);
                }
            }
        }
    }

    // 这个是要把从数据库查询到的数据合并起来返回给前端
    public static void recursionTest2(){
        List<RecursionDO> list = m2(newList, "0");
        System.out.println("返回最初的集合：" + JSON.toJSONString(list));

    }

    private static List<RecursionDO> m2(List<RecursionDO> aList, String pid) {
        List<RecursionDO> list = aList.stream().filter(a -> pid.equals(a.getNodePid())).collect(Collectors.toList());
        list.forEach(b -> {
            List<RecursionDO> children = m2(aList,b.getNodeId());
            b.setChildren(children);
        });
        return list;
    }



}
