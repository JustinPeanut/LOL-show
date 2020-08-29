package com.peanut.entity.po;

public class WalletOrderPO {
    private Integer id;

    private String orderName;

    private Double price;

    private String orderNum;

    private String aipayNum;

    private String orderMark;

    private Integer memberId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getAipayNum() {
        return aipayNum;
    }

    public void setAipayNum(String aipayNum) {
        this.aipayNum = aipayNum == null ? null : aipayNum.trim();
    }

    public String getOrderMark() {
        return orderMark;
    }

    public void setOrderMark(String orderMark) {
        this.orderMark = orderMark == null ? null : orderMark.trim();
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}