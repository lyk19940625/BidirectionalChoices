package com.entity;

import java.util.List;


public class CMselect {
	
	
	private List<String> tid;
	private List<String> sid;
	
	public CMselect() {
		super();
	}
	public List<String> getTid() {
		return tid;
	}
	public void setTid(List<String> tid) {
		this.tid = tid;
	}
	public List<String> getSid() {
		return sid;
	}
	public void setSid(List<String> sid) {
		this.sid = sid;
	}
	public CMselect(List<String> tid, List<String> sid) {
		super();
		this.tid = tid;
		this.sid = sid;
	}
	
}