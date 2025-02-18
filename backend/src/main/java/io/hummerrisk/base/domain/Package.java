package io.hummerrisk.base.domain;

import java.io.Serializable;

public class Package implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column package.id
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column package.name
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column package.package_name
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    private String packageName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column package.plugin_icon
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    private String pluginIcon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column package.status
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column package.create_time
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column package.update_time
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    private Long updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column package.creator
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    private String creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column package.size
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    private String size;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column package.path
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    private String path;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table package
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column package.id
     *
     * @return the value of package.id
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column package.id
     *
     * @param id the value for package.id
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column package.name
     *
     * @return the value of package.name
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column package.name
     *
     * @param name the value for package.name
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column package.package_name
     *
     * @return the value of package.package_name
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column package.package_name
     *
     * @param packageName the value for package.package_name
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column package.plugin_icon
     *
     * @return the value of package.plugin_icon
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public String getPluginIcon() {
        return pluginIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column package.plugin_icon
     *
     * @param pluginIcon the value for package.plugin_icon
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public void setPluginIcon(String pluginIcon) {
        this.pluginIcon = pluginIcon == null ? null : pluginIcon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column package.status
     *
     * @return the value of package.status
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column package.status
     *
     * @param status the value for package.status
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column package.create_time
     *
     * @return the value of package.create_time
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column package.create_time
     *
     * @param createTime the value for package.create_time
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column package.update_time
     *
     * @return the value of package.update_time
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column package.update_time
     *
     * @param updateTime the value for package.update_time
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column package.creator
     *
     * @return the value of package.creator
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column package.creator
     *
     * @param creator the value for package.creator
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column package.size
     *
     * @return the value of package.size
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public String getSize() {
        return size;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column package.size
     *
     * @param size the value for package.size
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column package.path
     *
     * @return the value of package.path
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column package.path
     *
     * @param path the value for package.path
     *
     * @mbg.generated Sun Jun 05 18:00:43 CST 2022
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }
}
