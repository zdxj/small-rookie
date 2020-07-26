package com.zdxj.model;

import com.zdxj.core.entity.BaseEntity;

public class ImageEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	
	/* 名称 */
	private String name;
	
	/* 简介 */
	private String note;

	/* 图片路径 */
	private String path;
	
	/* 视频路径 */
	private String video;

	/* 分类ID */
	private Integer categoryId;

	/* 作者*/
	private String author;
	
	/* 头像路径*/
	private String headImage;
	
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
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setPath(String path){
		this.path =path;
	}
	public String getPath(){
		return this.path;
	}
	
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public void setCategoryId(Integer categoryId){
		this.categoryId =categoryId;
	}
	public Integer getCategoryId(){
		return this.categoryId;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
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
