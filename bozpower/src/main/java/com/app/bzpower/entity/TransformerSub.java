package com.app.bzpower.entity;
/**
 * 变电站
 * @author 123
 *
 */
public class TransformerSub {
	
	private Integer id;
	private String transformerSubName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTransformerSubName() {
		return transformerSubName;
	}
	public void setTransformerSubName(String transformerSubName) {
		this.transformerSubName = transformerSubName;
	}

	@Override
	public String toString() {
		return "TransformerSub [id=" + id + ", transformerSubName=" + transformerSubName + "]";
	}
	
	

}
