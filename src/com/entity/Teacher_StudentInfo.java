package com.entity;

public class Teacher_StudentInfo {
private String sid;
private String tid;	
private String sname;
private String sex;
private String birth;
private String wanted1;
private String wanted2;
private String wanted3;
public String getSid() {
	return sid;
}
public void setSid(String sid) {
	this.sid = sid;
}
public String getTid() {
	return tid;
}
public void setTid(String tid) {
	this.tid = tid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getBirth() {
	return birth;
}
public void setBirth(String birth) {
	this.birth = birth;
}
public String getWanted1() {
	return wanted1;
}
public void setWanted1(String wanted1) {
	this.wanted1 = wanted1;
}
public String getWanted2() {
	return wanted2;
}
public void setWanted2(String wanted2) {
	this.wanted2 = wanted2;
}
public String getWanted3() {
	return wanted3;
}
public void setWanted3(String wanted3) {
	this.wanted3 = wanted3;
}
public Teacher_StudentInfo(String tid, String sid, String sname, String sex,
		String birth, String wanted1, String wanted2, String wanted3) {
	super();
	this.sid = sid;
	this.tid = tid;
	this.sname = sname;
	this.sex = sex;
	this.birth = birth;
	this.wanted1 = wanted1;
	this.wanted2 = wanted2;
	this.wanted3 = wanted3;
}


}
