package com.dream.freedom.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data
public class Item {

    /**
     * 名称
     */
    private String name;
    /**
     * 重量
     */
    private int qty;
    /**
     * 价格
     */
    private BigDecimal price;

    public Item() {
    }

    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return qty == item.qty &&
                Objects.equals(name, item.name) &&
                Objects.equals(price, item.price);
    }


}
