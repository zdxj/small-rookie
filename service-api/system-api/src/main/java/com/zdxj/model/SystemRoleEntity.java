package com.zdxj.model;

import com.zdxj.core.entity.BaseEntity;

public class SystemRoleEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	/* 角色名称 */
	private String name;

	/* 备注 */
	private String note;

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
	
	
}
