package com.dao;

import java.util.List;

import com.entity.Student;
import com.entity.Studentselected;
import com.entity.Teacher;

public interface StudentDao {
	/*
	 * 登录
	 */
	boolean login(String sid, String spwd);
	
	/*
	 * 更新密码
	 */
	void update(Student student);
	
	/*
	 * 是否可以选择
	 */
	boolean selectPermition();
	/*
	 * 查询某学生所选专业的全部导师
	 */
	List<Teacher> teacherBymno(int mno);
	/*
	 * 选择导师,List个数<=3
	 */
	void select(List<String> ids);
	
	List<Student> studentBysid(String sid);

	List<String> selectwanted(String sid);

	Teacher getMyTeacher(String sid);
	
	

}
