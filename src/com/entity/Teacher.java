package com.entity;

import java.util.Date;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer tid;
	private String tname;
	private String tpwd;
	private Integer mno;
	private String introduction;
	private String sex;
	private Date birth;
	private String tel;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Integer tid) {
		this.tid = tid;
	}

	/** full constructor */
	public Teacher(Integer tid, String tname, String tpwd, Integer mno,
			String introduction, String sex, Date birth, String tel) {
		this.tid = tid;
		this.tname = tname;
		this.tpwd = tpwd;
		this.mno = mno;
		this.introduction = introduction;
		this.sex = sex;
		this.birth = birth;
		this.tel = tel;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTpwd() {
		return this.tpwd;
	}

	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}

	public Integer getMno() {
		return this.mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}