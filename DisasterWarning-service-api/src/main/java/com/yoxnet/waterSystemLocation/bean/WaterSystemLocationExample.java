package com.yoxnet.waterSystemLocation.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WaterSystemLocationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String fields;

    public WaterSystemLocationExample() {
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

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWaterLocationIdIsNull() {
            addCriterion("water_location_id is null");
            return (Criteria) this;
        }

        public Criteria andWaterLocationIdIsNotNull() {
            addCriterion("water_location_id is not null");
            return (Criteria) this;
        }

        public Criteria andWaterLocationIdEqualTo(String value) {
            addCriterion("water_location_id =", value, "waterLocationId");
            return (Criteria) this;
        }

        public Criteria andWaterLocationIdNotEqualTo(String value) {
            addCriterion("water_location_id <>", value, "waterLocationId");
            return (Criteria) this;
        }

        public Criteria andWaterLocationIdGreaterThan(String value) {
            addCriterion("water_location_id >", value, "waterLocationId");
            return (Criteria) this;
        }

        public Criteria andWaterLocationIdGreaterThanOrEqualTo(String value) {
            addCriterion("water_location_id >=", value, "waterLocationId");
            return (Criteria) this;
        }

        public Criteria andWaterLocationIdLessThan(String value) {
            addCriterion("water_location_id <", value, "waterLocationId");
            return (Criteria) this;
        }

        public Criteria andWaterLocationIdLessThanOrEqualTo(String value) {
            addCriterion("water_location_id <=", value, "waterLocationId");
            return (Criteria) this;
        }

        public Criteria andWaterLocationIdLike(String value) {
            addCriterion("water_location_id like", value, "waterLocationId");
            return (Criteria) this;
        }

        public Criteria andWaterLocationIdNotLike(String value) {
            addCriterion("water_location_id not like", value, "waterLocationId");
            return (Criteria) this;
        }

        public Criteria andWaterLocationIdIn(List<String> values) {
            addCriterion("water_location_id in", values, "waterLocationId");
            return (Criteria) this;
        }

        public Criteria andWaterLocationIdNotIn(List<String> values) {
            addCriterion("water_location_id not in", values, "waterLocationId");
            return (Criteria) this;
        }

        public Criteria andWaterLocationIdBetween(String value1, String value2) {
            addCriterion("water_location_id between", value1, value2, "waterLocationId");
            return (Criteria) this;
        }

        public Criteria andWaterLocationIdNotBetween(String value1, String value2) {
            addCriterion("water_location_id not between", value1, value2, "waterLocationId");
            return (Criteria) this;
        }

        public Criteria andWaterSysIdIsNull() {
            addCriterion("water_sys_id is null");
            return (Criteria) this;
        }

        public Criteria andWaterSysIdIsNotNull() {
            addCriterion("water_sys_id is not null");
            return (Criteria) this;
        }

        public Criteria andWaterSysIdEqualTo(String value) {
            addCriterion("water_sys_id =", value, "waterSysId");
            return (Criteria) this;
        }

        public Criteria andWaterSysIdNotEqualTo(String value) {
            addCriterion("water_sys_id <>", value, "waterSysId");
            return (Criteria) this;
        }

        public Criteria andWaterSysIdGreaterThan(String value) {
            addCriterion("water_sys_id >", value, "waterSysId");
            return (Criteria) this;
        }

        public Criteria andWaterSysIdGreaterThanOrEqualTo(String value) {
            addCriterion("water_sys_id >=", value, "waterSysId");
            return (Criteria) this;
        }

        public Criteria andWaterSysIdLessThan(String value) {
            addCriterion("water_sys_id <", value, "waterSysId");
            return (Criteria) this;
        }

        public Criteria andWaterSysIdLessThanOrEqualTo(String value) {
            addCriterion("water_sys_id <=", value, "waterSysId");
            return (Criteria) this;
        }

        public Criteria andWaterSysIdLike(String value) {
            addCriterion("water_sys_id like", value, "waterSysId");
            return (Criteria) this;
        }

        public Criteria andWaterSysIdNotLike(String value) {
            addCriterion("water_sys_id not like", value, "waterSysId");
            return (Criteria) this;
        }

        public Criteria andWaterSysIdIn(List<String> values) {
            addCriterion("water_sys_id in", values, "waterSysId");
            return (Criteria) this;
        }

        public Criteria andWaterSysIdNotIn(List<String> values) {
            addCriterion("water_sys_id not in", values, "waterSysId");
            return (Criteria) this;
        }

        public Criteria andWaterSysIdBetween(String value1, String value2) {
            addCriterion("water_sys_id between", value1, value2, "waterSysId");
            return (Criteria) this;
        }

        public Criteria andWaterSysIdNotBetween(String value1, String value2) {
            addCriterion("water_sys_id not between", value1, value2, "waterSysId");
            return (Criteria) this;
        }

        public Criteria andLocationLongitudeIsNull() {
            addCriterion("location_longitude is null");
            return (Criteria) this;
        }

        public Criteria andLocationLongitudeIsNotNull() {
            addCriterion("location_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLocationLongitudeEqualTo(BigDecimal value) {
            addCriterion("location_longitude =", value, "locationLongitude");
            return (Criteria) this;
        }

        public Criteria andLocationLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("location_longitude <>", value, "locationLongitude");
            return (Criteria) this;
        }

        public Criteria andLocationLongitudeGreaterThan(BigDecimal value) {
            addCriterion("location_longitude >", value, "locationLongitude");
            return (Criteria) this;
        }

        public Criteria andLocationLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("location_longitude >=", value, "locationLongitude");
            return (Criteria) this;
        }

        public Criteria andLocationLongitudeLessThan(BigDecimal value) {
            addCriterion("location_longitude <", value, "locationLongitude");
            return (Criteria) this;
        }

        public Criteria andLocationLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("location_longitude <=", value, "locationLongitude");
            return (Criteria) this;
        }

        public Criteria andLocationLongitudeIn(List<BigDecimal> values) {
            addCriterion("location_longitude in", values, "locationLongitude");
            return (Criteria) this;
        }

        public Criteria andLocationLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("location_longitude not in", values, "locationLongitude");
            return (Criteria) this;
        }

        public Criteria andLocationLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("location_longitude between", value1, value2, "locationLongitude");
            return (Criteria) this;
        }

        public Criteria andLocationLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("location_longitude not between", value1, value2, "locationLongitude");
            return (Criteria) this;
        }

        public Criteria andLocationLatitudeIsNull() {
            addCriterion("location_latitude is null");
            return (Criteria) this;
        }

        public Criteria andLocationLatitudeIsNotNull() {
            addCriterion("location_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLocationLatitudeEqualTo(BigDecimal value) {
            addCriterion("location_latitude =", value, "locationLatitude");
            return (Criteria) this;
        }

        public Criteria andLocationLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("location_latitude <>", value, "locationLatitude");
            return (Criteria) this;
        }

        public Criteria andLocationLatitudeGreaterThan(BigDecimal value) {
            addCriterion("location_latitude >", value, "locationLatitude");
            return (Criteria) this;
        }

        public Criteria andLocationLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("location_latitude >=", value, "locationLatitude");
            return (Criteria) this;
        }

        public Criteria andLocationLatitudeLessThan(BigDecimal value) {
            addCriterion("location_latitude <", value, "locationLatitude");
            return (Criteria) this;
        }

        public Criteria andLocationLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("location_latitude <=", value, "locationLatitude");
            return (Criteria) this;
        }

        public Criteria andLocationLatitudeIn(List<BigDecimal> values) {
            addCriterion("location_latitude in", values, "locationLatitude");
            return (Criteria) this;
        }

        public Criteria andLocationLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("location_latitude not in", values, "locationLatitude");
            return (Criteria) this;
        }

        public Criteria andLocationLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("location_latitude between", value1, value2, "locationLatitude");
            return (Criteria) this;
        }

        public Criteria andLocationLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("location_latitude not between", value1, value2, "locationLatitude");
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