package com.dao;

import java.util.List;

import com.entity.CMselect;
import com.entity.Cmanager;
import com.entity.Finalselected;
import com.entity.StuSelectForCM;
import com.entity.TeaSelectForCM;
import com.entity.TeaSelected;
import com.entity.Teacher;

public interface CManagerDao {
	
	 /*
	  * 登录
	  */
	 boolean login(int cid, String cpwd);
	 
	 /*
	  * 查询学生选择情况 
	  */	 
	 List<StuSelectForCM> queryStudentSelectionByMNo(String college);
	 
	 /*
		 * 是否可以选择
		 */
		boolean selectPermition();
		
	 /*
	  * 查询导师选择情况 
	  */	 
	 List<TeaSelectForCM> queryTeacherSelectionByMNo(String college);
	 
	 /*
	  * 最终确认选择 
	  */
     boolean finalselect(String[][] finalselections);
	 
	 /*
	  * 导出最终选择情况 
	  */	 
	 String exportSelectionByMNo(String college);

	List<Cmanager> cmanagerBycid(int cid);
	void select(CMselect cmanagerselect);

	 /*
	  * 查询最终选择情况 
	  */	 
	 List<Finalselected> queryFinal(String college);

}
