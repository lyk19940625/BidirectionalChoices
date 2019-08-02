package com.entity;

/**
 * Major entity. @author MyEclipse Persistence Tools
 */

public class Major implements java.io.Serializable {

	// Fields

	private Integer mno;
	private String mname;
	private String college;

	// Constructors

	/** default constructor */
	public Major() {
	}

	/** minimal constructor */
	public Major(Integer mno) {
		this.mno = mno;
	}

	/** full constructor */
	public Major(Integer mno, String mname, String college) {
		this.mno = mno;
		this.mname = mname;
		this.college = college;
	}

	// Property accessors

	public Integer getMno() {
		return this.mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

}