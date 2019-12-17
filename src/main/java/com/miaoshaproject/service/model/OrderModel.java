package com.miaoshaproject.service.model;

import java.math.BigDecimal;

/**
 * @author Lion 订单模型
 * @date 2019/12/4 14:33
 * @Version 1.0
 */
public class OrderModel {

    //订单id
    private String id;

    //用户id
    private Integer userId;

    //商品id
    private Integer itemId;

    //购买数量
    private Integer amount;

    //购买时的商品价格，即使以后商品价格改动也不影响购买时的价格
    private BigDecimal itemPrice;

    //购买金额
    private BigDecimal orderPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public BigDecimal getOrderAmount() {
        return orderPrice;
    }

    public void setOrderAmount(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
}
