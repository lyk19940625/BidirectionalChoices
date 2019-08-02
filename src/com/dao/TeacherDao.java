package com.dao;

import java.util.List;

import com.entity.Student;
import com.entity.StudentInfo;
import com.entity.Studentselected;
import com.entity.TeaSelected;
import com.entity.Teacher;

public interface TeacherDao {
	
	/*
	 * 登录
	 */
    boolean login(int tid, String tpwd);
	
   
    /*
	 * 更新密码
	 */
	void update(Teacher teaher);
	
	/*
	 * 是否可以选择
	 */
	boolean selectPermition();
	/*
	 * “查看选择您为导师的学生”的志愿提交情况,即学生选择的导师。志愿按照第1~3排列
	 */
	 String[][] query(int tid);
	
	/*
	 * 选择学生,List个数<=3
	 */
	void select(TeaSelected studentinfos);

	List<Teacher> teacherBytid(int tid);


	String[][] tselected(int tid);

	/*
	 * 查看自己的学生
	 */
	List<Student> getmyStudents(int tid);


}
