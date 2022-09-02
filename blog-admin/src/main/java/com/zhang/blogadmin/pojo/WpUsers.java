package com.zhang.blogadmin.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.javassist.runtime.Inner;

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
    @Column(name = "username")
	private String username;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "password")
	private String password;//

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

	@ApiModelProperty(value = "账号是否可用。默认为1（可用）",required = false)
	@Column(name = "enabled")
	private Boolean enabled;//

	@ApiModelProperty(value = "是否过期。默认为1（没有过期）",required = false)
	@Column(name = "not_expired")
	private Boolean notExpired;//

	@ApiModelProperty(value = "账号是否锁定。默认为1（没有锁定）",required = false)
	@Column(name = "account_not_locked")
	private Boolean accountNotLocked;//

	@ApiModelProperty(value = "证书（密码）是否过期。默认为1（没有过期）",required = false)
	@Column(name = "credentials_not_expired")
	private Boolean credentialsNotExpired;//

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserNicename() {
		return userNicename;
	}

	public void setUserNicename(String userNicename) {
		this.userNicename = userNicename;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserUrl() {
		return userUrl;
	}

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

	public Date getUserRegistered() {
		return userRegistered;
	}

	public void setUserRegistered(Date userRegistered) {
		this.userRegistered = userRegistered;
	}

	public String getUserActivationKey() {
		return userActivationKey;
	}

	public void setUserActivationKey(String userActivationKey) {
		this.userActivationKey = userActivationKey;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getNotExpired() {
		return notExpired;
	}

	public void setNotExpired(Boolean notExpired) {
		this.notExpired = notExpired;
	}

	public Boolean getAccountNotLocked() {
		return accountNotLocked;
	}

	public void setAccountNotLocked(Boolean accountNotLocked) {
		this.accountNotLocked = accountNotLocked;
	}

	public Boolean getCredentialsNotExpired() {
		return credentialsNotExpired;
	}

	public void setCredentialsNotExpired(Boolean credentialsNotExpired) {
		this.credentialsNotExpired = credentialsNotExpired;
	}

	public WpUsers() {
	}

	public WpUsers(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public WpUsers(Long ID, String username, String password, String userNicename, String userEmail, String userUrl, Date userRegistered, String userActivationKey, Integer userStatus, String displayName) {
		this.ID = ID;
		this.username = username;
		this.password = password;
		this.userNicename = userNicename;
		this.userEmail = userEmail;
		this.userUrl = userUrl;
		this.userRegistered = userRegistered;
		this.userActivationKey = userActivationKey;
		this.userStatus = userStatus;
		this.displayName = displayName;
	}


	public WpUsers(Long ID, String username, String password, String userNicename, String userEmail, String userUrl, Date userRegistered, String userActivationKey, Integer userStatus, String displayName, Boolean enabled, Boolean notExpired, Boolean accountNotLocked, Boolean credentialsNotExpired) {
		this.ID = ID;
		this.username = username;
		this.password = password;
		this.userNicename = userNicename;
		this.userEmail = userEmail;
		this.userUrl = userUrl;
		this.userRegistered = userRegistered;
		this.userActivationKey = userActivationKey;
		this.userStatus = userStatus;
		this.displayName = displayName;
		this.enabled = enabled;
		this.notExpired = notExpired;
		this.accountNotLocked = accountNotLocked;
		this.credentialsNotExpired = credentialsNotExpired;
	}
}
