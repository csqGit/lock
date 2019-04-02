package com.app.bzpower.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.bzpower.entity.TransformerSub;

/**
 * 变电站dao
 * @author 123
 *
 */
public interface TransformerSubDao {
	
	/**
	 * 查询所有变电站信息
	 * @return
	 */
	public List<TransformerSub> selectTransformerSubList();
	
	
	/**
	 * 根据ID查询变电站信息
	 * @param id
	 * @return
	 */
	public TransformerSub selectTransfromerSubById(@Param("id") Integer id);
	
	/**
	 * 新增变电站
	 * @param transformerSub
	 */
	public void insertTransformerSub(TransformerSub transformerSub);
	
	
	/**
	 * 更新变电站信息
	 * @param transformerSub
	 */
	public void updateTransformerSub(TransformerSub transformerSub);
	
	/**
	 * 删除变电站
	 * @param id
	 */
	public void deleteTransformerSubById(@Param("id")Integer id);

}
