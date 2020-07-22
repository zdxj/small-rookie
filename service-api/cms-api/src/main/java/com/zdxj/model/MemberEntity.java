package com.zdxj.model;

import com.zdxj.core.entity.BaseEntity;

public class MemberEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	
	/* 昵称 */
	private String nickName;

	/* 头像 */
	private String headImage;

	/* 会员等级ID */
	private Integer levelId;

	public void setNickName(String nickName){
		this.nickName =nickName;
	}
	public String getNickName(){
		return this.nickName;
	}
	
	public void setHeadImage(String headImage){
		this.headImage =headImage;
	}
	public String getHeadImage(){
		return this.headImage;
	}
	
	public void setLevelId(Integer levelId){
		this.levelId =levelId;
	}
	public Integer getLevelId(){
		return this.levelId;
	}
	
	
}
