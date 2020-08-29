package com.peanut.entity.po;

public class MemberWalletPO {
    private Integer id;

    private Double walletLast;

    private Integer memberId;

    private String text1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getWalletLast() {
        return walletLast;
    }

    public void setWalletLast(Double walletLast) {
        this.walletLast = walletLast;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1 == null ? null : text1.trim();
    }
}