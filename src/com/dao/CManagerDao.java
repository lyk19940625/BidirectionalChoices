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
	  * ��¼
	  */
	 boolean login(int cid, String cpwd);
	 
	 /*
	  * ��ѯѧ��ѡ����� 
	  */	 
	 List<StuSelectForCM> queryStudentSelectionByMNo(String college);
	 
	 /*
		 * �Ƿ����ѡ��
		 */
		boolean selectPermition();
		
	 /*
	  * ��ѯ��ʦѡ����� 
	  */	 
	 List<TeaSelectForCM> queryTeacherSelectionByMNo(String college);
	 
	 /*
	  * ����ȷ��ѡ�� 
	  */
     boolean finalselect(String[][] finalselections);
	 
	 /*
	  * ��������ѡ����� 
	  */	 
	 String exportSelectionByMNo(String college);

	List<Cmanager> cmanagerBycid(int cid);
	void select(CMselect cmanagerselect);

	 /*
	  * ��ѯ����ѡ����� 
	  */	 
	 List<Finalselected> queryFinal(String college);

}
