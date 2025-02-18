package io.hummerrisk.base.domain;

import java.io.Serializable;

public class RuleTagMapping implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_tag_mapping.id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_tag_mapping.rule_id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    private String ruleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rule_tag_mapping.tag_key
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    private String tagKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table rule_tag_mapping
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_tag_mapping.id
     *
     * @return the value of rule_tag_mapping.id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_tag_mapping.id
     *
     * @param id the value for rule_tag_mapping.id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_tag_mapping.rule_id
     *
     * @return the value of rule_tag_mapping.rule_id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public String getRuleId() {
        return ruleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_tag_mapping.rule_id
     *
     * @param ruleId the value for rule_tag_mapping.rule_id
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rule_tag_mapping.tag_key
     *
     * @return the value of rule_tag_mapping.tag_key
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public String getTagKey() {
        return tagKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rule_tag_mapping.tag_key
     *
     * @param tagKey the value for rule_tag_mapping.tag_key
     *
     * @mbg.generated Tue Jan 19 17:40:09 CST 2021
     */
    public void setTagKey(String tagKey) {
        this.tagKey = tagKey == null ? null : tagKey.trim();
    }
}
