package com.entity;

/**
 * Manager entity. @author MyEclipse Persistence Tools
 */

public class Manager implements java.io.Serializable {

	// Fields

	private Integer mid;
	private String mpwd;

	// Constructors

	/** default constructor */
	public Manager() {
	}

	/** minimal constructor */
	public Manager(Integer mid) {
		this.mid = mid;
	}

	/** full constructor */
	public Manager(Integer mid, String mpwd) {
		this.mid = mid;
		this.mpwd = mpwd;
	}

	// Property accessors

	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return this.mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

}