package com.entity;

import java.util.Date;

public class StudentInfo {
private String sid;
private int wanted;
private Date time;
public String getSid() {
	return sid;
}
public void setSid(String sid) {
	this.sid = sid;
}
public int getWanted() {
	return wanted;
}
public void setWanted(int wanted) {
	this.wanted = wanted;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
public StudentInfo(String sid, int wanted, Date time) {
	super();
	this.sid = sid;
	this.wanted = wanted;
	this.time = time;
}

}
