package com.zhang.blogadmin.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
/****
 * @Author:xiaotao
 * @Description:WpSakura构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpSakura",value = "WpSakura")
@Table(name="wp_sakura")
public class WpSakura implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @Column(name = "mate_key")
	private String mateKey;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "mate_value")
	private String mateValue;//



	//get方法
	public String getMateKey() {
		return mateKey;
	}

	//set方法
	public void setMateKey(String mateKey) {
		this.mateKey = mateKey;
	}
	//get方法
	public String getMateValue() {
		return mateValue;
	}

	//set方法
	public void setMateValue(String mateValue) {
		this.mateValue = mateValue;
	}


}
