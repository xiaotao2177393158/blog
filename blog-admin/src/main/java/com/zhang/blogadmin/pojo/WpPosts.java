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
 * @Description:WpPosts构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpPosts",value = "WpPosts")
@Table(name="wp_posts")
public class WpPosts implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long ID;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_author")
	private Long postAuthor;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_date")
	private Date postDate;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_date_gmt")
	private Date postDateGmt;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_content")
	private String postContent;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_title")
	private String postTitle;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_excerpt")
	private String postExcerpt;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_status")
	private String postStatus;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "comment_status")
	private String commentStatus;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "ping_status")
	private String pingStatus;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_password")
	private String postPassword;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_name")
	private String postName;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "to_ping")
	private String toPing;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "pinged")
	private String pinged;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_modified")
	private Date postModified;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_modified_gmt")
	private Date postModifiedGmt;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_content_filtered")
	private String postContentFiltered;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_parent")
	private Long postParent;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "guid")
	private String guid;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "menu_order")
	private Integer menuOrder;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_type")
	private String postType;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "post_mime_type")
	private String postMimeType;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "comment_count")
	private Long commentCount;//



	//get方法
	public Long getID() {
		return ID;
	}

	//set方法
	public void setID(Long ID) {
		this.ID = ID;
	}
	//get方法
	public Long getPostAuthor() {
		return postAuthor;
	}

	//set方法
	public void setPostAuthor(Long postAuthor) {
		this.postAuthor = postAuthor;
	}
	//get方法
	public Date getPostDate() {
		return postDate;
	}

	//set方法
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	//get方法
	public Date getPostDateGmt() {
		return postDateGmt;
	}

	//set方法
	public void setPostDateGmt(Date postDateGmt) {
		this.postDateGmt = postDateGmt;
	}
	//get方法
	public String getPostContent() {
		return postContent;
	}

	//set方法
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	//get方法
	public String getPostTitle() {
		return postTitle;
	}

	//set方法
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	//get方法
	public String getPostExcerpt() {
		return postExcerpt;
	}

	//set方法
	public void setPostExcerpt(String postExcerpt) {
		this.postExcerpt = postExcerpt;
	}
	//get方法
	public String getPostStatus() {
		return postStatus;
	}

	//set方法
	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}
	//get方法
	public String getCommentStatus() {
		return commentStatus;
	}

	//set方法
	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}
	//get方法
	public String getPingStatus() {
		return pingStatus;
	}

	//set方法
	public void setPingStatus(String pingStatus) {
		this.pingStatus = pingStatus;
	}
	//get方法
	public String getPostPassword() {
		return postPassword;
	}

	//set方法
	public void setPostPassword(String postPassword) {
		this.postPassword = postPassword;
	}
	//get方法
	public String getPostName() {
		return postName;
	}

	//set方法
	public void setPostName(String postName) {
		this.postName = postName;
	}
	//get方法
	public String getToPing() {
		return toPing;
	}

	//set方法
	public void setToPing(String toPing) {
		this.toPing = toPing;
	}
	//get方法
	public String getPinged() {
		return pinged;
	}

	//set方法
	public void setPinged(String pinged) {
		this.pinged = pinged;
	}
	//get方法
	public Date getPostModified() {
		return postModified;
	}

	//set方法
	public void setPostModified(Date postModified) {
		this.postModified = postModified;
	}
	//get方法
	public Date getPostModifiedGmt() {
		return postModifiedGmt;
	}

	//set方法
	public void setPostModifiedGmt(Date postModifiedGmt) {
		this.postModifiedGmt = postModifiedGmt;
	}
	//get方法
	public String getPostContentFiltered() {
		return postContentFiltered;
	}

	//set方法
	public void setPostContentFiltered(String postContentFiltered) {
		this.postContentFiltered = postContentFiltered;
	}
	//get方法
	public Long getPostParent() {
		return postParent;
	}

	//set方法
	public void setPostParent(Long postParent) {
		this.postParent = postParent;
	}
	//get方法
	public String getGuid() {
		return guid;
	}

	//set方法
	public void setGuid(String guid) {
		this.guid = guid;
	}
	//get方法
	public Integer getMenuOrder() {
		return menuOrder;
	}

	//set方法
	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}
	//get方法
	public String getPostType() {
		return postType;
	}

	//set方法
	public void setPostType(String postType) {
		this.postType = postType;
	}
	//get方法
	public String getPostMimeType() {
		return postMimeType;
	}

	//set方法
	public void setPostMimeType(String postMimeType) {
		this.postMimeType = postMimeType;
	}
	//get方法
	public Long getCommentCount() {
		return commentCount;
	}

	//set方法
	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}


}
