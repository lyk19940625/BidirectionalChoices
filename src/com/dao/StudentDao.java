package com.dao;

import java.util.List;

import com.entity.Student;
import com.entity.Studentselected;
import com.entity.Teacher;

public interface StudentDao {
	/*
	 * ��¼
	 */
	boolean login(String sid, String spwd);
	
	/*
	 * ��������
	 */
	void update(Student student);
	
	/*
	 * �Ƿ����ѡ��
	 */
	boolean selectPermition();
	/*
	 * ��ѯĳѧ����ѡרҵ��ȫ����ʦ
	 */
	List<Teacher> teacherBymno(int mno);
	/*
	 * ѡ��ʦ,List����<=3
	 */
	void select(List<String> ids);
	
	List<Student> studentBysid(String sid);

	List<String> selectwanted(String sid);

	Teacher getMyTeacher(String sid);
	
	

}
