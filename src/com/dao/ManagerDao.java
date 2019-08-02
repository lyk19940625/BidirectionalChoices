package com.dao;

import java.util.List;

import com.entity.Cmanager;
import com.entity.Finalselected;
import com.entity.Major;
import com.entity.Student;
import com.entity.Teacher;

public interface ManagerDao {
	
	 /*
	  * 登录
	  */
	 boolean login(int mid, String mpwd);
	 
	 /*
	  * 导入学生
	  */
	 boolean importStudent(List<Student> students);
	 
	 /*
	  * 导入导师
	  */ 
	 boolean importTeacher(List<Teacher> teachers);
	 
	 /*
	  * 更新学生
	  */ 
	 boolean updateStudent(Student student);
	 
	 /*
	  * 更新导师
	  */ 
	 boolean updateTeacher(Teacher teacher);
	 
	 /*
	  * 删除学生
	  */ 
	 boolean deleteStudent(Student student);
	 
	 /*
	  * 删除导师
	  */
	 boolean deleteTeacher(Teacher teacher);
	 
	 /*
	  * 查询学生
	  */
	 Student queryStudentById(String sid);
	 
	 /*
	  * 查询导师
	  */ 
	 Teacher queryTeacherById(int tid);
	 
	 /*
	  * 查询学科点负责人
	  */ 
	 Cmanager queryCmanagerById(int cid);
	 
	 /*
	  * 更新学科点负责人
	  */
	 boolean update(Cmanager cmanager);
	 
	 /*
	  * 删除学科点负责人
	  */
	 boolean delete(Cmanager cmanager);
	 
	 /*
	  * 查询专业信息 
	  */
	 List<Major> queryMajor();
	 Major queryMajorByNo(int no);
	 
	 /*
	  * 增加专业 
	  */
	 boolean addMajor(Major major);
	 
	 /*
	  *  删除专业
	  */
	 boolean deleteMajor(Major major);
	 
	 /*
	  * 修修改专业信息
	  */
	 boolean updateMajor(Major major);
	 
	 /*
	  * 查询最终选择情况 
	  */
     String[][] querySelection();
	 
	 String[][] querySelectionByMNo(int mno);
	 
	 /*
	  * 导出最终选择情况 
	  */
	 String exportSelection();
	 
	 String exportSelectionByMNo(int mno);
	 
	 /*
	  * 开启选择系统
	  */
	 void openSelection();
	 
	 /*
	  * 关闭选择系统
	  */
	 void closeTSelection();
	 
	 /*
	  * 开启选择系统
	  */
	 void openTSelection();
	 
	 /*
	  * 关闭选择系统
	  */
	 void closeSelection();
	 
	 /*
	  * 开启最终确认系统
	  */
	 void openCManagement();
	 
	 /*
	  * 关闭最终确认系统 
	  */
	 void closeCManagement();
	 
	 /*
	  * 查询学生 
	  */
	 List<Student> qstudent(int mno);
	 /*
	  * 查询老师 
	  */
	 List<Teacher> qteacher(int mno);
	 
	 /*
	  * 查询学科点负责人
	  */
	 List<Cmanager> qcmanager();
	 /*
	  * 添加学生
	  */
	 void savestudent(Student student);
	 /*
	  * 查看最终
	  */
	 List<Finalselected> queryFinal(String college);
}
