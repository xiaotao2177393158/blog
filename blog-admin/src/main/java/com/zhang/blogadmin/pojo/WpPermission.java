package com.zhang.blogadmin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
/****
 * @Author:xiaotao
 * @Description:WpPermission构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpPermission",value = "WpPermission")
@Table(name="wp_permission")
public class WpPermission implements Serializable{

	@ApiModelProperty(value = "编号",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long ID;//编号

	@ApiModelProperty(value = "权限码",required = false)
    @Column(name = "code")
	private String code;//权限码

	@ApiModelProperty(value = "权限名称",required = false)
    @Column(name = "name")
	private String name;//权限名称



	//get方法
	public Long getID() {
		return ID;
	}

	//set方法
	public void setID(Long ID) {
		this.ID = ID;
	}
	//get方法
	public String getCode() {
		return code;
	}

	//set方法
	public void setCode(String code) {
		this.code = code;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
	}


}
