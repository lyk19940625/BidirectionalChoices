package com.entity;

import java.util.List;

public class StuSelectForCM {
	
	private String sid;
	
	private String sname;
	
	private List<String> wanted;
	
	private List<Teacher> teachers;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<String> getWanted() {
		return wanted;
	}

	public void setWanted(List<String> wanted) {
		this.wanted = wanted;
	}

	public StuSelectForCM(String sid, String sname, List<String> wanted,
			List<Teacher> teachers) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.wanted = wanted;
		this.teachers = teachers;
	}

}
