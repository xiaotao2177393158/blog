package com.zhang.blogadmin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
/****
 * @Author:xiaotao
 * @Description:WpPermissionRole构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpPermissionRole",value = "WpPermissionRole")
@Table(name="wp_permission_role")
public class WpPermissionRole implements Serializable{

	@ApiModelProperty(value = "编号",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long ID;//编号

	@ApiModelProperty(value = "",required = false)
    @Column(name = "PID")
	private Long PID;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "RID")
	private Long RID;//



	//get方法
	public Long getID() {
		return ID;
	}

	//set方法
	public void setID(Long ID) {
		this.ID = ID;
	}
	//get方法
	public Long getPID() {
		return PID;
	}

	//set方法
	public void setPID(Long PID) {
		this.PID = PID;
	}
	//get方法
	public Long getRID() {
		return RID;
	}

	//set方法
	public void setRID(Long RID) {
		this.RID = RID;
	}


}
