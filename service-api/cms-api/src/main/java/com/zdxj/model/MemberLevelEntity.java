package com.zdxj.model;

import com.zdxj.core.entity.BaseEntity;

public class MemberLevelEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	
	/* 名称 */
	private String name;

	/* 等级图标 */
	private String icon;

	/* 开始积分 */
	private Integer pointsStart;

	/* 结束积分 */
	private Integer pointsEnd;

	/* 位置排序 */
	private Integer position;

	public void setName(String name){
		this.name =name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setIcon(String icon){
		this.icon =icon;
	}
	public String getIcon(){
		return this.icon;
	}
	
	public void setPointsStart(Integer pointsStart){
		this.pointsStart =pointsStart;
	}
	public Integer getPointsStart(){
		return this.pointsStart;
	}
	
	public void setPointsEnd(Integer pointsEnd){
		this.pointsEnd =pointsEnd;
	}
	public Integer getPointsEnd(){
		return this.pointsEnd;
	}
	
	public void setPosition(Integer position){
		this.position =position;
	}
	public Integer getPosition(){
		return this.position;
	}
	
	
}
