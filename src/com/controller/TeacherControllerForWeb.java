package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.entity.StuSelected;
import com.entity.Student;
import com.entity.TeaSelected;
import com.entity.Teacher;
import com.entity.Teacher_Selected;
import com.entity.Teacher_StudentInfo;
@Controller  
@RequestMapping("/teacher") 
public class TeacherControllerForWeb {
	@Resource
    private TeacherDao teacherDao; 
	
	
	 @RequestMapping(value="/edit",method = RequestMethod.POST)  
     public String editTeacher(Teacher teacher) {  
     	teacherDao.update(teacher);
         return "Teacher";  
     }  
	 
	 @RequestMapping(value="/query",method = RequestMethod.GET)  
     public String query(HttpServletRequest req) {  
	
		if(teacherDao.selectPermition()) {
			int tid = ((Teacher)req.getSession().getAttribute("teacher")).getTid(); 
		     
	     	List<Teacher_StudentInfo> tsinfolist =new ArrayList();
	     for(int i=0;i<teacherDao.query(tid).length;i++){
	    			Teacher_StudentInfo tsinfo=new Teacher_StudentInfo(teacherDao.query(tid)[i][0], teacherDao.query(tid)[i][1], teacherDao.query(tid)[i][2], teacherDao.query(tid)[i][3], teacherDao.query(tid)[i][4], teacherDao.query(tid)[i][5], teacherDao.query(tid)[i][6], teacherDao.query(tid)[i][7]);
	    			tsinfolist.add(tsinfo);
	    	
	     }
        
	     req.getSession().setAttribute("tslist", tsinfolist);

	         return "../TeacherSelect";  
		}else
			return "../SystemClose_T";  /////////////////////////////////////////////////////这里跳转至未开通选择界面
     }  

	 @RequestMapping(value="/queryteacher",method = RequestMethod.GET)  
     public String queryteacher(HttpServletRequest req) {  
	
		int tid = ((Teacher)req.getSession().getAttribute("teacher")).getTid(); 
		String tname=teacherDao.teacherBytid(tid).get(0).getTname();
		System.out.println("tname"+tname);
     	req.getSession().setAttribute("teacherlist",teacherDao.teacherBytid(tid) );
//     	 String sname=((Student)teacherDao.getmyStudents(tid).get(0)).getSname();
//         System.out.println("sname"+sname);
         try{
	     req.getSession().setAttribute("mystudentlist", teacherDao.getmyStudents(tid));
         }
         
         catch(Exception ex) {
				
				return "../Teacher"; 
			}
         return "../Teacher";  
     }  
	 @RequestMapping(value="/selected" , method = RequestMethod.POST)  
	    public String Selected(TeaSelected ts,HttpServletRequest req) {
		 System.out.println("Yes");
		teacherDao.select(ts);
		 // stuselectde.setId(wanted1);
		 return "redirect:/teacher/queryteacher";  
	 
	 }
	 @RequestMapping(value="/queryselected" , method = RequestMethod.GET)  
	    public String QuerySelected(HttpServletRequest req) {
		 System.out.println("Yes");
		 int tid = ((Teacher)req.getSession().getAttribute("teacher")).getTid();
		 List<Teacher_Selected> tselected =new ArrayList();
	     for(int i=0;i<teacherDao.tselected(tid).length;i++){
	    	 Teacher_Selected tsed=new Teacher_Selected(teacherDao.tselected(tid)[i][0], teacherDao.tselected(tid)[i][1], teacherDao.tselected(tid)[i][2], teacherDao.tselected(tid)[i][3], teacherDao.tselected(tid)[i][4]);
	    	 tselected.add(tsed);
	     }
		req.getSession().setAttribute("tlisted",tselected);
		 // stuselectde.setId(wanted1);
		 return "../TeacherSelected";  
	 
	 }
}
