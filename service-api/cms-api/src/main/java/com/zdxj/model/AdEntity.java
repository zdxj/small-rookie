package com.zdxj.model;

import com.zdxj.core.entity.BaseEntity;

public class AdEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	
	/* 广告标题 */
	private String title;

	/* 图片路径 */
	private String path;

	/* 广告位置编码 */
	private String adPosition;

	/* 位置排序 */
	private Integer position;

	public void setTitle(String title){
		this.title =title;
	}
	public String getTitle(){
		return this.title;
	}
	
	public void setPath(String path){
		this.path =path;
	}
	public String getPath(){
		return this.path;
	}
	
	public void setAdPosition(String adPosition){
		this.adPosition =adPosition;
	}
	public String getAdPosition(){
		return this.adPosition;
	}
	
	public void setPosition(Integer position){
		this.position =position;
	}
	public Integer getPosition(){
		return this.position;
	}
	
	
}
