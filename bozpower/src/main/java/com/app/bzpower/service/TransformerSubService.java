package com.app.bzpower.service;

import java.util.List;

import com.app.bzpower.entity.TransformerSub;

public interface TransformerSubService {

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
	public TransformerSub selectTransfromerSubById(Integer id);
	
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
	public void deleteTransformerSubById(Integer id);
}
