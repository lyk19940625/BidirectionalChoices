package com.entity;

/**
 * Studentselected entity. @author MyEclipse Persistence Tools
 */

public class Studentselected implements java.io.Serializable {

	// Fields

	private StudentselectedId id;
	private Integer wanted;

	// Constructors

	/** default constructor */
	public Studentselected() {
	}

	/** minimal constructor */
	public Studentselected(StudentselectedId id) {
		this.id = id;
	}

	/** full constructor */
	public Studentselected(StudentselectedId id, Integer wanted) {
		this.id = id;
		this.wanted = wanted;
	}

	// Property accessors

	public StudentselectedId getId() {
		return this.id;
	}

	public void setId(StudentselectedId id) {
		this.id = id;
	}

	public Integer getWanted() {
		return this.wanted;
	}

	public void setWanted(Integer wanted) {
		this.wanted = wanted;
	}

}