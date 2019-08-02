package com.entity;

/**
 * Managerselected entity. @author MyEclipse Persistence Tools
 */

public class Managerselected implements java.io.Serializable {

	// Fields

	private ManagerselectedId id;

	// Constructors

	/** default constructor */
	public Managerselected() {
	}

	/** full constructor */
	public Managerselected(ManagerselectedId id) {
		this.id = id;
	}

	// Property accessors

	public ManagerselectedId getId() {
		return this.id;
	}

	public void setId(ManagerselectedId id) {
		this.id = id;
	}

}