package com.zhang.blogadmin.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
/****
 * @Author:xiaotao
 * @Description:WpUsermeta构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpUsermeta",value = "WpUsermeta")
@Table(name="wp_usermeta")
public class WpUsermeta implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "umeta_id")
	private Long umetaId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_id")
	private Long userId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "meta_key")
	private String metaKey;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "meta_value")
	private String metaValue;//



	//get方法
	public Long getUmetaId() {
		return umetaId;
	}

	//set方法
	public void setUmetaId(Long umetaId) {
		this.umetaId = umetaId;
	}
	//get方法
	public Long getUserId() {
		return userId;
	}

	//set方法
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	//get方法
	public String getMetaKey() {
		return metaKey;
	}

	//set方法
	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}
	//get方法
	public String getMetaValue() {
		return metaValue;
	}

	//set方法
	public void setMetaValue(String metaValue) {
		this.metaValue = metaValue;
	}


}
