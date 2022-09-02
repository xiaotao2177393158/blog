package com.zhang.blogadmin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
/****
 * @Author:xiaotao
 * @Description:WpPermissionRequestPath构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpPermissionRequestPath",value = "WpPermissionRequestPath")
@Table(name="wp_permission_request_path")
public class WpPermissionRequestPath implements Serializable{

	@ApiModelProperty(value = "编号",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long ID;//编号

	@ApiModelProperty(value = "",required = false)
    @Column(name = "PID")
	private Long PID;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "URL_ID")
	private Long URLID;//



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
	public Long getURLID() {
		return URLID;
	}

	//set方法
	public void setURLID(Long URLID) {
		this.URLID = URLID;
	}


}
