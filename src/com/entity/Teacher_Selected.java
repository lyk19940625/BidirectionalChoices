package com.entity;

public class Teacher_Selected {
	private String rank;	
	private String sname;
	private String sex;
	private String birth;
	private String tips;
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
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
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public Teacher_Selected(String rank, String sname, String sex,
			String birth, String tips) {
		super();
		this.rank = rank;
		this.sname = sname;
		this.sex = sex;
		this.birth = birth;
		this.tips = tips;
	}
	
}
