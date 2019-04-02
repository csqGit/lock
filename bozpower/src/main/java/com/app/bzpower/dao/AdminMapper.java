package com.app.bzpower.dao;

import com.app.bzpower.entity.Admin;
import com.app.bzpower.entity.AdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbg.generated  Mon Apr 01 14:12:44 CST 2019
	 */
	long countByExample(AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbg.generated  Mon Apr 01 14:12:44 CST 2019
	 */
	int deleteByExample(AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbg.generated  Mon Apr 01 14:12:44 CST 2019
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbg.generated  Mon Apr 01 14:12:44 CST 2019
	 */
	int insert(Admin record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbg.generated  Mon Apr 01 14:12:44 CST 2019
	 */
	int insertSelective(Admin record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbg.generated  Mon Apr 01 14:12:44 CST 2019
	 */
	List<Admin> selectByExample(AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbg.generated  Mon Apr 01 14:12:44 CST 2019
	 */
	Admin selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbg.generated  Mon Apr 01 14:12:44 CST 2019
	 */
	int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbg.generated  Mon Apr 01 14:12:44 CST 2019
	 */
	int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbg.generated  Mon Apr 01 14:12:44 CST 2019
	 */
	int updateByPrimaryKeySelective(Admin record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table admin
	 * @mbg.generated  Mon Apr 01 14:12:44 CST 2019
	 */
	int updateByPrimaryKey(Admin record);
}