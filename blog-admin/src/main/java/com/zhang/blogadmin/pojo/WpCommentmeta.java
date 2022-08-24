package com.zhang.blogadmin.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
/****
 * @Author:xiaotao
 * @Description:WpCommentmeta构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpCommentmeta",value = "WpCommentmeta")
@Table(name="wp_commentmeta")
public class WpCommentmeta implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meta_id")
	private Long metaId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "comment_id")
	private Long commentId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "meta_key")
	private String metaKey;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "meta_value")
	private String metaValue;//



	//get方法
	public Long getMetaId() {
		return metaId;
	}

	//set方法
	public void setMetaId(Long metaId) {
		this.metaId = metaId;
	}
	//get方法
	public Long getCommentId() {
		return commentId;
	}

	//set方法
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
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
