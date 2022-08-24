package com.zhang.blogadmin.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Long;
import java.lang.Integer;
/****
 * @Author:xiaotao
 * @Description:WpTermRelationships构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpTermRelationships",value = "WpTermRelationships")
@Table(name="wp_term_relationships")
public class WpTermRelationships implements Serializable{

	@ApiModelProperty(value = "",required = false)
    @Column(name = "object_id")
	private Long objectId;//

	@ApiModelProperty(value = "",required = false)
	@Id
    @Column(name = "term_taxonomy_id")
	private Long termTaxonomyId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "term_order")
	private Integer termOrder;//



	//get方法
	public Long getObjectId() {
		return objectId;
	}

	//set方法
	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	//get方法
	public Long getTermTaxonomyId() {
		return termTaxonomyId;
	}

	//set方法
	public void setTermTaxonomyId(Long termTaxonomyId) {
		this.termTaxonomyId = termTaxonomyId;
	}
	//get方法
	public Integer getTermOrder() {
		return termOrder;
	}

	//set方法
	public void setTermOrder(Integer termOrder) {
		this.termOrder = termOrder;
	}


}
