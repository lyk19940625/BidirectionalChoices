package com.entity;

import java.util.List;

public class TeaSelectForCM {
	
	private int tid;
	
	private String tname;
	
	private List<Student> students;
	
	private int num;

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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public TeaSelectForCM(int tid, String tname, List<Student> students,
			int num) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.students = students;
		this.num = num;
	}

}
