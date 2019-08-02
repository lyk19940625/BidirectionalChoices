package com.entity;

/**
 * Selection entity. @author MyEclipse Persistence Tools
 */

public class Selection implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer state;
	private Integer cstate;
	private Integer tstate;

	// Constructors

	/** default constructor */
	public Selection() {
	}

	/** minimal constructor */
	public Selection(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public Selection(Integer id, Integer state, Integer cstate, Integer tstate) {
		this.id = id;
		this.state = state;
		this.cstate = cstate;
		this.tstate = tstate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getCstate() {
		return this.cstate;
	}

	public void setCstate(Integer cstate) {
		this.cstate = cstate;
	}

	public Integer getTstate() {
		return this.tstate;
	}

	public void setTstate(Integer tstate) {
		this.tstate = tstate;
	}

}