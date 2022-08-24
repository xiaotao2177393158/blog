package com.zhang.blogadmin.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
/****
 * @Author:xiaotao
 * @Description:WpTerms构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpTerms",value = "WpTerms")
@Table(name="wp_terms")
public class WpTerms implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "term_id")
	private Long termId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "name")
	private String name;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "slug")
	private String slug;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "term_group")
	private Long termGroup;//



	//get方法
	public Long getTermId() {
		return termId;
	}

	//set方法
	public void setTermId(Long termId) {
		this.termId = termId;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
	}
	//get方法
	public String getSlug() {
		return slug;
	}

	//set方法
	public void setSlug(String slug) {
		this.slug = slug;
	}
	//get方法
	public Long getTermGroup() {
		return termGroup;
	}

	//set方法
	public void setTermGroup(Long termGroup) {
		this.termGroup = termGroup;
	}


}
