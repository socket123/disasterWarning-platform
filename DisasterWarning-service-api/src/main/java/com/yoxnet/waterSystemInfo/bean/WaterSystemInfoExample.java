package com.yoxnet.waterSystemInfo.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WaterSystemInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String fields;

    public WaterSystemInfoExample() {
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

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
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

        public Criteria andWaterSysNameIsNull() {
            addCriterion("water_sys_name is null");
            return (Criteria) this;
        }

        public Criteria andWaterSysNameIsNotNull() {
            addCriterion("water_sys_name is not null");
            return (Criteria) this;
        }

        public Criteria andWaterSysNameEqualTo(String value) {
            addCriterion("water_sys_name =", value, "waterSysName");
            return (Criteria) this;
        }

        public Criteria andWaterSysNameNotEqualTo(String value) {
            addCriterion("water_sys_name <>", value, "waterSysName");
            return (Criteria) this;
        }

        public Criteria andWaterSysNameGreaterThan(String value) {
            addCriterion("water_sys_name >", value, "waterSysName");
            return (Criteria) this;
        }

        public Criteria andWaterSysNameGreaterThanOrEqualTo(String value) {
            addCriterion("water_sys_name >=", value, "waterSysName");
            return (Criteria) this;
        }

        public Criteria andWaterSysNameLessThan(String value) {
            addCriterion("water_sys_name <", value, "waterSysName");
            return (Criteria) this;
        }

        public Criteria andWaterSysNameLessThanOrEqualTo(String value) {
            addCriterion("water_sys_name <=", value, "waterSysName");
            return (Criteria) this;
        }

        public Criteria andWaterSysNameLike(String value) {
            addCriterion("water_sys_name like", value, "waterSysName");
            return (Criteria) this;
        }

        public Criteria andWaterSysNameNotLike(String value) {
            addCriterion("water_sys_name not like", value, "waterSysName");
            return (Criteria) this;
        }

        public Criteria andWaterSysNameIn(List<String> values) {
            addCriterion("water_sys_name in", values, "waterSysName");
            return (Criteria) this;
        }

        public Criteria andWaterSysNameNotIn(List<String> values) {
            addCriterion("water_sys_name not in", values, "waterSysName");
            return (Criteria) this;
        }

        public Criteria andWaterSysNameBetween(String value1, String value2) {
            addCriterion("water_sys_name between", value1, value2, "waterSysName");
            return (Criteria) this;
        }

        public Criteria andWaterSysNameNotBetween(String value1, String value2) {
            addCriterion("water_sys_name not between", value1, value2, "waterSysName");
            return (Criteria) this;
        }

        public Criteria andFloodLevelIsNull() {
            addCriterion("flood_level is null");
            return (Criteria) this;
        }

        public Criteria andFloodLevelIsNotNull() {
            addCriterion("flood_level is not null");
            return (Criteria) this;
        }

        public Criteria andFloodLevelEqualTo(BigDecimal value) {
            addCriterion("flood_level =", value, "floodLevel");
            return (Criteria) this;
        }

        public Criteria andFloodLevelNotEqualTo(BigDecimal value) {
            addCriterion("flood_level <>", value, "floodLevel");
            return (Criteria) this;
        }

        public Criteria andFloodLevelGreaterThan(BigDecimal value) {
            addCriterion("flood_level >", value, "floodLevel");
            return (Criteria) this;
        }

        public Criteria andFloodLevelGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("flood_level >=", value, "floodLevel");
            return (Criteria) this;
        }

        public Criteria andFloodLevelLessThan(BigDecimal value) {
            addCriterion("flood_level <", value, "floodLevel");
            return (Criteria) this;
        }

        public Criteria andFloodLevelLessThanOrEqualTo(BigDecimal value) {
            addCriterion("flood_level <=", value, "floodLevel");
            return (Criteria) this;
        }

        public Criteria andFloodLevelIn(List<BigDecimal> values) {
            addCriterion("flood_level in", values, "floodLevel");
            return (Criteria) this;
        }

        public Criteria andFloodLevelNotIn(List<BigDecimal> values) {
            addCriterion("flood_level not in", values, "floodLevel");
            return (Criteria) this;
        }

        public Criteria andFloodLevelBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flood_level between", value1, value2, "floodLevel");
            return (Criteria) this;
        }

        public Criteria andFloodLevelNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("flood_level not between", value1, value2, "floodLevel");
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