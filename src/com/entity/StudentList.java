package com.entity;

import java.util.List;

public class StudentList {
private List<StudentInfo> studentlist;

public List<StudentInfo> getStudentlist() {
	return studentlist;
}

public void setStudentlist(List<StudentInfo> studentlist) {
	this.studentlist = studentlist;
}

public StudentList(List<StudentInfo> studentlist) {
	super();
	this.studentlist = studentlist;
}
}
