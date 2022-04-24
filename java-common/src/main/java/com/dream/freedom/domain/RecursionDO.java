package com.dream.freedom.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RecursionDO {
    
    private Long ruleId;
    private String nodeId;
    private String nodePid;
    // 节点类型(2006300)
    private Integer nodeType;
    // 逻辑运算符(2005200)
    private Integer logicOper;
    // 日志字段编号(2002000)
    private Integer columnId;
    // 比较运算符(2005100)
    private Integer compareOper;
    // 比较运算符(2005100)
    private Integer dataType;

    private String data;

    /**
     * 递归归并规则
     */
    private List<RecursionDO> children;


    public RecursionDO() {
    }

    // 逻辑运算符的构造
    public RecursionDO(String nodeId, String nodePid, Integer nodeType, Integer logicOper, List<RecursionDO> children) {
        this.nodeId = nodeId;
        this.nodePid = nodePid;
        this.nodeType = nodeType;
        this.logicOper = logicOper;
        this.children = children;
    }

    // 条件表达式的构造
    public RecursionDO(String nodeId, String nodePid, Integer nodeType, Integer columnId, Integer compareOper, Integer dataType, String data) {
        this.nodeId = nodeId;
        this.nodePid = nodePid;
        this.nodeType = nodeType;
        this.columnId = columnId;
        this.compareOper = compareOper;
        this.dataType = dataType;
        this.data = data;
    }

    @Override
    public String toString() {
        return "\n{" +

                " nodeId='" + nodeId + '\'' +
                ", nodePid='" + nodePid + '\'' +
                ", nodeType=" + nodeType +
                ", logicOper=" + logicOper +
                ", columnId=" + columnId +
                ", compareOper=" + compareOper +
                ", dataType=" + dataType +
                ", data='" + data + '\'' +
                ", children=" + children +
                '}';
    }
}
