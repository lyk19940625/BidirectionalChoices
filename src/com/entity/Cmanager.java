package com.entity;

/**
 * Cmanager entity. @author MyEclipse Persistence Tools
 */

public class Cmanager implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String cpwd;
	private String cname;
	private String tel;
	private String sex;
	private String college;

	// Constructors

	/** default constructor */
	public Cmanager() {
	}

	/** minimal constructor */
	public Cmanager(Integer cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Cmanager(Integer cid, String cpwd, String cname, String tel,
			String sex, String college) {
		this.cid = cid;
		this.cpwd = cpwd;
		this.cname = cname;
		this.tel = tel;
		this.sex = sex;
		this.college = college;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCpwd() {
		return this.cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

}