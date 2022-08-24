package com.zhang.blogadmin.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
/****
 * @Author:xiaotao
 * @Description:WpOptions构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpOptions",value = "WpOptions")
@Table(name="wp_options")
public class WpOptions implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
	private Long optionId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "option_name")
	private String optionName;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "option_value")
	private String optionValue;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "autoload")
	private String autoload;//



	//get方法
	public Long getOptionId() {
		return optionId;
	}

	//set方法
	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}
	//get方法
	public String getOptionName() {
		return optionName;
	}

	//set方法
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	//get方法
	public String getOptionValue() {
		return optionValue;
	}

	//set方法
	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}
	//get方法
	public String getAutoload() {
		return autoload;
	}

	//set方法
	public void setAutoload(String autoload) {
		this.autoload = autoload;
	}


}
