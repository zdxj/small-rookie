package com.zdxj.model;

import com.zdxj.core.entity.BaseEntity;

public class ImageEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	
	/* 名称 */
	private String name;

	/* 图片路径 */
	private String path;

	/* 分类ID */
	private Integer categoryId;

	/* 点赞数量 */
	private Integer supportCount;

	/* 位置排序 */
	private Integer position;

	public void setName(String name){
		this.name =name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setPath(String path){
		this.path =path;
	}
	public String getPath(){
		return this.path;
	}
	
	public void setCategoryId(Integer categoryId){
		this.categoryId =categoryId;
	}
	public Integer getCategoryId(){
		return this.categoryId;
	}
	
	public void setSupportCount(Integer supportCount){
		this.supportCount =supportCount;
	}
	public Integer getSupportCount(){
		return this.supportCount;
	}
	
	public void setPosition(Integer position){
		this.position =position;
	}
	public Integer getPosition(){
		return this.position;
	}
	
	
}
