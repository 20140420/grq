package com.grq.model.pojo.user;

import java.io.Serializable;
/**
 * �������û�
 * @author JiangQuan
 */
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;// �û����
	private String username;// �û���
	private String email;// ����
	private String mobile;// �ֻ�
	private String address;// סַ
	private String password;// ����
	//private String realname;// ��ʵ����
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	/* 
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	*/
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
