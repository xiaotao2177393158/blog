package com.zhang.blogadmin.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
/****
 * @Author:xiaotao
 * @Description:WpTermTaxonomy构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpTermTaxonomy",value = "WpTermTaxonomy")
@Table(name="wp_term_taxonomy")
public class WpTermTaxonomy implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "term_taxonomy_id")
	private Long termTaxonomyId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "term_id")
	private Long termId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "taxonomy")
	private String taxonomy;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "description")
	private String description;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "parent")
	private Long parent;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "count")
	private Long count;//



	//get方法
	public Long getTermTaxonomyId() {
		return termTaxonomyId;
	}

	//set方法
	public void setTermTaxonomyId(Long termTaxonomyId) {
		this.termTaxonomyId = termTaxonomyId;
	}
	//get方法
	public Long getTermId() {
		return termId;
	}

	//set方法
	public void setTermId(Long termId) {
		this.termId = termId;
	}
	//get方法
	public String getTaxonomy() {
		return taxonomy;
	}

	//set方法
	public void setTaxonomy(String taxonomy) {
		this.taxonomy = taxonomy;
	}
	//get方法
	public String getDescription() {
		return description;
	}

	//set方法
	public void setDescription(String description) {
		this.description = description;
	}
	//get方法
	public Long getParent() {
		return parent;
	}

	//set方法
	public void setParent(Long parent) {
		this.parent = parent;
	}
	//get方法
	public Long getCount() {
		return count;
	}

	//set方法
	public void setCount(Long count) {
		this.count = count;
	}


}
