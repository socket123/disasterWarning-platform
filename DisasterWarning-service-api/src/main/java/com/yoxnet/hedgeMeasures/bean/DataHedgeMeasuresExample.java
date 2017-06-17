package com.yoxnet.hedgeMeasures.bean;

import java.util.ArrayList;
import java.util.List;

public class DataHedgeMeasuresExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String fields;

    public DataHedgeMeasuresExample() {
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

        public Criteria andDisasterTypeIsNull() {
            addCriterion("disaster_type is null");
            return (Criteria) this;
        }

        public Criteria andDisasterTypeIsNotNull() {
            addCriterion("disaster_type is not null");
            return (Criteria) this;
        }

        public Criteria andDisasterTypeEqualTo(String value) {
            addCriterion("disaster_type =", value, "disasterType");
            return (Criteria) this;
        }

        public Criteria andDisasterTypeNotEqualTo(String value) {
            addCriterion("disaster_type <>", value, "disasterType");
            return (Criteria) this;
        }

        public Criteria andDisasterTypeGreaterThan(String value) {
            addCriterion("disaster_type >", value, "disasterType");
            return (Criteria) this;
        }

        public Criteria andDisasterTypeGreaterThanOrEqualTo(String value) {
            addCriterion("disaster_type >=", value, "disasterType");
            return (Criteria) this;
        }

        public Criteria andDisasterTypeLessThan(String value) {
            addCriterion("disaster_type <", value, "disasterType");
            return (Criteria) this;
        }

        public Criteria andDisasterTypeLessThanOrEqualTo(String value) {
            addCriterion("disaster_type <=", value, "disasterType");
            return (Criteria) this;
        }

        public Criteria andDisasterTypeLike(String value) {
            addCriterion("disaster_type like", value, "disasterType");
            return (Criteria) this;
        }

        public Criteria andDisasterTypeNotLike(String value) {
            addCriterion("disaster_type not like", value, "disasterType");
            return (Criteria) this;
        }

        public Criteria andDisasterTypeIn(List<String> values) {
            addCriterion("disaster_type in", values, "disasterType");
            return (Criteria) this;
        }

        public Criteria andDisasterTypeNotIn(List<String> values) {
            addCriterion("disaster_type not in", values, "disasterType");
            return (Criteria) this;
        }

        public Criteria andDisasterTypeBetween(String value1, String value2) {
            addCriterion("disaster_type between", value1, value2, "disasterType");
            return (Criteria) this;
        }

        public Criteria andDisasterTypeNotBetween(String value1, String value2) {
            addCriterion("disaster_type not between", value1, value2, "disasterType");
            return (Criteria) this;
        }

        public Criteria andDisasterLevelIsNull() {
            addCriterion("disaster_level is null");
            return (Criteria) this;
        }

        public Criteria andDisasterLevelIsNotNull() {
            addCriterion("disaster_level is not null");
            return (Criteria) this;
        }

        public Criteria andDisasterLevelEqualTo(String value) {
            addCriterion("disaster_level =", value, "disasterLevel");
            return (Criteria) this;
        }

        public Criteria andDisasterLevelNotEqualTo(String value) {
            addCriterion("disaster_level <>", value, "disasterLevel");
            return (Criteria) this;
        }

        public Criteria andDisasterLevelGreaterThan(String value) {
            addCriterion("disaster_level >", value, "disasterLevel");
            return (Criteria) this;
        }

        public Criteria andDisasterLevelGreaterThanOrEqualTo(String value) {
            addCriterion("disaster_level >=", value, "disasterLevel");
            return (Criteria) this;
        }

        public Criteria andDisasterLevelLessThan(String value) {
            addCriterion("disaster_level <", value, "disasterLevel");
            return (Criteria) this;
        }

        public Criteria andDisasterLevelLessThanOrEqualTo(String value) {
            addCriterion("disaster_level <=", value, "disasterLevel");
            return (Criteria) this;
        }

        public Criteria andDisasterLevelLike(String value) {
            addCriterion("disaster_level like", value, "disasterLevel");
            return (Criteria) this;
        }

        public Criteria andDisasterLevelNotLike(String value) {
            addCriterion("disaster_level not like", value, "disasterLevel");
            return (Criteria) this;
        }

        public Criteria andDisasterLevelIn(List<String> values) {
            addCriterion("disaster_level in", values, "disasterLevel");
            return (Criteria) this;
        }

        public Criteria andDisasterLevelNotIn(List<String> values) {
            addCriterion("disaster_level not in", values, "disasterLevel");
            return (Criteria) this;
        }

        public Criteria andDisasterLevelBetween(String value1, String value2) {
            addCriterion("disaster_level between", value1, value2, "disasterLevel");
            return (Criteria) this;
        }

        public Criteria andDisasterLevelNotBetween(String value1, String value2) {
            addCriterion("disaster_level not between", value1, value2, "disasterLevel");
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