package com.entity;

import java.sql.Timestamp;

/**
 * Teacherselected entity. @author MyEclipse Persistence Tools
 */

public class Teacherselected implements java.io.Serializable {

	// Fields

	private TeacherselectedId id;
	private Timestamp time;
	private Integer wanted;

	// Constructors

	/** default constructor */
	public Teacherselected() {
	}

	/** minimal constructor */
	public Teacherselected(TeacherselectedId id) {
		this.id = id;
	}

	/** full constructor */
	public Teacherselected(TeacherselectedId id, Timestamp time, Integer wanted) {
		this.id = id;
		this.time = time;
		this.wanted = wanted;
	}

	// Property accessors

	public TeacherselectedId getId() {
		return this.id;
	}

	public void setId(TeacherselectedId id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Integer getWanted() {
		return this.wanted;
	}

	public void setWanted(Integer wanted) {
		this.wanted = wanted;
	}

}