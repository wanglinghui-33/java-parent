package com.dream.freedom.collection;

public class RuleColumn {

    /**
     * 类型
     */
    private Integer type;

    /**
     * 字段编号
     */
    private Long columnId;

    public RuleColumn() {
    }

    public RuleColumn(Integer type, Long columnId) {
        this.type = type;
        this.columnId = columnId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    @Override
    public String toString() {
        return "{" +
                "type=" + type +
                ", columnId=" + columnId +
                '}';
    }
}
