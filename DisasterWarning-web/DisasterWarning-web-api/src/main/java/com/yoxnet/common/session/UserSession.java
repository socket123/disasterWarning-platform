package com.yoxnet.common.session;

import java.io.Serializable;
import java.util.Set;


public class UserSession implements Serializable{
	/**
	 * session 参数实体类
	 */
	private static final long serialVersionUID = 1L;
	private String id;//登陆人id
	private String loginName;//登录名
	private String token;// token
	private String nikename;//用户的真是姓名（后台）或昵称（前台）
	private Set<String> roles;//登录人角色列表集合
	private Set<String> resources;//登录人所拥有的按钮集合
    private String sysFlag;//系统标识 。P：pc官网，M：管理后台
	
	public UserSession(String id, String loginName, String token, String nikename, Set<String> roles,
			Set<String> resources) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.token = token;
		this.nikename = nikename;
		this.roles = roles;
		this.resources = resources;
	}
	public UserSession() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getNikename() {
		return nikename;
	}
	public void setNikename(String nikename) {
		this.nikename = nikename;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public Set<String> getResources() {
		return resources;
	}
	public void setResources(Set<String> resources) {
		this.resources = resources;
	}
	public String getSysFlag() {
		return sysFlag;
	}
	public void setSysFlag(String sysFlag) {
		this.sysFlag = sysFlag;
	}
}
