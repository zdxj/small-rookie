package com.zdxj.model;

import com.zdxj.core.entity.BaseEntity;

public class ImageCommentEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	
	/* 图片ID */
	private Integer imageId;

	/* 会员ID */
	private Integer memberId;

	/* 评论信息 */
	private String comment;

	/* 点赞数量 */
	private Integer supportCount;

	public void setImageId(Integer imageId){
		this.imageId =imageId;
	}
	public Integer getImageId(){
		return this.imageId;
	}
	
	public void setMemberId(Integer memberId){
		this.memberId =memberId;
	}
	public Integer getMemberId(){
		return this.memberId;
	}
	
	public void setComment(String comment){
		this.comment =comment;
	}
	public String getComment(){
		return this.comment;
	}
	
	public void setSupportCount(Integer supportCount){
		this.supportCount =supportCount;
	}
	public Integer getSupportCount(){
		return this.supportCount;
	}
	
	
}
