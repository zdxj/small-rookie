package com.zdxj.model;

import com.zdxj.core.entity.BaseEntity;

public class DepartmentEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	/* 部门名称 */
	private String name;

	/* 备注 */
	private String note;

	/* 位置排序 */
	private Integer position;
	
	public void setName(String name){
		this.name =name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setNote(String note){
		this.note =note;
	}
	public String getNote(){
		return this.note;
	}
	
	public void setPosition(Integer position){
		this.position =position;
	}
	public Integer getPosition(){
		return this.position;
	}
	
	
}
