package com.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.CManagerDao;
import com.dao.ManagerDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.entity.Cmanager;
import com.entity.Manager;
import com.entity.Student;
import com.entity.Teacher;

@Controller  
@RequestMapping("/login") 
public class LoginControllerForWeb {
	@Resource
    private StudentDao studentDao; 
	@Resource
    private TeacherDao teacherDao;
	@Resource
    private CManagerDao cmanagerDao;
	@Resource
    private ManagerDao managerDao;
	@RequestMapping(value="/check" , method = RequestMethod.POST)  
    public String queryStudent(ModelMap map,String id,String spwd,String type,HttpServletRequest req) {
		System.out.println("t"+type+"sid"+id+"spwd"+spwd);
		System.out.println("type"+type);
		switch(type){
		case "1":if(studentDao.login(id, spwd)){
    		Student stu=studentDao.studentBysid(id).get(0);
    		
    		req.getSession().setAttribute("stu", stu);
    		 return "redirect:/student/queryselected"; 
    	}
    	 else
   	    	return "../Login";
		
			
		case"2":try{
			int tid = Integer.parseInt(id);
			System.out.println(tid);
			if(teacherDao.login(tid, spwd)){
				System.out.println("tid"+tid);
        		Teacher teacher=teacherDao.teacherBytid(tid).get(0);
        		req.getSession().setAttribute("teacher", teacher);
        		 return "redirect:/teacher/queryteacher"; 
        	}
        	else
      	    	return "../Login";
    		}
		catch(Exception ex) {
			ex.printStackTrace();
			return "../Login"; 
		}
		case"3":try{
			int cid = Integer.parseInt(id);
			System.out.println(cid);
			if(cmanagerDao.login(cid, spwd)){
				System.out.println("cid"+cid);
				Cmanager cmanager=cmanagerDao.cmanagerBycid(cid).get(0);
        		req.getSession().setAttribute("cmanager", cmanager);
        		 return "redirect:/cmanager/queryst"; 
        	}
        	else
      	    	return "../Login";
    		}
		catch(Exception ex) {
			ex.printStackTrace();
			return "../Login"; 
		}
		case"4":try{
			int mid = Integer.parseInt(id);
			System.out.println(mid);
			if(managerDao.login(mid, spwd)){
				System.out.println("mid"+mid);
        		
        		 return "redirect:/manager/querymajor"; 
        	}
        	else
      	    	return "../Login";
    		}
		catch(Exception ex) {
			ex.printStackTrace();
			return "../Login"; 
		}
    	
		
		default:
	    	return "../Login";
		}
	}
}
		