package io.hummerrisk.base.mapper;

import io.hummerrisk.base.domain.Account;
import io.hummerrisk.base.domain.AccountExample;
import io.hummerrisk.base.domain.AccountWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_account
     *
     * @mbg.generated Wed Apr 07 14:51:06 CST 2021
     */
    long countByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_account
     *
     * @mbg.generated Wed Apr 07 14:51:06 CST 2021
     */
    int deleteByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_account
     *
     * @mbg.generated Wed Apr 07 14:51:06 CST 2021
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_account
     *
     * @mbg.generated Wed Apr 07 14:51:06 CST 2021
     */
    int insert(AccountWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_account
     *
     * @mbg.generated Wed Apr 07 14:51:06 CST 2021
     */
    int insertSelective(AccountWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_account
     *
     * @mbg.generated Wed Apr 07 14:51:06 CST 2021
     */
    List<AccountWithBLOBs> selectByExampleWithBLOBs(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_account
     *
     * @mbg.generated Wed Apr 07 14:51:06 CST 2021
     */
    List<Account> selectByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_account
     *
     * @mbg.generated Wed Apr 07 14:51:06 CST 2021
     */
    AccountWithBLOBs selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_account
     *
     * @mbg.generated Wed Apr 07 14:51:06 CST 2021
     */
    int updateByExampleSelective(@Param("record") AccountWithBLOBs record, @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_account
     *
     * @mbg.generated Wed Apr 07 14:51:06 CST 2021
     */
    int updateByExampleWithBLOBs(@Param("record") AccountWithBLOBs record, @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_account
     *
     * @mbg.generated Wed Apr 07 14:51:06 CST 2021
     */
    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_account
     *
     * @mbg.generated Wed Apr 07 14:51:06 CST 2021
     */
    int updateByPrimaryKeySelective(AccountWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_account
     *
     * @mbg.generated Wed Apr 07 14:51:06 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(AccountWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_account
     *
     * @mbg.generated Wed Apr 07 14:51:06 CST 2021
     */
    int updateByPrimaryKey(Account record);
}
