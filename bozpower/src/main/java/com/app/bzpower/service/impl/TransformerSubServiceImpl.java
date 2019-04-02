package com.app.bzpower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bzpower.dao.TransformerSubDao;
import com.app.bzpower.entity.TransformerSub;
import com.app.bzpower.service.TransformerSubService;

@Service
public class TransformerSubServiceImpl implements TransformerSubService{

	@Autowired
	private TransformerSubDao TransformerSubDao;
	
	public List<TransformerSub> selectTransformerSubList() {
		// TODO Auto-generated method stub
		return TransformerSubDao.selectTransformerSubList();
	}

	public TransformerSub selectTransfromerSubById(Integer id) {
		// TODO Auto-generated method stub
		return TransformerSubDao.selectTransfromerSubById(id);
	}

	public void insertTransformerSub(TransformerSub transformerSub) {
		// TODO Auto-generated method stub
		TransformerSubDao.insertTransformerSub(transformerSub);
	}

	public void updateTransformerSub(TransformerSub transformerSub) {
		// TODO Auto-generated method stub
		TransformerSubDao.updateTransformerSub(transformerSub);
	}

	public void deleteTransformerSubById(Integer id) {
		// TODO Auto-generated method stub
		TransformerSubDao.deleteTransformerSubById(id);
	}

}
