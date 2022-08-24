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
 * @Description:WpComments构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpComments",value = "WpComments")
@Table(name="wp_comments")
public class WpComments implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_ID")
	private Long commentID;//

	@ApiModelProperty(value = "文章ID",required = false)
    @Column(name = "comment_post_ID")
	private Long commentPostID;//文章ID

	@ApiModelProperty(value = "评论用户",required = false)
    @Column(name = "comment_author")
	private String commentAuthor;//评论用户

	@ApiModelProperty(value = "评论邮箱",required = false)
    @Column(name = "comment_author_email")
	private String commentAuthorEmail;//评论邮箱

	@ApiModelProperty(value = "评论url",required = false)
    @Column(name = "comment_author_url")
	private String commentAuthorUrl;//评论url

	@ApiModelProperty(value = "评论ip",required = false)
    @Column(name = "comment_author_IP")
	private String commentAuthorIP;//评论ip

	@ApiModelProperty(value = "评论时间",required = false)
    @Column(name = "comment_date")
	private Date commentDate;//评论时间

	@ApiModelProperty(value = "评论格林尼治时间",required = false)
    @Column(name = "comment_date_gmt")
	private Date commentDateGmt;//评论格林尼治时间

	@ApiModelProperty(value = "评论内容",required = false)
    @Column(name = "comment_content")
	private String commentContent;//评论内容

	@ApiModelProperty(value = "评论",required = false)
    @Column(name = "comment_karma")
	private Integer commentKarma;//评论

	@ApiModelProperty(value = "评论核准",required = false)
    @Column(name = "comment_approved")
	private String commentApproved;//评论核准

	@ApiModelProperty(value = "评论设备",required = false)
    @Column(name = "comment_agent")
	private String commentAgent;//评论设备

	@ApiModelProperty(value = "评论类型",required = false)
    @Column(name = "comment_type")
	private String commentType;//评论类型

	@ApiModelProperty(value = "评论",required = false)
    @Column(name = "comment_parent")
	private Long commentParent;//评论

	@ApiModelProperty(value = "评论",required = false)
    @Column(name = "user_id")
	private Long userId;//评论

	@ApiModelProperty(value = "评论markdown",required = false)
    @Column(name = "comment_markdown")
	private String commentMarkdown;//评论markdown



	//get方法
	public Long getCommentID() {
		return commentID;
	}

	//set方法
	public void setCommentID(Long commentID) {
		this.commentID = commentID;
	}
	//get方法
	public Long getCommentPostID() {
		return commentPostID;
	}

	//set方法
	public void setCommentPostID(Long commentPostID) {
		this.commentPostID = commentPostID;
	}
	//get方法
	public String getCommentAuthor() {
		return commentAuthor;
	}

	//set方法
	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}
	//get方法
	public String getCommentAuthorEmail() {
		return commentAuthorEmail;
	}

	//set方法
	public void setCommentAuthorEmail(String commentAuthorEmail) {
		this.commentAuthorEmail = commentAuthorEmail;
	}
	//get方法
	public String getCommentAuthorUrl() {
		return commentAuthorUrl;
	}

	//set方法
	public void setCommentAuthorUrl(String commentAuthorUrl) {
		this.commentAuthorUrl = commentAuthorUrl;
	}
	//get方法
	public String getCommentAuthorIP() {
		return commentAuthorIP;
	}

	//set方法
	public void setCommentAuthorIP(String commentAuthorIP) {
		this.commentAuthorIP = commentAuthorIP;
	}
	//get方法
	public Date getCommentDate() {
		return commentDate;
	}

	//set方法
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	//get方法
	public Date getCommentDateGmt() {
		return commentDateGmt;
	}

	//set方法
	public void setCommentDateGmt(Date commentDateGmt) {
		this.commentDateGmt = commentDateGmt;
	}
	//get方法
	public String getCommentContent() {
		return commentContent;
	}

	//set方法
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	//get方法
	public Integer getCommentKarma() {
		return commentKarma;
	}

	//set方法
	public void setCommentKarma(Integer commentKarma) {
		this.commentKarma = commentKarma;
	}
	//get方法
	public String getCommentApproved() {
		return commentApproved;
	}

	//set方法
	public void setCommentApproved(String commentApproved) {
		this.commentApproved = commentApproved;
	}
	//get方法
	public String getCommentAgent() {
		return commentAgent;
	}

	//set方法
	public void setCommentAgent(String commentAgent) {
		this.commentAgent = commentAgent;
	}
	//get方法
	public String getCommentType() {
		return commentType;
	}

	//set方法
	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}
	//get方法
	public Long getCommentParent() {
		return commentParent;
	}

	//set方法
	public void setCommentParent(Long commentParent) {
		this.commentParent = commentParent;
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
	public String getCommentMarkdown() {
		return commentMarkdown;
	}

	//set方法
	public void setCommentMarkdown(String commentMarkdown) {
		this.commentMarkdown = commentMarkdown;
	}


}
