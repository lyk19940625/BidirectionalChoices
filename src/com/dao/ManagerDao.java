package com.dao;

import java.util.List;

import com.entity.Cmanager;
import com.entity.Finalselected;
import com.entity.Major;
import com.entity.Student;
import com.entity.Teacher;

public interface ManagerDao {
	
	 /*
	  * ��¼
	  */
	 boolean login(int mid, String mpwd);
	 
	 /*
	  * ����ѧ��
	  */
	 boolean importStudent(List<Student> students);
	 
	 /*
	  * ���뵼ʦ
	  */ 
	 boolean importTeacher(List<Teacher> teachers);
	 
	 /*
	  * ����ѧ��
	  */ 
	 boolean updateStudent(Student student);
	 
	 /*
	  * ���µ�ʦ
	  */ 
	 boolean updateTeacher(Teacher teacher);
	 
	 /*
	  * ɾ��ѧ��
	  */ 
	 boolean deleteStudent(Student student);
	 
	 /*
	  * ɾ����ʦ
	  */
	 boolean deleteTeacher(Teacher teacher);
	 
	 /*
	  * ��ѯѧ��
	  */
	 Student queryStudentById(String sid);
	 
	 /*
	  * ��ѯ��ʦ
	  */ 
	 Teacher queryTeacherById(int tid);
	 
	 /*
	  * ��ѯѧ�Ƶ㸺����
	  */ 
	 Cmanager queryCmanagerById(int cid);
	 
	 /*
	  * ����ѧ�Ƶ㸺����
	  */
	 boolean update(Cmanager cmanager);
	 
	 /*
	  * ɾ��ѧ�Ƶ㸺����
	  */
	 boolean delete(Cmanager cmanager);
	 
	 /*
	  * ��ѯרҵ��Ϣ 
	  */
	 List<Major> queryMajor();
	 Major queryMajorByNo(int no);
	 
	 /*
	  * ����רҵ 
	  */
	 boolean addMajor(Major major);
	 
	 /*
	  *  ɾ��רҵ
	  */
	 boolean deleteMajor(Major major);
	 
	 /*
	  * ���޸�רҵ��Ϣ
	  */
	 boolean updateMajor(Major major);
	 
	 /*
	  * ��ѯ����ѡ����� 
	  */
     String[][] querySelection();
	 
	 String[][] querySelectionByMNo(int mno);
	 
	 /*
	  * ��������ѡ����� 
	  */
	 String exportSelection();
	 
	 String exportSelectionByMNo(int mno);
	 
	 /*
	  * ����ѡ��ϵͳ
	  */
	 void openSelection();
	 
	 /*
	  * �ر�ѡ��ϵͳ
	  */
	 void closeTSelection();
	 
	 /*
	  * ����ѡ��ϵͳ
	  */
	 void openTSelection();
	 
	 /*
	  * �ر�ѡ��ϵͳ
	  */
	 void closeSelection();
	 
	 /*
	  * ��������ȷ��ϵͳ
	  */
	 void openCManagement();
	 
	 /*
	  * �ر�����ȷ��ϵͳ 
	  */
	 void closeCManagement();
	 
	 /*
	  * ��ѯѧ�� 
	  */
	 List<Student> qstudent(int mno);
	 /*
	  * ��ѯ��ʦ 
	  */
	 List<Teacher> qteacher(int mno);
	 
	 /*
	  * ��ѯѧ�Ƶ㸺����
	  */
	 List<Cmanager> qcmanager();
	 /*
	  * ���ѧ��
	  */
	 void savestudent(Student student);
	 /*
	  * �鿴����
	  */
	 List<Finalselected> queryFinal(String college);
}
