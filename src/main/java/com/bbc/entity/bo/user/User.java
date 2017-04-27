package com.bbc.entity.bo.user;

import java.util.Date;

public class User {
	
	private Integer id;
	private String name;
	private String account;
	private String password;
	private String phone;
	private Integer roleId;
	private Integer dateStatus;
	private Integer myIntegral;
	private Date aTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getDateStatus() {
		return dateStatus;
	}
	public void setDateStatus(Integer dateStatus) {
		this.dateStatus = dateStatus;
	}
	public Date getaTime() {
		return aTime;
	}
	public void setaTime(Date aTime) {
		this.aTime = aTime;
	}
	public Integer getMyIntegral() {
		return myIntegral;
	}
	public void setMyIntegral(Integer myIntegral) {
		this.myIntegral = myIntegral;
	}
}
