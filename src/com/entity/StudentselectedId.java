package com.entity;

/**
 * StudentselectedId entity. @author MyEclipse Persistence Tools
 */

public class StudentselectedId implements java.io.Serializable {

	// Fields

	private String sid;
	private Integer tid;

	// Constructors

	/** default constructor */
	public StudentselectedId() {
	}

	/** full constructor */
	public StudentselectedId(String sid, Integer tid) {
		this.sid = sid;
		this.tid = tid;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StudentselectedId))
			return false;
		StudentselectedId castOther = (StudentselectedId) other;

		return ((this.getSid() == castOther.getSid()) || (this.getSid() != null
				&& castOther.getSid() != null && this.getSid().equals(
				castOther.getSid())))
				&& ((this.getTid() == castOther.getTid()) || (this.getTid() != null
						&& castOther.getTid() != null && this.getTid().equals(
						castOther.getTid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSid() == null ? 0 : this.getSid().hashCode());
		result = 37 * result
				+ (getTid() == null ? 0 : this.getTid().hashCode());
		return result;
	}

}