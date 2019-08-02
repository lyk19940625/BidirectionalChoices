package com.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.read.biff.BiffException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dao.ManagerDao;
import com.dao.StudentDao;
import com.entity.Cmanager;
import com.entity.Finalselected;
import com.entity.StuSelected;
import com.entity.Student;
import com.entity.Teacher;
import com.entity.Studentselected;
import com.util.ExclUtil;
@Controller  
@RequestMapping("/manager") 
public class ManagerControllerForWeb {
	@Resource
    private ManagerDao managerDao; 
	@Resource
    private StudentDao studentDao; 

	@RequestMapping(value="/querymajor",method = RequestMethod.GET)  
     public String queryMajor(HttpServletRequest req) { 
		req.getSession().setAttribute("cmanagerlist",managerDao.qcmanager());
     	req.getSession().setAttribute("majorlist",managerDao.queryMajor());
         return "../Manager";  
     }  
	 @RequestMapping(value="/query",method = RequestMethod.GET)  
     public String queryAll(String mno,HttpServletRequest req) { 
		 int no=Integer.parseInt(mno);
     	req.getSession().setAttribute("studentlist",managerDao.qstudent(no));
     	req.getSession().setAttribute("teacherlist",managerDao.qteacher(no));
         return "../Manager_ST";  
     }  
	 @RequestMapping(value="/querystu",method = RequestMethod.GET)  
     public String querystu(String sid,HttpServletRequest req) { 
		
		 Student stu=managerDao.queryStudentById(sid);
		
     	req.getSession().setAttribute("student",stu);
         return "../ManagerUpdateS";  
     }  
	 @RequestMapping(value="/updatestudent",method = RequestMethod.POST)  
     public String updatestudent(Student stu,HttpServletRequest req) { 
		
		 managerDao.updateStudent(stu);
         return "../ManagerStudent";  
     }  
	 @RequestMapping(value="/querytea",method = RequestMethod.GET)  
     public String querytea(String tid,HttpServletRequest req) { 
		 int no=Integer.parseInt(tid);
		 Teacher tea=managerDao.queryTeacherById(no);
		
     	req.getSession().setAttribute("teacher",tea);
         return "../ManagerUpdateT";  
     }  
	 @RequestMapping(value="/updateteacher",method = RequestMethod.POST)  
     public String updateteacher(Teacher tea,HttpServletRequest req) { 
		
		 managerDao.updateTeacher(tea);
         return "../ManagerTeacher";  
     }  
	 @RequestMapping(value="/querycm",method = RequestMethod.GET)  
     public String querycm(String cid,HttpServletRequest req) { 
		 int no=Integer.parseInt(cid);
		 Cmanager cm=managerDao.queryCmanagerById(no);
		System.out.println(cm.getCname());
     	req.getSession().setAttribute("cmanager",cm);
         return "../ManagerUpdateC";  
     }  
	 @RequestMapping(value="/updatecmanager",method = RequestMethod.POST)  
     public String updatecmanager(Cmanager cm,HttpServletRequest req) { 
		
		 managerDao.update(cm);
         return "../ManagerCmanager";  
     }  
	 
	 @RequestMapping(value="savestudent",method = RequestMethod.POST)  
     public String savestudent(Student student,HttpServletRequest req) { 
		
		 managerDao.savestudent(student);
         return "../ManagerCmanager";  
     }  
	 @RequestMapping(value = "/upload", method = RequestMethod.POST)
		public String upload(HttpServletRequest request) throws BiffException, IOException {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("uploadFile");
			

			// 获得文件名：
			String realFileName = file.getOriginalFilename();
			System.out.println("获得文件名：" + realFileName);
			// 获取路径
			String ctxPath = "C://Excel//";
			// 创建文件
			File dirPath = new File(ctxPath);
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
			File uploadFile = new File(ctxPath + realFileName);
			try {
				FileCopyUtils.copy(file.getBytes(), uploadFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[][] stus = ExclUtil.readExcel(ctxPath + realFileName);
			List<Student> students = new ArrayList<Student>();
			
			for(int i = 0; i<stus.length; i++) {
				String[] date = stus[i][5].split("-");
				Date da = new Date();
				da.setYear(Integer.parseInt(date[0]));
				da.setMonth(Integer.parseInt(date[1])-1);
				da.setDate(Integer.parseInt(date[2]));
				Student student = new Student(stus[i][0], Integer.parseInt(stus[i][1]), stus[i][2],stus[i][3],
						stus[i][4],da,Integer.parseInt(stus[i][6]),stus[i][7],stus[i][8]);
				students.add(student);
			}
			managerDao.importStudent(students);
			return "../ManagerUploadOk";
		}
	 @RequestMapping(value="/final",method = RequestMethod.GET)  
     public String quryfinal(String college,HttpServletRequest req) { 
		 String col="";
		 if(college.equals("1")){
			  col="计算机科学与技术";
		 }
			System.out.println("college"+col);
			String fname=((Finalselected)managerDao.queryFinal(col).get(0)).getStudents().get(1).getSname();
			System.out.println("fname"+fname);
		 req.getSession().setAttribute("finallist",managerDao.queryFinal(col));
		 return "../ManagerFinal";  
	 }
	 @RequestMapping("/download.xls")
		public void download(HttpServletRequest request, HttpServletResponse response) {
			int BUFFER_SIZE = 4096;
			InputStream in = null;
			OutputStream out = null;

			try {
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("application/octet-stream");
				List<Finalselected> list = (List<Finalselected>) request.getSession().getAttribute("finallist");
				String[][] excel = new String[list.size()][5];
				int i = 0;
				for(Finalselected finalselected : list) {
					excel[i][0] = String.valueOf(finalselected.getTid());
					excel[i][1] = finalselected.getTname();
					int j = 2;
					for(Student student :finalselected.getStudents()) {
						excel[i][j] = student.getSname();
						j++;
					}
					i++;
				}
				ExclUtil.writeExcel(excel, "C://Excel//download.xls");
				File file = new File("C://Excel//download.xls");
				response.setContentLength((int) file.length());

				int readLength = 0;

				in = new BufferedInputStream(new FileInputStream(file), BUFFER_SIZE);
				out = new BufferedOutputStream(response.getOutputStream());

				byte[] buffer = new byte[BUFFER_SIZE];
				while ((readLength = in.read(buffer)) > 0) {
					byte[] bytes = new byte[readLength];
					System.arraycopy(buffer, 0, bytes, 0, readLength);
					out.write(bytes);
				}

				out.flush();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
					}
				}
				if (out != null) {
					try {
						out.close();
					} catch (IOException e) {
					}
				}
			}
		}
	 
	 @RequestMapping(value="/openstudent",method = RequestMethod.GET)  
     public String openstudent() { 
		 managerDao.openSelection();
         return "../SystemOpen";  
     }  
	 @RequestMapping(value="/closestudent",method = RequestMethod.GET)  
     public String closestudent() { 
		 managerDao.closeSelection();
         return "../SystemClose";  
     }  
	 @RequestMapping(value="/opencmanager",method = RequestMethod.GET)  
     public String opencmanager() { 
		 managerDao.openCManagement();
         return "../SystemOpen";  
     }  
	 @RequestMapping(value="/closecmanager",method = RequestMethod.GET)  
     public String closecmanager(){ 
		 managerDao.closeCManagement();
         return "../SystemClose";  
     }  
	 @RequestMapping(value="/openteacher",method = RequestMethod.GET)  
     public String openteacher() { 
		 managerDao.openTSelection();
         return "../SystemOpen";  
     }  
	 @RequestMapping(value="/closeteacher",method = RequestMethod.GET)  
     public String closemanager(){ 
		 managerDao.closeTSelection();
         return "../SystemClose";  
     }  
}