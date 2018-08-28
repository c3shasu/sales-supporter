package jp.co.ccube.ss.entity;

import java.util.ArrayList;
import java.util.List;

public class MClassificationExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
    public MClassificationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
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

        public Criteria andClassificationCodeIsNull() {
            addCriterion("classification_code is null");
            return (Criteria) this;
        }

        public Criteria andClassificationCodeIsNotNull() {
            addCriterion("classification_code is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationCodeEqualTo(String value) {
            addCriterion("classification_code =", value, "classificationCode");
            return (Criteria) this;
        }

        public Criteria andClassificationCodeNotEqualTo(String value) {
            addCriterion("classification_code <>", value, "classificationCode");
            return (Criteria) this;
        }

        public Criteria andClassificationCodeGreaterThan(String value) {
            addCriterion("classification_code >", value, "classificationCode");
            return (Criteria) this;
        }

        public Criteria andClassificationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("classification_code >=", value, "classificationCode");
            return (Criteria) this;
        }

        public Criteria andClassificationCodeLessThan(String value) {
            addCriterion("classification_code <", value, "classificationCode");
            return (Criteria) this;
        }

        public Criteria andClassificationCodeLessThanOrEqualTo(String value) {
            addCriterion("classification_code <=", value, "classificationCode");
            return (Criteria) this;
        }

        public Criteria andClassificationCodeLike(String value) {
            addCriterion("classification_code like", value, "classificationCode");
            return (Criteria) this;
        }

        public Criteria andClassificationCodeNotLike(String value) {
            addCriterion("classification_code not like", value, "classificationCode");
            return (Criteria) this;
        }

        public Criteria andClassificationCodeIn(List<String> values) {
            addCriterion("classification_code in", values, "classificationCode");
            return (Criteria) this;
        }

        public Criteria andClassificationCodeNotIn(List<String> values) {
            addCriterion("classification_code not in", values, "classificationCode");
            return (Criteria) this;
        }

        public Criteria andClassificationCodeBetween(String value1, String value2) {
            addCriterion("classification_code between", value1, value2, "classificationCode");
            return (Criteria) this;
        }

        public Criteria andClassificationCodeNotBetween(String value1, String value2) {
            addCriterion("classification_code not between", value1, value2, "classificationCode");
            return (Criteria) this;
        }

        public Criteria andClassificationIdIsNull() {
            addCriterion("classification_id is null");
            return (Criteria) this;
        }

        public Criteria andClassificationIdIsNotNull() {
            addCriterion("classification_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationIdEqualTo(Boolean value) {
            addCriterion("classification_id =", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdNotEqualTo(Boolean value) {
            addCriterion("classification_id <>", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdGreaterThan(Boolean value) {
            addCriterion("classification_id >", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdGreaterThanOrEqualTo(Boolean value) {
            addCriterion("classification_id >=", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdLessThan(Boolean value) {
            addCriterion("classification_id <", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdLessThanOrEqualTo(Boolean value) {
            addCriterion("classification_id <=", value, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdIn(List<Boolean> values) {
            addCriterion("classification_id in", values, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdNotIn(List<Boolean> values) {
            addCriterion("classification_id not in", values, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdBetween(Boolean value1, Boolean value2) {
            addCriterion("classification_id between", value1, value2, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationIdNotBetween(Boolean value1, Boolean value2) {
            addCriterion("classification_id not between", value1, value2, "classificationId");
            return (Criteria) this;
        }

        public Criteria andClassificationNameIsNull() {
            addCriterion("classification_name is null");
            return (Criteria) this;
        }

        public Criteria andClassificationNameIsNotNull() {
            addCriterion("classification_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationNameEqualTo(String value) {
            addCriterion("classification_name =", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameNotEqualTo(String value) {
            addCriterion("classification_name <>", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameGreaterThan(String value) {
            addCriterion("classification_name >", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameGreaterThanOrEqualTo(String value) {
            addCriterion("classification_name >=", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameLessThan(String value) {
            addCriterion("classification_name <", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameLessThanOrEqualTo(String value) {
            addCriterion("classification_name <=", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameLike(String value) {
            addCriterion("classification_name like", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameNotLike(String value) {
            addCriterion("classification_name not like", value, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameIn(List<String> values) {
            addCriterion("classification_name in", values, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameNotIn(List<String> values) {
            addCriterion("classification_name not in", values, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameBetween(String value1, String value2) {
            addCriterion("classification_name between", value1, value2, "classificationName");
            return (Criteria) this;
        }

        public Criteria andClassificationNameNotBetween(String value1, String value2) {
            addCriterion("classification_name not between", value1, value2, "classificationName");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table m_classification
     *
     * @mbggenerated do_not_delete_during_merge Wed Aug 22 16:52:44 JST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table m_classification
     *
     * @mbggenerated Wed Aug 22 16:52:44 JST 2018
     */
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