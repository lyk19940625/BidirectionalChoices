package com.dao;

import java.util.List;

import com.entity.Student;
import com.entity.StudentInfo;
import com.entity.Studentselected;
import com.entity.TeaSelected;
import com.entity.Teacher;

public interface TeacherDao {
	
	/*
	 * ��¼
	 */
    boolean login(int tid, String tpwd);
	
   
    /*
	 * ��������
	 */
	void update(Teacher teaher);
	
	/*
	 * �Ƿ����ѡ��
	 */
	boolean selectPermition();
	/*
	 * ���鿴ѡ����Ϊ��ʦ��ѧ������־Ը�ύ���,��ѧ��ѡ��ĵ�ʦ��־Ը���յ�1~3����
	 */
	 String[][] query(int tid);
	
	/*
	 * ѡ��ѧ��,List����<=3
	 */
	void select(TeaSelected studentinfos);

	List<Teacher> teacherBytid(int tid);


	String[][] tselected(int tid);

	/*
	 * �鿴�Լ���ѧ��
	 */
	List<Student> getmyStudents(int tid);


}
