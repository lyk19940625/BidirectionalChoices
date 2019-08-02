package com.entity;

import java.util.Date;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String sid;
	private Integer eid;
	private String sname;
	private String spwd;
	private String sex;
	private Date birth;
	private Integer mno;
	private String tel;
	private String tips;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String sid) {
		this.sid = sid;
	}

	/** full constructor */
	public Student(String sid, Integer eid, String sname, String spwd,
			String sex, Date birth, Integer mno, String tel, String tips) {
		this.sid = sid;
		this.eid = eid;
		this.sname = sname;
		this.spwd = spwd;
		this.sex = sex;
		this.birth = birth;
		this.mno = mno;
		this.tel = tel;
		this.tips = tips;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Integer getEid() {
		return this.eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpwd() {
		return this.spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
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

	public Integer getMno() {
		return this.mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTips() {
		return this.tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

}