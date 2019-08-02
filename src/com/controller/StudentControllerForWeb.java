package com.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.ManagerDao;
import com.dao.StudentDao;
import com.entity.StuSelected;
import com.entity.Student;
import com.entity.Teacher;
import com.entity.Studentselected;
@Controller  
@RequestMapping("/student") 
public class StudentControllerForWeb {
	@Resource
    private StudentDao studentDao; 
	
	 @RequestMapping(value="/query",method = RequestMethod.GET)  
     public String queryStudent(ModelMap map,HttpServletRequest req) { 
		String sid=((Student)req.getSession().getAttribute("stu")).getSid();
     	map.addAttribute("studentlist",studentDao.studentBysid(sid));
         return "../StudentEdit";  
     }  
	
	 @RequestMapping(value="/edit",method = RequestMethod.POST)  
     public String editStudent(Student student) {  
     	studentDao.update(student);
         return "redirect:/student/queryselected";  
     }  
	 
	 @RequestMapping(value="/teacherinfo",method = RequestMethod.GET)  
	 public String Teacherinfo(HttpServletRequest req) { 
		 int mno=((Student)req.getSession().getAttribute("stu")).getMno(); 
		 System.out.println("mno"+mno);
		 List<Teacher> Teacher = studentDao.teacherBymno(mno);
		 req.getSession().setAttribute("teacherlist",studentDao.teacherBymno(mno));
         return "../TeacherInfo";  
     }  
	 @RequestMapping(value="/select",method = RequestMethod.GET)  
	 public String Select(ModelMap map,HttpServletRequest req) { 
		 if(studentDao.selectPermition()) {
			 int mno=((Student)req.getSession().getAttribute("stu")).getMno(); 
			 List<Teacher> teacher = studentDao.teacherBymno(mno);
			 map.addAttribute("teacherlist",studentDao.teacherBymno(mno));
	         return "../StudentSelect";  
		 }else {
			 return "../SystemClose_S";  //////////////////////////////////////////////////这里改成未开通选择界面
		 }
     }  
	 
	 @RequestMapping(value="/selected" , method = RequestMethod.POST)  
	    public String Selected(StuSelected st,HttpServletRequest req) {
		 System.out.println("Yes");
		 studentDao.select(st.getIds());
		 // stuselectde.setId(wanted1);
		 return "redirect:/student/queryselected";  
	 
	 }
	 @RequestMapping(value="/queryselected" , method = RequestMethod.GET)  
	    public String querySelected(HttpServletRequest req) {
        String sid=((Student)req.getSession().getAttribute("stu")).getSid();
		 req.getSession().setAttribute("seletedlist", studentDao.selectwanted(sid));
		 req.getSession().setAttribute("studentlist", studentDao.studentBysid(sid));
		 try{
			 req.getSession().setAttribute("finalteacher", studentDao.getMyTeacher(sid));
		 }
			catch(Exception ex) {
				
				return "../Student"; 
			}
		// req.getSession().setAttribute("finalteacher", studentDao.getMyTeacher(sid));
		 return "../Student";  
	 
	 }
	 @RequestMapping(value="/querys" , method = RequestMethod.GET)  
	    public String queryS(HttpServletRequest req) {
     String sid=((Student)req.getSession().getAttribute("stu")).getSid();
		
		 req.getSession().setAttribute("studentlist", studentDao.studentBysid(sid));
		 return "../StudentEdit";  
	 
	 }
    } 


