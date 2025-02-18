package io.hummerrisk.base.domain;

import java.io.Serializable;

public class RuleAccountParameter implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_account_parameter.id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_account_parameter.account_id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    private String accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_account_parameter.rule_id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    private String ruleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_account_parameter.parameter
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    private String parameter;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_account_parameter.regions
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    private String regions;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table rule_account_parameter
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_account_parameter.id
     *
     * @return the value of rule_account_parameter.id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_account_parameter.id
     *
     * @param id the value for rule_account_parameter.id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_account_parameter.account_id
     *
     * @return the value of rule_account_parameter.account_id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_account_parameter.account_id
     *
     * @param accountId the value for rule_account_parameter.account_id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_account_parameter.rule_id
     *
     * @return the value of rule_account_parameter.rule_id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public String getRuleId() {
        return ruleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_account_parameter.rule_id
     *
     * @param ruleId the value for rule_account_parameter.rule_id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_account_parameter.parameter
     *
     * @return the value of rule_account_parameter.parameter
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_account_parameter.parameter
     *
     * @param parameter the value for rule_account_parameter.parameter
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_account_parameter.regions
     *
     * @return the value of rule_account_parameter.regions
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public String getRegions() {
        return regions;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_account_parameter.regions
     *
     * @param regions the value for rule_account_parameter.regions
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public void setRegions(String regions) {
        this.regions = regions == null ? null : regions.trim();
    }
}
