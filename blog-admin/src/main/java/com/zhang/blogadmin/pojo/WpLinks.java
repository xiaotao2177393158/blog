package com.zhang.blogadmin.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:xiaotao
 * @Description:WpLinks构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpLinks",value = "WpLinks")
@Table(name="wp_links")
public class WpLinks implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id")
	private Long linkId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "link_url")
	private String linkUrl;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "link_name")
	private String linkName;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "link_image")
	private String linkImage;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "link_target")
	private String linkTarget;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "link_description")
	private String linkDescription;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "link_visible")
	private String linkVisible;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "link_owner")
	private Long linkOwner;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "link_rating")
	private Integer linkRating;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "link_updated")
	private Date linkUpdated;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "link_rel")
	private String linkRel;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "link_notes")
	private String linkNotes;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "link_rss")
	private String linkRss;//



	//get方法
	public Long getLinkId() {
		return linkId;
	}

	//set方法
	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}
	//get方法
	public String getLinkUrl() {
		return linkUrl;
	}

	//set方法
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	//get方法
	public String getLinkName() {
		return linkName;
	}

	//set方法
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	//get方法
	public String getLinkImage() {
		return linkImage;
	}

	//set方法
	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}
	//get方法
	public String getLinkTarget() {
		return linkTarget;
	}

	//set方法
	public void setLinkTarget(String linkTarget) {
		this.linkTarget = linkTarget;
	}
	//get方法
	public String getLinkDescription() {
		return linkDescription;
	}

	//set方法
	public void setLinkDescription(String linkDescription) {
		this.linkDescription = linkDescription;
	}
	//get方法
	public String getLinkVisible() {
		return linkVisible;
	}

	//set方法
	public void setLinkVisible(String linkVisible) {
		this.linkVisible = linkVisible;
	}
	//get方法
	public Long getLinkOwner() {
		return linkOwner;
	}

	//set方法
	public void setLinkOwner(Long linkOwner) {
		this.linkOwner = linkOwner;
	}
	//get方法
	public Integer getLinkRating() {
		return linkRating;
	}

	//set方法
	public void setLinkRating(Integer linkRating) {
		this.linkRating = linkRating;
	}
	//get方法
	public Date getLinkUpdated() {
		return linkUpdated;
	}

	//set方法
	public void setLinkUpdated(Date linkUpdated) {
		this.linkUpdated = linkUpdated;
	}
	//get方法
	public String getLinkRel() {
		return linkRel;
	}

	//set方法
	public void setLinkRel(String linkRel) {
		this.linkRel = linkRel;
	}
	//get方法
	public String getLinkNotes() {
		return linkNotes;
	}

	//set方法
	public void setLinkNotes(String linkNotes) {
		this.linkNotes = linkNotes;
	}
	//get方法
	public String getLinkRss() {
		return linkRss;
	}

	//set方法
	public void setLinkRss(String linkRss) {
		this.linkRss = linkRss;
	}


}
