package com.zdxj.model;

import com.zdxj.core.entity.BaseEntity;

public class ImageCategoryEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	/* 分类名称 */
	private String name;
	
	/* 简介*/
	private String note;
	
	/* 图片路径*/
	private String path;
	
	/* 位置排序 */
	private Integer position;

	public void setName(String name){
		this.name =name;
	}
	public String getName(){
		return this.name;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setPosition(Integer position){
		this.position =position;
	}
	public Integer getPosition(){
		return this.position;
	}
	
	
}
