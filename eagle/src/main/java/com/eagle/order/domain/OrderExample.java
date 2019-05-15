package com.eagle.order.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNoIsNull() {
            addCriterion("no is null");
            return (Criteria) this;
        }

        public Criteria andNoIsNotNull() {
            addCriterion("no is not null");
            return (Criteria) this;
        }

        public Criteria andNoEqualTo(String value) {
            addCriterion("no =", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotEqualTo(String value) {
            addCriterion("no <>", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThan(String value) {
            addCriterion("no >", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThanOrEqualTo(String value) {
            addCriterion("no >=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThan(String value) {
            addCriterion("no <", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThanOrEqualTo(String value) {
            addCriterion("no <=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLike(String value) {
            addCriterion("no like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotLike(String value) {
            addCriterion("no not like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoIn(List<String> values) {
            addCriterion("no in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotIn(List<String> values) {
            addCriterion("no not in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoBetween(String value1, String value2) {
            addCriterion("no between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotBetween(String value1, String value2) {
            addCriterion("no not between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andOrderDateIsNull() {
            addCriterion("order_date is null");
            return (Criteria) this;
        }

        public Criteria andOrderDateIsNotNull() {
            addCriterion("order_date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDateEqualTo(Date value) {
            addCriterionForJDBCDate("order_date =", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("order_date <>", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThan(Date value) {
            addCriterionForJDBCDate("order_date >", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_date >=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThan(Date value) {
            addCriterionForJDBCDate("order_date <", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_date <=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateIn(List<Date> values) {
            addCriterionForJDBCDate("order_date in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("order_date not in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_date between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_date not between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(Long value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(Long value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(Long value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(Long value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(Long value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(Long value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<Long> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<Long> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(Long value1, Long value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(Long value1, Long value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNull() {
            addCriterion("volume is null");
            return (Criteria) this;
        }

        public Criteria andVolumeIsNotNull() {
            addCriterion("volume is not null");
            return (Criteria) this;
        }

        public Criteria andVolumeEqualTo(BigDecimal value) {
            addCriterion("volume =", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotEqualTo(BigDecimal value) {
            addCriterion("volume <>", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThan(BigDecimal value) {
            addCriterion("volume >", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("volume >=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThan(BigDecimal value) {
            addCriterion("volume <", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("volume <=", value, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeIn(List<BigDecimal> values) {
            addCriterion("volume in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotIn(List<BigDecimal> values) {
            addCriterion("volume not in", values, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("volume between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("volume not between", value1, value2, "volume");
            return (Criteria) this;
        }

        public Criteria andFreightMonthlyIsNull() {
            addCriterion("freight_monthly is null");
            return (Criteria) this;
        }

        public Criteria andFreightMonthlyIsNotNull() {
            addCriterion("freight_monthly is not null");
            return (Criteria) this;
        }

        public Criteria andFreightMonthlyEqualTo(BigDecimal value) {
            addCriterion("freight_monthly =", value, "freightMonthly");
            return (Criteria) this;
        }

        public Criteria andFreightMonthlyNotEqualTo(BigDecimal value) {
            addCriterion("freight_monthly <>", value, "freightMonthly");
            return (Criteria) this;
        }

        public Criteria andFreightMonthlyGreaterThan(BigDecimal value) {
            addCriterion("freight_monthly >", value, "freightMonthly");
            return (Criteria) this;
        }

        public Criteria andFreightMonthlyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freight_monthly >=", value, "freightMonthly");
            return (Criteria) this;
        }

        public Criteria andFreightMonthlyLessThan(BigDecimal value) {
            addCriterion("freight_monthly <", value, "freightMonthly");
            return (Criteria) this;
        }

        public Criteria andFreightMonthlyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freight_monthly <=", value, "freightMonthly");
            return (Criteria) this;
        }

        public Criteria andFreightMonthlyIn(List<BigDecimal> values) {
            addCriterion("freight_monthly in", values, "freightMonthly");
            return (Criteria) this;
        }

        public Criteria andFreightMonthlyNotIn(List<BigDecimal> values) {
            addCriterion("freight_monthly not in", values, "freightMonthly");
            return (Criteria) this;
        }

        public Criteria andFreightMonthlyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freight_monthly between", value1, value2, "freightMonthly");
            return (Criteria) this;
        }

        public Criteria andFreightMonthlyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freight_monthly not between", value1, value2, "freightMonthly");
            return (Criteria) this;
        }

        public Criteria andFreightNowIsNull() {
            addCriterion("freight_now is null");
            return (Criteria) this;
        }

        public Criteria andFreightNowIsNotNull() {
            addCriterion("freight_now is not null");
            return (Criteria) this;
        }

        public Criteria andFreightNowEqualTo(BigDecimal value) {
            addCriterion("freight_now =", value, "freightNow");
            return (Criteria) this;
        }

        public Criteria andFreightNowNotEqualTo(BigDecimal value) {
            addCriterion("freight_now <>", value, "freightNow");
            return (Criteria) this;
        }

        public Criteria andFreightNowGreaterThan(BigDecimal value) {
            addCriterion("freight_now >", value, "freightNow");
            return (Criteria) this;
        }

        public Criteria andFreightNowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freight_now >=", value, "freightNow");
            return (Criteria) this;
        }

        public Criteria andFreightNowLessThan(BigDecimal value) {
            addCriterion("freight_now <", value, "freightNow");
            return (Criteria) this;
        }

        public Criteria andFreightNowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freight_now <=", value, "freightNow");
            return (Criteria) this;
        }

        public Criteria andFreightNowIn(List<BigDecimal> values) {
            addCriterion("freight_now in", values, "freightNow");
            return (Criteria) this;
        }

        public Criteria andFreightNowNotIn(List<BigDecimal> values) {
            addCriterion("freight_now not in", values, "freightNow");
            return (Criteria) this;
        }

        public Criteria andFreightNowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freight_now between", value1, value2, "freightNow");
            return (Criteria) this;
        }

        public Criteria andFreightNowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freight_now not between", value1, value2, "freightNow");
            return (Criteria) this;
        }

        public Criteria andFreightArriveIsNull() {
            addCriterion("freight_arrive is null");
            return (Criteria) this;
        }

        public Criteria andFreightArriveIsNotNull() {
            addCriterion("freight_arrive is not null");
            return (Criteria) this;
        }

        public Criteria andFreightArriveEqualTo(BigDecimal value) {
            addCriterion("freight_arrive =", value, "freightArrive");
            return (Criteria) this;
        }

        public Criteria andFreightArriveNotEqualTo(BigDecimal value) {
            addCriterion("freight_arrive <>", value, "freightArrive");
            return (Criteria) this;
        }

        public Criteria andFreightArriveGreaterThan(BigDecimal value) {
            addCriterion("freight_arrive >", value, "freightArrive");
            return (Criteria) this;
        }

        public Criteria andFreightArriveGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("freight_arrive >=", value, "freightArrive");
            return (Criteria) this;
        }

        public Criteria andFreightArriveLessThan(BigDecimal value) {
            addCriterion("freight_arrive <", value, "freightArrive");
            return (Criteria) this;
        }

        public Criteria andFreightArriveLessThanOrEqualTo(BigDecimal value) {
            addCriterion("freight_arrive <=", value, "freightArrive");
            return (Criteria) this;
        }

        public Criteria andFreightArriveIn(List<BigDecimal> values) {
            addCriterion("freight_arrive in", values, "freightArrive");
            return (Criteria) this;
        }

        public Criteria andFreightArriveNotIn(List<BigDecimal> values) {
            addCriterion("freight_arrive not in", values, "freightArrive");
            return (Criteria) this;
        }

        public Criteria andFreightArriveBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freight_arrive between", value1, value2, "freightArrive");
            return (Criteria) this;
        }

        public Criteria andFreightArriveNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("freight_arrive not between", value1, value2, "freightArrive");
            return (Criteria) this;
        }

        public Criteria andCostFreightIsNull() {
            addCriterion("cost_freight is null");
            return (Criteria) this;
        }

        public Criteria andCostFreightIsNotNull() {
            addCriterion("cost_freight is not null");
            return (Criteria) this;
        }

        public Criteria andCostFreightEqualTo(BigDecimal value) {
            addCriterion("cost_freight =", value, "costFreight");
            return (Criteria) this;
        }

        public Criteria andCostFreightNotEqualTo(BigDecimal value) {
            addCriterion("cost_freight <>", value, "costFreight");
            return (Criteria) this;
        }

        public Criteria andCostFreightGreaterThan(BigDecimal value) {
            addCriterion("cost_freight >", value, "costFreight");
            return (Criteria) this;
        }

        public Criteria andCostFreightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_freight >=", value, "costFreight");
            return (Criteria) this;
        }

        public Criteria andCostFreightLessThan(BigDecimal value) {
            addCriterion("cost_freight <", value, "costFreight");
            return (Criteria) this;
        }

        public Criteria andCostFreightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_freight <=", value, "costFreight");
            return (Criteria) this;
        }

        public Criteria andCostFreightIn(List<BigDecimal> values) {
            addCriterion("cost_freight in", values, "costFreight");
            return (Criteria) this;
        }

        public Criteria andCostFreightNotIn(List<BigDecimal> values) {
            addCriterion("cost_freight not in", values, "costFreight");
            return (Criteria) this;
        }

        public Criteria andCostFreightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_freight between", value1, value2, "costFreight");
            return (Criteria) this;
        }

        public Criteria andCostFreightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_freight not between", value1, value2, "costFreight");
            return (Criteria) this;
        }

        public Criteria andCostDirectIsNull() {
            addCriterion("cost_direct is null");
            return (Criteria) this;
        }

        public Criteria andCostDirectIsNotNull() {
            addCriterion("cost_direct is not null");
            return (Criteria) this;
        }

        public Criteria andCostDirectEqualTo(BigDecimal value) {
            addCriterion("cost_direct =", value, "costDirect");
            return (Criteria) this;
        }

        public Criteria andCostDirectNotEqualTo(BigDecimal value) {
            addCriterion("cost_direct <>", value, "costDirect");
            return (Criteria) this;
        }

        public Criteria andCostDirectGreaterThan(BigDecimal value) {
            addCriterion("cost_direct >", value, "costDirect");
            return (Criteria) this;
        }

        public Criteria andCostDirectGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_direct >=", value, "costDirect");
            return (Criteria) this;
        }

        public Criteria andCostDirectLessThan(BigDecimal value) {
            addCriterion("cost_direct <", value, "costDirect");
            return (Criteria) this;
        }

        public Criteria andCostDirectLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_direct <=", value, "costDirect");
            return (Criteria) this;
        }

        public Criteria andCostDirectIn(List<BigDecimal> values) {
            addCriterion("cost_direct in", values, "costDirect");
            return (Criteria) this;
        }

        public Criteria andCostDirectNotIn(List<BigDecimal> values) {
            addCriterion("cost_direct not in", values, "costDirect");
            return (Criteria) this;
        }

        public Criteria andCostDirectBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_direct between", value1, value2, "costDirect");
            return (Criteria) this;
        }

        public Criteria andCostDirectNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_direct not between", value1, value2, "costDirect");
            return (Criteria) this;
        }

        public Criteria andCostInsuranceIsNull() {
            addCriterion("cost_insurance is null");
            return (Criteria) this;
        }

        public Criteria andCostInsuranceIsNotNull() {
            addCriterion("cost_insurance is not null");
            return (Criteria) this;
        }

        public Criteria andCostInsuranceEqualTo(BigDecimal value) {
            addCriterion("cost_insurance =", value, "costInsurance");
            return (Criteria) this;
        }

        public Criteria andCostInsuranceNotEqualTo(BigDecimal value) {
            addCriterion("cost_insurance <>", value, "costInsurance");
            return (Criteria) this;
        }

        public Criteria andCostInsuranceGreaterThan(BigDecimal value) {
            addCriterion("cost_insurance >", value, "costInsurance");
            return (Criteria) this;
        }

        public Criteria andCostInsuranceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_insurance >=", value, "costInsurance");
            return (Criteria) this;
        }

        public Criteria andCostInsuranceLessThan(BigDecimal value) {
            addCriterion("cost_insurance <", value, "costInsurance");
            return (Criteria) this;
        }

        public Criteria andCostInsuranceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cost_insurance <=", value, "costInsurance");
            return (Criteria) this;
        }

        public Criteria andCostInsuranceIn(List<BigDecimal> values) {
            addCriterion("cost_insurance in", values, "costInsurance");
            return (Criteria) this;
        }

        public Criteria andCostInsuranceNotIn(List<BigDecimal> values) {
            addCriterion("cost_insurance not in", values, "costInsurance");
            return (Criteria) this;
        }

        public Criteria andCostInsuranceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_insurance between", value1, value2, "costInsurance");
            return (Criteria) this;
        }

        public Criteria andCostInsuranceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cost_insurance not between", value1, value2, "costInsurance");
            return (Criteria) this;
        }

        public Criteria andTransferCompanyIdIsNull() {
            addCriterion("transfer_company_id is null");
            return (Criteria) this;
        }

        public Criteria andTransferCompanyIdIsNotNull() {
            addCriterion("transfer_company_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransferCompanyIdEqualTo(Long value) {
            addCriterion("transfer_company_id =", value, "transferCompanyId");
            return (Criteria) this;
        }

        public Criteria andTransferCompanyIdNotEqualTo(Long value) {
            addCriterion("transfer_company_id <>", value, "transferCompanyId");
            return (Criteria) this;
        }

        public Criteria andTransferCompanyIdGreaterThan(Long value) {
            addCriterion("transfer_company_id >", value, "transferCompanyId");
            return (Criteria) this;
        }

        public Criteria andTransferCompanyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("transfer_company_id >=", value, "transferCompanyId");
            return (Criteria) this;
        }

        public Criteria andTransferCompanyIdLessThan(Long value) {
            addCriterion("transfer_company_id <", value, "transferCompanyId");
            return (Criteria) this;
        }

        public Criteria andTransferCompanyIdLessThanOrEqualTo(Long value) {
            addCriterion("transfer_company_id <=", value, "transferCompanyId");
            return (Criteria) this;
        }

        public Criteria andTransferCompanyIdIn(List<Long> values) {
            addCriterion("transfer_company_id in", values, "transferCompanyId");
            return (Criteria) this;
        }

        public Criteria andTransferCompanyIdNotIn(List<Long> values) {
            addCriterion("transfer_company_id not in", values, "transferCompanyId");
            return (Criteria) this;
        }

        public Criteria andTransferCompanyIdBetween(Long value1, Long value2) {
            addCriterion("transfer_company_id between", value1, value2, "transferCompanyId");
            return (Criteria) this;
        }

        public Criteria andTransferCompanyIdNotBetween(Long value1, Long value2) {
            addCriterion("transfer_company_id not between", value1, value2, "transferCompanyId");
            return (Criteria) this;
        }

        public Criteria andTransferNoIsNull() {
            addCriterion("transfer_no is null");
            return (Criteria) this;
        }

        public Criteria andTransferNoIsNotNull() {
            addCriterion("transfer_no is not null");
            return (Criteria) this;
        }

        public Criteria andTransferNoEqualTo(String value) {
            addCriterion("transfer_no =", value, "transferNo");
            return (Criteria) this;
        }

        public Criteria andTransferNoNotEqualTo(String value) {
            addCriterion("transfer_no <>", value, "transferNo");
            return (Criteria) this;
        }

        public Criteria andTransferNoGreaterThan(String value) {
            addCriterion("transfer_no >", value, "transferNo");
            return (Criteria) this;
        }

        public Criteria andTransferNoGreaterThanOrEqualTo(String value) {
            addCriterion("transfer_no >=", value, "transferNo");
            return (Criteria) this;
        }

        public Criteria andTransferNoLessThan(String value) {
            addCriterion("transfer_no <", value, "transferNo");
            return (Criteria) this;
        }

        public Criteria andTransferNoLessThanOrEqualTo(String value) {
            addCriterion("transfer_no <=", value, "transferNo");
            return (Criteria) this;
        }

        public Criteria andTransferNoLike(String value) {
            addCriterion("transfer_no like", value, "transferNo");
            return (Criteria) this;
        }

        public Criteria andTransferNoNotLike(String value) {
            addCriterion("transfer_no not like", value, "transferNo");
            return (Criteria) this;
        }

        public Criteria andTransferNoIn(List<String> values) {
            addCriterion("transfer_no in", values, "transferNo");
            return (Criteria) this;
        }

        public Criteria andTransferNoNotIn(List<String> values) {
            addCriterion("transfer_no not in", values, "transferNo");
            return (Criteria) this;
        }

        public Criteria andTransferNoBetween(String value1, String value2) {
            addCriterion("transfer_no between", value1, value2, "transferNo");
            return (Criteria) this;
        }

        public Criteria andTransferNoNotBetween(String value1, String value2) {
            addCriterion("transfer_no not between", value1, value2, "transferNo");
            return (Criteria) this;
        }

        public Criteria andReceiptIsNull() {
            addCriterion("receipt is null");
            return (Criteria) this;
        }

        public Criteria andReceiptIsNotNull() {
            addCriterion("receipt is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptEqualTo(Date value) {
            addCriterionForJDBCDate("receipt =", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptNotEqualTo(Date value) {
            addCriterionForJDBCDate("receipt <>", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptGreaterThan(Date value) {
            addCriterionForJDBCDate("receipt >", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("receipt >=", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptLessThan(Date value) {
            addCriterionForJDBCDate("receipt <", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("receipt <=", value, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptIn(List<Date> values) {
            addCriterionForJDBCDate("receipt in", values, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptNotIn(List<Date> values) {
            addCriterionForJDBCDate("receipt not in", values, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("receipt between", value1, value2, "receipt");
            return (Criteria) this;
        }

        public Criteria andReceiptNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("receipt not between", value1, value2, "receipt");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("modify_date is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("modify_date =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("modify_date <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("modify_date >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_date >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("modify_date <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("modify_date <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("modify_date in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("modify_date not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("modify_date between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("modify_date not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(BigDecimal value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(BigDecimal value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(BigDecimal value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(BigDecimal value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<BigDecimal> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<BigDecimal> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("commission not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdIsNull() {
            addCriterion("salesman_id is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdIsNotNull() {
            addCriterion("salesman_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdEqualTo(Long value) {
            addCriterion("salesman_id =", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotEqualTo(Long value) {
            addCriterion("salesman_id <>", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdGreaterThan(Long value) {
            addCriterion("salesman_id >", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("salesman_id >=", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdLessThan(Long value) {
            addCriterion("salesman_id <", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdLessThanOrEqualTo(Long value) {
            addCriterion("salesman_id <=", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdIn(List<Long> values) {
            addCriterion("o.salesman_id in", values, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotIn(List<Long> values) {
            addCriterion("salesman_id not in", values, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdBetween(Long value1, Long value2) {
            addCriterion("salesman_id between", value1, value2, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotBetween(Long value1, Long value2) {
            addCriterion("salesman_id not between", value1, value2, "salesmanId");
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