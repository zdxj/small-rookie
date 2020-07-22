package com.zdxj.model;

import com.zdxj.core.entity.BaseEntity;

public class SystemMenuEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	/* 菜单名称 */
	private String menuName;

	/* 权限编码 */
	private String permCode;

	/* 菜单类型,0:菜单，1:按钮 */
	private Integer permType;

	/* 父ID */
	private Integer parentId;

	/* 菜单路径 */
	private String url;

	/* 权限路径 */
	private String permUrl;

	/* 位置排序 */
	private Integer position;

	public void setMenuName(String menuName){
		this.menuName =menuName;
	}
	public String getMenuName(){
		return this.menuName;
	}
	
	public void setPermCode(String permCode){
		this.permCode =permCode;
	}
	public String getPermCode(){
		return this.permCode;
	}
	
	public void setPermType(Integer permType){
		this.permType =permType;
	}
	public Integer getPermType(){
		return this.permType;
	}
	
	public void setParentId(Integer parentId){
		this.parentId =parentId;
	}
	public Integer getParentId(){
		return this.parentId;
	}
	
	public void setUrl(String url){
		this.url =url;
	}
	public String getUrl(){
		return this.url;
	}
	
	public void setPermUrl(String permUrl){
		this.permUrl =permUrl;
	}
	public String getPermUrl(){
		return this.permUrl;
	}
	
	public void setPosition(Integer position){
		this.position =position;
	}
	public Integer getPosition(){
		return this.position;
	}
	
	
}
