package com.entity;

import java.util.List;

public class Finalselected {
	
	private int tid;
	
	private String tname;
	
	private List<Student> students;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTnameString(String tname) {
		this.tname = tname;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Finalselected(int tid, String tname, List<Student> students) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.students = students;
	}

}
