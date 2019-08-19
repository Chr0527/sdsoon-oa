package com.sdsoon.modular.system.po;

import java.util.ArrayList;
import java.util.List;

public class SsUserPasswordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SsUserPasswordExample() {
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

        public Criteria andGUserIdIsNull() {
            addCriterion("g_user_id is null");
            return (Criteria) this;
        }

        public Criteria andGUserIdIsNotNull() {
            addCriterion("g_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andGUserIdEqualTo(String value) {
            addCriterion("g_user_id =", value, "gUserId");
            return (Criteria) this;
        }

        public Criteria andGUserIdNotEqualTo(String value) {
            addCriterion("g_user_id <>", value, "gUserId");
            return (Criteria) this;
        }

        public Criteria andGUserIdGreaterThan(String value) {
            addCriterion("g_user_id >", value, "gUserId");
            return (Criteria) this;
        }

        public Criteria andGUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("g_user_id >=", value, "gUserId");
            return (Criteria) this;
        }

        public Criteria andGUserIdLessThan(String value) {
            addCriterion("g_user_id <", value, "gUserId");
            return (Criteria) this;
        }

        public Criteria andGUserIdLessThanOrEqualTo(String value) {
            addCriterion("g_user_id <=", value, "gUserId");
            return (Criteria) this;
        }

        public Criteria andGUserIdLike(String value) {
            addCriterion("g_user_id like", value, "gUserId");
            return (Criteria) this;
        }

        public Criteria andGUserIdNotLike(String value) {
            addCriterion("g_user_id not like", value, "gUserId");
            return (Criteria) this;
        }

        public Criteria andGUserIdIn(List<String> values) {
            addCriterion("g_user_id in", values, "gUserId");
            return (Criteria) this;
        }

        public Criteria andGUserIdNotIn(List<String> values) {
            addCriterion("g_user_id not in", values, "gUserId");
            return (Criteria) this;
        }

        public Criteria andGUserIdBetween(String value1, String value2) {
            addCriterion("g_user_id between", value1, value2, "gUserId");
            return (Criteria) this;
        }

        public Criteria andGUserIdNotBetween(String value1, String value2) {
            addCriterion("g_user_id not between", value1, value2, "gUserId");
            return (Criteria) this;
        }

        public Criteria andEncryptPasswordIsNull() {
            addCriterion("encrypt_password is null");
            return (Criteria) this;
        }

        public Criteria andEncryptPasswordIsNotNull() {
            addCriterion("encrypt_password is not null");
            return (Criteria) this;
        }

        public Criteria andEncryptPasswordEqualTo(String value) {
            addCriterion("encrypt_password =", value, "encryptPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptPasswordNotEqualTo(String value) {
            addCriterion("encrypt_password <>", value, "encryptPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptPasswordGreaterThan(String value) {
            addCriterion("encrypt_password >", value, "encryptPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("encrypt_password >=", value, "encryptPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptPasswordLessThan(String value) {
            addCriterion("encrypt_password <", value, "encryptPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptPasswordLessThanOrEqualTo(String value) {
            addCriterion("encrypt_password <=", value, "encryptPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptPasswordLike(String value) {
            addCriterion("encrypt_password like", value, "encryptPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptPasswordNotLike(String value) {
            addCriterion("encrypt_password not like", value, "encryptPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptPasswordIn(List<String> values) {
            addCriterion("encrypt_password in", values, "encryptPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptPasswordNotIn(List<String> values) {
            addCriterion("encrypt_password not in", values, "encryptPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptPasswordBetween(String value1, String value2) {
            addCriterion("encrypt_password between", value1, value2, "encryptPassword");
            return (Criteria) this;
        }

        public Criteria andEncryptPasswordNotBetween(String value1, String value2) {
            addCriterion("encrypt_password not between", value1, value2, "encryptPassword");
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