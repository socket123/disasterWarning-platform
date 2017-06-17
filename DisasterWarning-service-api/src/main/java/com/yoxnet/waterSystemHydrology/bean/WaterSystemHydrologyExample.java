package com.yoxnet.waterSystemHydrology.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WaterSystemHydrologyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String fields;

    public WaterSystemHydrologyExample() {
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

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andWaterLevelIsNull() {
            addCriterion("water_level is null");
            return (Criteria) this;
        }

        public Criteria andWaterLevelIsNotNull() {
            addCriterion("water_level is not null");
            return (Criteria) this;
        }

        public Criteria andWaterLevelEqualTo(BigDecimal value) {
            addCriterion("water_level =", value, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelNotEqualTo(BigDecimal value) {
            addCriterion("water_level <>", value, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelGreaterThan(BigDecimal value) {
            addCriterion("water_level >", value, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("water_level >=", value, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelLessThan(BigDecimal value) {
            addCriterion("water_level <", value, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelLessThanOrEqualTo(BigDecimal value) {
            addCriterion("water_level <=", value, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelIn(List<BigDecimal> values) {
            addCriterion("water_level in", values, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelNotIn(List<BigDecimal> values) {
            addCriterion("water_level not in", values, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("water_level between", value1, value2, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andWaterLevelNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("water_level not between", value1, value2, "waterLevel");
            return (Criteria) this;
        }

        public Criteria andFlowIsNull() {
            addCriterion("flow is null");
            return (Criteria) this;
        }

        public Criteria andFlowIsNotNull() {
            addCriterion("flow is not null");
            return (Criteria) this;
        }

        public Criteria andFlowEqualTo(BigDecimal value) {
            addCriterion("flow =", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowNotEqualTo(BigDecimal value) {
            addCriterion("flow <>", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowGreaterThan(BigDecimal value) {
            addCriterion("flow >", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("flow >=", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowLessThan(BigDecimal value) {
            addCriterion("flow <", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("flow <=", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowIn(List<BigDecimal> values) {
            addCriterion("flow in", values, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowNotIn(List<BigDecimal> values) {
            addCriterion("flow not in", values, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flow between", value1, value2, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flow not between", value1, value2, "flow");
            return (Criteria) this;
        }

        public Criteria andSiltConcentrationIsNull() {
            addCriterion("silt_concentration is null");
            return (Criteria) this;
        }

        public Criteria andSiltConcentrationIsNotNull() {
            addCriterion("silt_concentration is not null");
            return (Criteria) this;
        }

        public Criteria andSiltConcentrationEqualTo(BigDecimal value) {
            addCriterion("silt_concentration =", value, "siltConcentration");
            return (Criteria) this;
        }

        public Criteria andSiltConcentrationNotEqualTo(BigDecimal value) {
            addCriterion("silt_concentration <>", value, "siltConcentration");
            return (Criteria) this;
        }

        public Criteria andSiltConcentrationGreaterThan(BigDecimal value) {
            addCriterion("silt_concentration >", value, "siltConcentration");
            return (Criteria) this;
        }

        public Criteria andSiltConcentrationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("silt_concentration >=", value, "siltConcentration");
            return (Criteria) this;
        }

        public Criteria andSiltConcentrationLessThan(BigDecimal value) {
            addCriterion("silt_concentration <", value, "siltConcentration");
            return (Criteria) this;
        }

        public Criteria andSiltConcentrationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("silt_concentration <=", value, "siltConcentration");
            return (Criteria) this;
        }

        public Criteria andSiltConcentrationIn(List<BigDecimal> values) {
            addCriterion("silt_concentration in", values, "siltConcentration");
            return (Criteria) this;
        }

        public Criteria andSiltConcentrationNotIn(List<BigDecimal> values) {
            addCriterion("silt_concentration not in", values, "siltConcentration");
            return (Criteria) this;
        }

        public Criteria andSiltConcentrationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("silt_concentration between", value1, value2, "siltConcentration");
            return (Criteria) this;
        }

        public Criteria andSiltConcentrationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("silt_concentration not between", value1, value2, "siltConcentration");
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