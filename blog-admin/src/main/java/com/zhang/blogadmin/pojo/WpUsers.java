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
 * @Description:WpUsers构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "WpUsers",value = "WpUsers")
@Table(name="wp_users")
public class WpUsers implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long ID;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_login")
	private String userLogin;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_pass")
	private String userPass;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_nicename")
	private String userNicename;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_email")
	private String userEmail;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_url")
	private String userUrl;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_registered")
	private Date userRegistered;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_activation_key")
	private String userActivationKey;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_status")
	private Integer userStatus;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "display_name")
	private String displayName;//



	//get方法
	public Long getID() {
		return ID;
	}

	//set方法
	public void setID(Long ID) {
		this.ID = ID;
	}
	//get方法
	public String getUserLogin() {
		return userLogin;
	}

	//set方法
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	//get方法
	public String getUserPass() {
		return userPass;
	}

	//set方法
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	//get方法
	public String getUserNicename() {
		return userNicename;
	}

	//set方法
	public void setUserNicename(String userNicename) {
		this.userNicename = userNicename;
	}
	//get方法
	public String getUserEmail() {
		return userEmail;
	}

	//set方法
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	//get方法
	public String getUserUrl() {
		return userUrl;
	}

	//set方法
	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}
	//get方法
	public Date getUserRegistered() {
		return userRegistered;
	}

	//set方法
	public void setUserRegistered(Date userRegistered) {
		this.userRegistered = userRegistered;
	}
	//get方法
	public String getUserActivationKey() {
		return userActivationKey;
	}

	//set方法
	public void setUserActivationKey(String userActivationKey) {
		this.userActivationKey = userActivationKey;
	}
	//get方法
	public Integer getUserStatus() {
		return userStatus;
	}

	//set方法
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	//get方法
	public String getDisplayName() {
		return displayName;
	}

	//set方法
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


}
