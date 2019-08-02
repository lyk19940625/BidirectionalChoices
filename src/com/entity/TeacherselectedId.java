package com.entity;

/**
 * TeacherselectedId entity. @author MyEclipse Persistence Tools
 */

public class TeacherselectedId implements java.io.Serializable {

	// Fields

	private Integer tid;
	private String sid;

	// Constructors

	/** default constructor */
	public TeacherselectedId() {
	}

	/** full constructor */
	public TeacherselectedId(Integer tid, String sid) {
		this.tid = tid;
		this.sid = sid;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TeacherselectedId))
			return false;
		TeacherselectedId castOther = (TeacherselectedId) other;

		return ((this.getTid() == castOther.getTid()) || (this.getTid() != null
				&& castOther.getTid() != null && this.getTid().equals(
				castOther.getTid())))
				&& ((this.getSid() == castOther.getSid()) || (this.getSid() != null
						&& castOther.getSid() != null && this.getSid().equals(
						castOther.getSid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTid() == null ? 0 : this.getTid().hashCode());
		result = 37 * result
				+ (getSid() == null ? 0 : this.getSid().hashCode());
		return result;
	}

}