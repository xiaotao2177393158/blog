package com.zhang.blogadmin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
/****
 * @Author:xiaotao
 * @Description:WpRequestPath构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpRequestPath",value = "WpRequestPath")
@Table(name="wp_request_path")
public class WpRequestPath implements Serializable{

	@ApiModelProperty(value = "编号",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long ID;//编号

	@ApiModelProperty(value = "url",required = false)
    @Column(name = "url")
	private String url;//url

	@ApiModelProperty(value = "描述",required = false)
    @Column(name = "description")
	private String description;//描述



	//get方法
	public Long getID() {
		return ID;
	}

	//set方法
	public void setID(Long ID) {
		this.ID = ID;
	}
	//get方法
	public String getUrl() {
		return url;
	}

	//set方法
	public void setUrl(String url) {
		this.url = url;
	}
	//get方法
	public String getDescription() {
		return description;
	}

	//set方法
	public void setDescription(String description) {
		this.description = description;
	}


}
