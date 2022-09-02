package com.zhang.blogadmin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
/****
 * @Author:xiaotao
 * @Description:WpUserRole构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpUserRole",value = "WpUserRole")
@Table(name="wp_user_role")
public class WpUserRole implements Serializable{

	@ApiModelProperty(value = "编号",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long ID;//编号

	@ApiModelProperty(value = "",required = false)
    @Column(name = "UID")
	private Long UID;//

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
	public Long getUID() {
		return UID;
	}

	//set方法
	public void setUID(Long UID) {
		this.UID = UID;
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
