package com.peanut.entity.po;

import java.util.ArrayList;
import java.util.List;

public class OrderHeroPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderHeroPOExample() {
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

        public Criteria andOrderNameIsNull() {
            addCriterion("order_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderNameIsNotNull() {
            addCriterion("order_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNameEqualTo(String value) {
            addCriterion("order_name =", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotEqualTo(String value) {
            addCriterion("order_name <>", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThan(String value) {
            addCriterion("order_name >", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_name >=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThan(String value) {
            addCriterion("order_name <", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLessThanOrEqualTo(String value) {
            addCriterion("order_name <=", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameLike(String value) {
            addCriterion("order_name like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotLike(String value) {
            addCriterion("order_name not like", value, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameIn(List<String> values) {
            addCriterion("order_name in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotIn(List<String> values) {
            addCriterion("order_name not in", values, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameBetween(String value1, String value2) {
            addCriterion("order_name between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderNameNotBetween(String value1, String value2) {
            addCriterion("order_name not between", value1, value2, "orderName");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNull() {
            addCriterion("order_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("order_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(Double value) {
            addCriterion("order_price =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(Double value) {
            addCriterion("order_price <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(Double value) {
            addCriterion("order_price >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("order_price >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(Double value) {
            addCriterion("order_price <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(Double value) {
            addCriterion("order_price <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<Double> values) {
            addCriterion("order_price in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<Double> values) {
            addCriterion("order_price not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(Double value1, Double value2) {
            addCriterion("order_price between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(Double value1, Double value2) {
            addCriterion("order_price not between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andPurchaseLimitIsNull() {
            addCriterion("purchase_limit is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseLimitIsNotNull() {
            addCriterion("purchase_limit is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseLimitEqualTo(Integer value) {
            addCriterion("purchase_limit =", value, "purchaseLimit");
            return (Criteria) this;
        }

        public Criteria andPurchaseLimitNotEqualTo(Integer value) {
            addCriterion("purchase_limit <>", value, "purchaseLimit");
            return (Criteria) this;
        }

        public Criteria andPurchaseLimitGreaterThan(Integer value) {
            addCriterion("purchase_limit >", value, "purchaseLimit");
            return (Criteria) this;
        }

        public Criteria andPurchaseLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_limit >=", value, "purchaseLimit");
            return (Criteria) this;
        }

        public Criteria andPurchaseLimitLessThan(Integer value) {
            addCriterion("purchase_limit <", value, "purchaseLimit");
            return (Criteria) this;
        }

        public Criteria andPurchaseLimitLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_limit <=", value, "purchaseLimit");
            return (Criteria) this;
        }

        public Criteria andPurchaseLimitIn(List<Integer> values) {
            addCriterion("purchase_limit in", values, "purchaseLimit");
            return (Criteria) this;
        }

        public Criteria andPurchaseLimitNotIn(List<Integer> values) {
            addCriterion("purchase_limit not in", values, "purchaseLimit");
            return (Criteria) this;
        }

        public Criteria andPurchaseLimitBetween(Integer value1, Integer value2) {
            addCriterion("purchase_limit between", value1, value2, "purchaseLimit");
            return (Criteria) this;
        }

        public Criteria andPurchaseLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_limit not between", value1, value2, "purchaseLimit");
            return (Criteria) this;
        }

        public Criteria andOrderPicIsNull() {
            addCriterion("order_pic is null");
            return (Criteria) this;
        }

        public Criteria andOrderPicIsNotNull() {
            addCriterion("order_pic is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPicEqualTo(String value) {
            addCriterion("order_pic =", value, "orderPic");
            return (Criteria) this;
        }

        public Criteria andOrderPicNotEqualTo(String value) {
            addCriterion("order_pic <>", value, "orderPic");
            return (Criteria) this;
        }

        public Criteria andOrderPicGreaterThan(String value) {
            addCriterion("order_pic >", value, "orderPic");
            return (Criteria) this;
        }

        public Criteria andOrderPicGreaterThanOrEqualTo(String value) {
            addCriterion("order_pic >=", value, "orderPic");
            return (Criteria) this;
        }

        public Criteria andOrderPicLessThan(String value) {
            addCriterion("order_pic <", value, "orderPic");
            return (Criteria) this;
        }

        public Criteria andOrderPicLessThanOrEqualTo(String value) {
            addCriterion("order_pic <=", value, "orderPic");
            return (Criteria) this;
        }

        public Criteria andOrderPicLike(String value) {
            addCriterion("order_pic like", value, "orderPic");
            return (Criteria) this;
        }

        public Criteria andOrderPicNotLike(String value) {
            addCriterion("order_pic not like", value, "orderPic");
            return (Criteria) this;
        }

        public Criteria andOrderPicIn(List<String> values) {
            addCriterion("order_pic in", values, "orderPic");
            return (Criteria) this;
        }

        public Criteria andOrderPicNotIn(List<String> values) {
            addCriterion("order_pic not in", values, "orderPic");
            return (Criteria) this;
        }

        public Criteria andOrderPicBetween(String value1, String value2) {
            addCriterion("order_pic between", value1, value2, "orderPic");
            return (Criteria) this;
        }

        public Criteria andOrderPicNotBetween(String value1, String value2) {
            addCriterion("order_pic not between", value1, value2, "orderPic");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Integer value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Integer value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Integer value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Integer value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Integer> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Integer> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andHeroIdIsNull() {
            addCriterion("hero_id is null");
            return (Criteria) this;
        }

        public Criteria andHeroIdIsNotNull() {
            addCriterion("hero_id is not null");
            return (Criteria) this;
        }

        public Criteria andHeroIdEqualTo(Integer value) {
            addCriterion("hero_id =", value, "heroId");
            return (Criteria) this;
        }

        public Criteria andHeroIdNotEqualTo(Integer value) {
            addCriterion("hero_id <>", value, "heroId");
            return (Criteria) this;
        }

        public Criteria andHeroIdGreaterThan(Integer value) {
            addCriterion("hero_id >", value, "heroId");
            return (Criteria) this;
        }

        public Criteria andHeroIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hero_id >=", value, "heroId");
            return (Criteria) this;
        }

        public Criteria andHeroIdLessThan(Integer value) {
            addCriterion("hero_id <", value, "heroId");
            return (Criteria) this;
        }

        public Criteria andHeroIdLessThanOrEqualTo(Integer value) {
            addCriterion("hero_id <=", value, "heroId");
            return (Criteria) this;
        }

        public Criteria andHeroIdIn(List<Integer> values) {
            addCriterion("hero_id in", values, "heroId");
            return (Criteria) this;
        }

        public Criteria andHeroIdNotIn(List<Integer> values) {
            addCriterion("hero_id not in", values, "heroId");
            return (Criteria) this;
        }

        public Criteria andHeroIdBetween(Integer value1, Integer value2) {
            addCriterion("hero_id between", value1, value2, "heroId");
            return (Criteria) this;
        }

        public Criteria andHeroIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hero_id not between", value1, value2, "heroId");
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