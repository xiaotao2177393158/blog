package com.zhang.blogadmin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
/****
 * @Author:xiaotao
 * @Description:WpRoles构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpRoles",value = "WpRoles")
@Table(name="wp_roles")
public class WpRoles implements Serializable{

	@ApiModelProperty(value = "编号",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long ID;//编号

	@ApiModelProperty(value = "角色名称",required = false)
    @Column(name = "ROLE_NAME")
	private String ROLENAME;//角色名称

	@ApiModelProperty(value = "角色描述",required = false)
    @Column(name = "ROLE_DESC")
	private String ROLEDESC;//角色描述



	//get方法
	public Long getID() {
		return ID;
	}

	//set方法
	public void setID(Long ID) {
		this.ID = ID;
	}
	//get方法
	public String getROLENAME() {
		return ROLENAME;
	}

	//set方法
	public void setROLENAME(String ROLENAME) {
		this.ROLENAME = ROLENAME;
	}
	//get方法
	public String getROLEDESC() {
		return ROLEDESC;
	}

	//set方法
	public void setROLEDESC(String ROLEDESC) {
		this.ROLEDESC = ROLEDESC;
	}


}
