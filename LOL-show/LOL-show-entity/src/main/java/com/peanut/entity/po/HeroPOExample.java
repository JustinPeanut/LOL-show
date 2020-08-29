package com.peanut.entity.po;

import java.util.ArrayList;
import java.util.List;

public class HeroPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HeroPOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFullNameIsNull() {
            addCriterion("full_name is null");
            return (Criteria) this;
        }

        public Criteria andFullNameIsNotNull() {
            addCriterion("full_name is not null");
            return (Criteria) this;
        }

        public Criteria andFullNameEqualTo(String value) {
            addCriterion("full_name =", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotEqualTo(String value) {
            addCriterion("full_name <>", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameGreaterThan(String value) {
            addCriterion("full_name >", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("full_name >=", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLessThan(String value) {
            addCriterion("full_name <", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLessThanOrEqualTo(String value) {
            addCriterion("full_name <=", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLike(String value) {
            addCriterion("full_name like", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotLike(String value) {
            addCriterion("full_name not like", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameIn(List<String> values) {
            addCriterion("full_name in", values, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotIn(List<String> values) {
            addCriterion("full_name not in", values, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameBetween(String value1, String value2) {
            addCriterion("full_name between", value1, value2, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotBetween(String value1, String value2) {
            addCriterion("full_name not between", value1, value2, "fullName");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andHeroTypeIdIsNull() {
            addCriterion("hero_type_id is null");
            return (Criteria) this;
        }

        public Criteria andHeroTypeIdIsNotNull() {
            addCriterion("hero_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andHeroTypeIdEqualTo(String value) {
            addCriterion("hero_type_id =", value, "heroTypeId");
            return (Criteria) this;
        }

        public Criteria andHeroTypeIdNotEqualTo(String value) {
            addCriterion("hero_type_id <>", value, "heroTypeId");
            return (Criteria) this;
        }

        public Criteria andHeroTypeIdGreaterThan(String value) {
            addCriterion("hero_type_id >", value, "heroTypeId");
            return (Criteria) this;
        }

        public Criteria andHeroTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("hero_type_id >=", value, "heroTypeId");
            return (Criteria) this;
        }

        public Criteria andHeroTypeIdLessThan(String value) {
            addCriterion("hero_type_id <", value, "heroTypeId");
            return (Criteria) this;
        }

        public Criteria andHeroTypeIdLessThanOrEqualTo(String value) {
            addCriterion("hero_type_id <=", value, "heroTypeId");
            return (Criteria) this;
        }

        public Criteria andHeroTypeIdLike(String value) {
            addCriterion("hero_type_id like", value, "heroTypeId");
            return (Criteria) this;
        }

        public Criteria andHeroTypeIdNotLike(String value) {
            addCriterion("hero_type_id not like", value, "heroTypeId");
            return (Criteria) this;
        }

        public Criteria andHeroTypeIdIn(List<String> values) {
            addCriterion("hero_type_id in", values, "heroTypeId");
            return (Criteria) this;
        }

        public Criteria andHeroTypeIdNotIn(List<String> values) {
            addCriterion("hero_type_id not in", values, "heroTypeId");
            return (Criteria) this;
        }

        public Criteria andHeroTypeIdBetween(String value1, String value2) {
            addCriterion("hero_type_id between", value1, value2, "heroTypeId");
            return (Criteria) this;
        }

        public Criteria andHeroTypeIdNotBetween(String value1, String value2) {
            addCriterion("hero_type_id not between", value1, value2, "heroTypeId");
            return (Criteria) this;
        }

        public Criteria andImgSmallIsNull() {
            addCriterion("img_small is null");
            return (Criteria) this;
        }

        public Criteria andImgSmallIsNotNull() {
            addCriterion("img_small is not null");
            return (Criteria) this;
        }

        public Criteria andImgSmallEqualTo(String value) {
            addCriterion("img_small =", value, "imgSmall");
            return (Criteria) this;
        }

        public Criteria andImgSmallNotEqualTo(String value) {
            addCriterion("img_small <>", value, "imgSmall");
            return (Criteria) this;
        }

        public Criteria andImgSmallGreaterThan(String value) {
            addCriterion("img_small >", value, "imgSmall");
            return (Criteria) this;
        }

        public Criteria andImgSmallGreaterThanOrEqualTo(String value) {
            addCriterion("img_small >=", value, "imgSmall");
            return (Criteria) this;
        }

        public Criteria andImgSmallLessThan(String value) {
            addCriterion("img_small <", value, "imgSmall");
            return (Criteria) this;
        }

        public Criteria andImgSmallLessThanOrEqualTo(String value) {
            addCriterion("img_small <=", value, "imgSmall");
            return (Criteria) this;
        }

        public Criteria andImgSmallLike(String value) {
            addCriterion("img_small like", value, "imgSmall");
            return (Criteria) this;
        }

        public Criteria andImgSmallNotLike(String value) {
            addCriterion("img_small not like", value, "imgSmall");
            return (Criteria) this;
        }

        public Criteria andImgSmallIn(List<String> values) {
            addCriterion("img_small in", values, "imgSmall");
            return (Criteria) this;
        }

        public Criteria andImgSmallNotIn(List<String> values) {
            addCriterion("img_small not in", values, "imgSmall");
            return (Criteria) this;
        }

        public Criteria andImgSmallBetween(String value1, String value2) {
            addCriterion("img_small between", value1, value2, "imgSmall");
            return (Criteria) this;
        }

        public Criteria andImgSmallNotBetween(String value1, String value2) {
            addCriterion("img_small not between", value1, value2, "imgSmall");
            return (Criteria) this;
        }

        public Criteria andImgBigIsNull() {
            addCriterion("img_big is null");
            return (Criteria) this;
        }

        public Criteria andImgBigIsNotNull() {
            addCriterion("img_big is not null");
            return (Criteria) this;
        }

        public Criteria andImgBigEqualTo(String value) {
            addCriterion("img_big =", value, "imgBig");
            return (Criteria) this;
        }

        public Criteria andImgBigNotEqualTo(String value) {
            addCriterion("img_big <>", value, "imgBig");
            return (Criteria) this;
        }

        public Criteria andImgBigGreaterThan(String value) {
            addCriterion("img_big >", value, "imgBig");
            return (Criteria) this;
        }

        public Criteria andImgBigGreaterThanOrEqualTo(String value) {
            addCriterion("img_big >=", value, "imgBig");
            return (Criteria) this;
        }

        public Criteria andImgBigLessThan(String value) {
            addCriterion("img_big <", value, "imgBig");
            return (Criteria) this;
        }

        public Criteria andImgBigLessThanOrEqualTo(String value) {
            addCriterion("img_big <=", value, "imgBig");
            return (Criteria) this;
        }

        public Criteria andImgBigLike(String value) {
            addCriterion("img_big like", value, "imgBig");
            return (Criteria) this;
        }

        public Criteria andImgBigNotLike(String value) {
            addCriterion("img_big not like", value, "imgBig");
            return (Criteria) this;
        }

        public Criteria andImgBigIn(List<String> values) {
            addCriterion("img_big in", values, "imgBig");
            return (Criteria) this;
        }

        public Criteria andImgBigNotIn(List<String> values) {
            addCriterion("img_big not in", values, "imgBig");
            return (Criteria) this;
        }

        public Criteria andImgBigBetween(String value1, String value2) {
            addCriterion("img_big between", value1, value2, "imgBig");
            return (Criteria) this;
        }

        public Criteria andImgBigNotBetween(String value1, String value2) {
            addCriterion("img_big not between", value1, value2, "imgBig");
            return (Criteria) this;
        }

        public Criteria andImgScotIsNull() {
            addCriterion("img_scot is null");
            return (Criteria) this;
        }

        public Criteria andImgScotIsNotNull() {
            addCriterion("img_scot is not null");
            return (Criteria) this;
        }

        public Criteria andImgScotEqualTo(String value) {
            addCriterion("img_scot =", value, "imgScot");
            return (Criteria) this;
        }

        public Criteria andImgScotNotEqualTo(String value) {
            addCriterion("img_scot <>", value, "imgScot");
            return (Criteria) this;
        }

        public Criteria andImgScotGreaterThan(String value) {
            addCriterion("img_scot >", value, "imgScot");
            return (Criteria) this;
        }

        public Criteria andImgScotGreaterThanOrEqualTo(String value) {
            addCriterion("img_scot >=", value, "imgScot");
            return (Criteria) this;
        }

        public Criteria andImgScotLessThan(String value) {
            addCriterion("img_scot <", value, "imgScot");
            return (Criteria) this;
        }

        public Criteria andImgScotLessThanOrEqualTo(String value) {
            addCriterion("img_scot <=", value, "imgScot");
            return (Criteria) this;
        }

        public Criteria andImgScotLike(String value) {
            addCriterion("img_scot like", value, "imgScot");
            return (Criteria) this;
        }

        public Criteria andImgScotNotLike(String value) {
            addCriterion("img_scot not like", value, "imgScot");
            return (Criteria) this;
        }

        public Criteria andImgScotIn(List<String> values) {
            addCriterion("img_scot in", values, "imgScot");
            return (Criteria) this;
        }

        public Criteria andImgScotNotIn(List<String> values) {
            addCriterion("img_scot not in", values, "imgScot");
            return (Criteria) this;
        }

        public Criteria andImgScotBetween(String value1, String value2) {
            addCriterion("img_scot between", value1, value2, "imgScot");
            return (Criteria) this;
        }

        public Criteria andImgScotNotBetween(String value1, String value2) {
            addCriterion("img_scot not between", value1, value2, "imgScot");
            return (Criteria) this;
        }

        public Criteria andImgStickIsNull() {
            addCriterion("img_stick is null");
            return (Criteria) this;
        }

        public Criteria andImgStickIsNotNull() {
            addCriterion("img_stick is not null");
            return (Criteria) this;
        }

        public Criteria andImgStickEqualTo(String value) {
            addCriterion("img_stick =", value, "imgStick");
            return (Criteria) this;
        }

        public Criteria andImgStickNotEqualTo(String value) {
            addCriterion("img_stick <>", value, "imgStick");
            return (Criteria) this;
        }

        public Criteria andImgStickGreaterThan(String value) {
            addCriterion("img_stick >", value, "imgStick");
            return (Criteria) this;
        }

        public Criteria andImgStickGreaterThanOrEqualTo(String value) {
            addCriterion("img_stick >=", value, "imgStick");
            return (Criteria) this;
        }

        public Criteria andImgStickLessThan(String value) {
            addCriterion("img_stick <", value, "imgStick");
            return (Criteria) this;
        }

        public Criteria andImgStickLessThanOrEqualTo(String value) {
            addCriterion("img_stick <=", value, "imgStick");
            return (Criteria) this;
        }

        public Criteria andImgStickLike(String value) {
            addCriterion("img_stick like", value, "imgStick");
            return (Criteria) this;
        }

        public Criteria andImgStickNotLike(String value) {
            addCriterion("img_stick not like", value, "imgStick");
            return (Criteria) this;
        }

        public Criteria andImgStickIn(List<String> values) {
            addCriterion("img_stick in", values, "imgStick");
            return (Criteria) this;
        }

        public Criteria andImgStickNotIn(List<String> values) {
            addCriterion("img_stick not in", values, "imgStick");
            return (Criteria) this;
        }

        public Criteria andImgStickBetween(String value1, String value2) {
            addCriterion("img_stick between", value1, value2, "imgStick");
            return (Criteria) this;
        }

        public Criteria andImgStickNotBetween(String value1, String value2) {
            addCriterion("img_stick not between", value1, value2, "imgStick");
            return (Criteria) this;
        }

        public Criteria andImgCartIsNull() {
            addCriterion("img_cart is null");
            return (Criteria) this;
        }

        public Criteria andImgCartIsNotNull() {
            addCriterion("img_cart is not null");
            return (Criteria) this;
        }

        public Criteria andImgCartEqualTo(String value) {
            addCriterion("img_cart =", value, "imgCart");
            return (Criteria) this;
        }

        public Criteria andImgCartNotEqualTo(String value) {
            addCriterion("img_cart <>", value, "imgCart");
            return (Criteria) this;
        }

        public Criteria andImgCartGreaterThan(String value) {
            addCriterion("img_cart >", value, "imgCart");
            return (Criteria) this;
        }

        public Criteria andImgCartGreaterThanOrEqualTo(String value) {
            addCriterion("img_cart >=", value, "imgCart");
            return (Criteria) this;
        }

        public Criteria andImgCartLessThan(String value) {
            addCriterion("img_cart <", value, "imgCart");
            return (Criteria) this;
        }

        public Criteria andImgCartLessThanOrEqualTo(String value) {
            addCriterion("img_cart <=", value, "imgCart");
            return (Criteria) this;
        }

        public Criteria andImgCartLike(String value) {
            addCriterion("img_cart like", value, "imgCart");
            return (Criteria) this;
        }

        public Criteria andImgCartNotLike(String value) {
            addCriterion("img_cart not like", value, "imgCart");
            return (Criteria) this;
        }

        public Criteria andImgCartIn(List<String> values) {
            addCriterion("img_cart in", values, "imgCart");
            return (Criteria) this;
        }

        public Criteria andImgCartNotIn(List<String> values) {
            addCriterion("img_cart not in", values, "imgCart");
            return (Criteria) this;
        }

        public Criteria andImgCartBetween(String value1, String value2) {
            addCriterion("img_cart between", value1, value2, "imgCart");
            return (Criteria) this;
        }

        public Criteria andImgCartNotBetween(String value1, String value2) {
            addCriterion("img_cart not between", value1, value2, "imgCart");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumIsNull() {
            addCriterion("purchase_num is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumIsNotNull() {
            addCriterion("purchase_num is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumEqualTo(Integer value) {
            addCriterion("purchase_num =", value, "purchaseNum");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumNotEqualTo(Integer value) {
            addCriterion("purchase_num <>", value, "purchaseNum");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumGreaterThan(Integer value) {
            addCriterion("purchase_num >", value, "purchaseNum");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_num >=", value, "purchaseNum");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumLessThan(Integer value) {
            addCriterion("purchase_num <", value, "purchaseNum");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_num <=", value, "purchaseNum");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumIn(List<Integer> values) {
            addCriterion("purchase_num in", values, "purchaseNum");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumNotIn(List<Integer> values) {
            addCriterion("purchase_num not in", values, "purchaseNum");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumBetween(Integer value1, Integer value2) {
            addCriterion("purchase_num between", value1, value2, "purchaseNum");
            return (Criteria) this;
        }

        public Criteria andPurchaseNumNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_num not between", value1, value2, "purchaseNum");
            return (Criteria) this;
        }

        public Criteria andText2IsNull() {
            addCriterion("text2 is null");
            return (Criteria) this;
        }

        public Criteria andText2IsNotNull() {
            addCriterion("text2 is not null");
            return (Criteria) this;
        }

        public Criteria andText2EqualTo(String value) {
            addCriterion("text2 =", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2NotEqualTo(String value) {
            addCriterion("text2 <>", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2GreaterThan(String value) {
            addCriterion("text2 >", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2GreaterThanOrEqualTo(String value) {
            addCriterion("text2 >=", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2LessThan(String value) {
            addCriterion("text2 <", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2LessThanOrEqualTo(String value) {
            addCriterion("text2 <=", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2Like(String value) {
            addCriterion("text2 like", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2NotLike(String value) {
            addCriterion("text2 not like", value, "text2");
            return (Criteria) this;
        }

        public Criteria andText2In(List<String> values) {
            addCriterion("text2 in", values, "text2");
            return (Criteria) this;
        }

        public Criteria andText2NotIn(List<String> values) {
            addCriterion("text2 not in", values, "text2");
            return (Criteria) this;
        }

        public Criteria andText2Between(String value1, String value2) {
            addCriterion("text2 between", value1, value2, "text2");
            return (Criteria) this;
        }

        public Criteria andText2NotBetween(String value1, String value2) {
            addCriterion("text2 not between", value1, value2, "text2");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}