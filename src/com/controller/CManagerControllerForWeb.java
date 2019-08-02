package com.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.CManagerDao;
import com.dao.ManagerDao;
import com.dao.StudentDao;
import com.entity.CMselect;
import com.entity.Cmanager;
import com.entity.Finalselected;
import com.entity.StuSelectForCM;
import com.entity.StuSelected;
import com.entity.Student;
import com.entity.TeaSelectForCM;
import com.entity.Teacher;
import com.entity.Studentselected;
import com.util.ExclUtil;
@Controller  
@RequestMapping("/cmanager") 
public class CManagerControllerForWeb {
	@Resource
    private ManagerDao managerDao; 
	@Resource
    private StudentDao studentDao; 
	@Resource
    private CManagerDao cmanagerDao; 
	
	 @RequestMapping(value="/querystudent",method = RequestMethod.GET)  
     public String queryStudent(HttpServletRequest req) { 
		String college=((Cmanager)req.getSession().getAttribute("cmanager")).getCollege();
		System.out.println("college"+college);
		String sid=((StuSelectForCM)cmanagerDao.queryStudentSelectionByMNo(college).get(0)).getSid();
		System.out.println("sid"+sid);
		req.getSession().setAttribute("cstudentlist",cmanagerDao.queryStudentSelectionByMNo(college));
         return "../Cmanager_S";  
     }  
	 @RequestMapping(value="/queryteacher",method = RequestMethod.GET)  
     public String queryTeacher(HttpServletRequest req) { 
		String college=((Cmanager)req.getSession().getAttribute("cmanager")).getCollege();
		System.out.println("college"+college);
		String tname=((TeaSelectForCM)cmanagerDao.queryTeacherSelectionByMNo(college).get(0)).getTname();
		System.out.println("tname"+tname);
		req.getSession().setAttribute("cteacherlist",cmanagerDao.queryTeacherSelectionByMNo(college));
         return "../Cmanager_T";  
     }  

	 @RequestMapping(value="/queryst",method = RequestMethod.GET)  
     public String queryST(HttpServletRequest req) { 
		if(cmanagerDao.selectPermition()) {
			String college=((Cmanager)req.getSession().getAttribute("cmanager")).getCollege();
//			System.out.println("college"+college);
//			String cmsid=((StuSelectForCM)cmanagerDao.queryStudentSelectionByMNo(college).get(0)).getSid();
//			System.out.println("cmsid"+cmsid);
//			String cmtname=((TeaSelectForCM)cmanagerDao.queryTeacherSelectionByMNo(college).get(0)).getTname();
//			System.out.println("cmtname"+cmtname);
			
			req.getSession().setAttribute("cmstudentlist",cmanagerDao.queryStudentSelectionByMNo(college));
			req.getSession().setAttribute("cmteacherlist",cmanagerDao.queryTeacherSelectionByMNo(college));
	         return "../CManager";  
		}else
			return "../SystemClose_CM";  ////////////////////////////////////////////////////////////这里跳转至未开通界面
     }  
	 
	 @RequestMapping(value="/save",method = RequestMethod.POST)  
     public String save(CMselect cmselect ,HttpServletRequest req) { 
		 cmanagerDao.select(cmselect);
//		for(int i=0;i<cmselect.getSid().size();i++){
//			
//		}
		 return "redirect:/cmanager/queryst";  
	 }
	 @RequestMapping(value="/final",method = RequestMethod.GET)  
     public String quryfinal(HttpServletRequest req) { 
		 
		 String college=((Cmanager)req.getSession().getAttribute("cmanager")).getCollege();
		 System.out.println("college"+college);
			String fname=((Finalselected)cmanagerDao.queryFinal(college).get(0)).getStudents().get(0).getSname();
			System.out.println("fname"+fname);
		 req.getSession().setAttribute("finallist",cmanagerDao.queryFinal(college));
		 return "../Cmanager_Final";  
	 }
	/*@ResponseBody
	 @RequestMapping("/download")
		public ResponseEntity<byte[]> getImageByUID(HttpServletRequest request) {
			HttpHeaders headers = new HttpHeaders();
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
			headers.setContentDispositionFormData("attachment", file.getName());
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			ResponseEntity<byte[]> entity=null;
			try {
				entity=new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return entity;
		}*/
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
}
