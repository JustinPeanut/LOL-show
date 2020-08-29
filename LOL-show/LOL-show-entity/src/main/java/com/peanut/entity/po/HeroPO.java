package com.peanut.entity.po;

public class HeroPO {
    private Integer id;

    private String fullName;

    private String nickName;

    private Double price;

    private String heroTypeId;

    private String imgSmall;

    private String imgBig;

    private String imgScot;

    private String imgStick;

    private String imgCart;

    private Integer purchaseNum;

    private String text2;

    private String backStory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getHeroTypeId() {
        return heroTypeId;
    }

    public void setHeroTypeId(String heroTypeId) {
        this.heroTypeId = heroTypeId == null ? null : heroTypeId.trim();
    }

    public String getImgSmall() {
        return imgSmall;
    }

    public void setImgSmall(String imgSmall) {
        this.imgSmall = imgSmall == null ? null : imgSmall.trim();
    }

    public String getImgBig() {
        return imgBig;
    }

    public void setImgBig(String imgBig) {
        this.imgBig = imgBig == null ? null : imgBig.trim();
    }

    public String getImgScot() {
        return imgScot;
    }

    @Override
    public String toString() {
        return "HeroPO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", price=" + price +
                ", heroTypeId='" + heroTypeId + '\'' +
                ", imgSmall='" + imgSmall + '\'' +
                ", imgBig='" + imgBig + '\'' +
                ", imgScot='" + imgScot + '\'' +
                ", imgStick='" + imgStick + '\'' +
                ", imgCart='" + imgCart + '\'' +
                ", purchaseNum=" + purchaseNum +
                ", text2='" + text2 + '\'' +
                ", backStory='" + backStory + '\'' +
                '}';
    }

    public void setImgScot(String imgScot) {
        this.imgScot = imgScot == null ? null : imgScot.trim();
    }

    public String getImgStick() {
        return imgStick;
    }

    public void setImgStick(String imgStick) {
        this.imgStick = imgStick == null ? null : imgStick.trim();
    }

    public String getImgCart() {
        return imgCart;
    }

    public void setImgCart(String imgCart) {
        this.imgCart = imgCart == null ? null : imgCart.trim();
    }

    public Integer getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2 == null ? null : text2.trim();
    }

    public String getBackStory() {
        return backStory;
    }

    public void setBackStory(String backStory) {
        this.backStory = backStory == null ? null : backStory.trim();
    }
}