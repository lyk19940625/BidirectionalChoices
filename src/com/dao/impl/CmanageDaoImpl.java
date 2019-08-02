package com.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CManagerDao;
import com.entity.CMselect;
import com.entity.Cmanager;
import com.entity.Finalselected;
import com.entity.Major;
import com.entity.Managerselected;
import com.entity.ManagerselectedId;
import com.entity.Selection;
import com.entity.StuSelectForCM;
import com.entity.Student;
import com.entity.Studentselected;
import com.entity.TeaSelectForCM;
import com.entity.Teacher;
import com.entity.Teacherselected;
import com.entity.TeacherselectedId;
import com.util.ExclUtil;

@Service("cmanagerDao")
@Transactional
public class CmanageDaoImpl extends HibernateDaoSupport implements CManagerDao {
	

	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public List<Cmanager> cmanagerBycid(int cid) {
		return (List<Cmanager>)this.getHibernateTemplate().find("from com.entity.Cmanager Where cid=?",cid);
	}
	
	@Override
	public boolean login(int cid, String cpwd) {
		// TODO Auto-generated method stub
		Cmanager cmanager;
		try {
			cmanager = this.getHibernateTemplate().get(Cmanager.class, cid);
		} catch (Exception e) {
			return false;
		}
		return cmanager.getCpwd().equals(cpwd)?true:false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StuSelectForCM> queryStudentSelectionByMNo(String college) {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		List<Major> majors =  this.getHibernateTemplate().find("from com.entity.Major where college=?",college);	
		for (Major major : majors) {
			List<Student> students1 = this.getHibernateTemplate().find("from com.entity.Student where mno=?",major.getMno());	
			for (Student student : students1) {
				students.add(student);
			}
		}
		List<StuSelectForCM> selectForCMs = new ArrayList<>();
		for (Student student : students) {
			List<Studentselected> studentselecteds = this.getHibernateTemplate().
					find("from com.entity.Studentselected where id.sid=? order by wanted asc", student.getSid());	
			List<String> wanted = new ArrayList<>() ;
            for (Studentselected studentselected : studentselecteds) {
            	Teacher teacher = getHibernateTemplate().get(Teacher.class, studentselected.getId().getTid());
            	wanted.add(teacher.getTname());
			}
			List<Teacher> teachers = new ArrayList<Teacher>();
			List<Teacherselected> teacherselecteds = getHibernateTemplate().
					find("from com.entity.Teacherselected where id.sid=? order by time asc",student.getSid());
			for (Teacherselected teacherselected : teacherselecteds) {
				teachers.add(getHibernateTemplate().get(Teacher.class, teacherselected.getId().getTid()));
			}
			StuSelectForCM	stuSelectForCM = new StuSelectForCM(student.getSid(), student.getSname(), wanted, teachers);
			selectForCMs.add(stuSelectForCM);
		}
		return selectForCMs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeaSelectForCM> queryTeacherSelectionByMNo(String college) {
		// TODO Auto-generated method stub
		List<Teacher> teachers = new ArrayList<Teacher>();
		List<Major> majors =  this.getHibernateTemplate().find("from com.entity.Major where college=?",college);	
		for (Major major : majors) {
			List<Teacher> teachers1 = this.getHibernateTemplate().find("from com.entity.Teacher where mno=?",major.getMno());	
			for (Teacher teacher : teachers1) {
				teachers.add(teacher);
			}
		}
		List<TeaSelectForCM> selectForCMs = new ArrayList<TeaSelectForCM>();
		for (Teacher teacher : teachers) {		
			List<Student> students = new ArrayList<Student>();
			List<Teacherselected> teacherselecteds = getHibernateTemplate().
					find("from com.entity.Teacherselected where id.tid=? order by wanted asc",teacher.getTid());
			for (Teacherselected teacherselected : teacherselecteds) {
				students.add(getHibernateTemplate().get(Student.class, teacherselected.getId().getSid()));
			}
			TeaSelectForCM	teaSelectForCM = new TeaSelectForCM(teacher.getTid(), teacher.getTname(), students, 0);
			selectForCMs.add(teaSelectForCM);
		}
		return selectForCMs;
	}

	@Override
	public boolean finalselect(String[][] finalselections) {
		// TODO Auto-generated method stub
		try {
			for (String[] strings : finalselections) {
				ManagerselectedId managerselectedId = new ManagerselectedId(Integer.parseInt(strings[0]), strings[1]);
				Managerselected managerselected = new Managerselected(managerselectedId);
				this.getHibernateTemplate().save(managerselected);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String exportSelectionByMNo(String college) {
		// TODO Auto-generated method stub
		List<Major> majors = this.getHibernateTemplate().find("from com.entity.Major where college=?", college);
		int count = 0;
		for (Major major : majors) {
			String hql = "select count(*) from com.entity.Teacher where mno='"+major.getMno()+"'";
			count += (Integer)this.getHibernateTemplate().iterate(hql).next();
		}
		List<Managerselected> managerselecteds = this.getHibernateTemplate().find("from com.entity.Managerselected");
		String[][] selection = new String[count][4];
		int i = 0, j = 1; 
		for (Managerselected managerselected : managerselecteds) {
			Teacher teacher = (Teacher)this.getHibernateTemplate().get(Teacher.class, managerselected.getId().getTid());
			Student student = (Student)this.getHibernateTemplate().get(Student.class, managerselected.getId().getSid());
			if (selection[i][0] == null) {
				selection[i][0] = teacher.getTname();
				selection[i][j] = student.getSname();
				j++;
			}else {
				if(selection[i][0].equals(teacher.getTname())){
					selection[i][j] = student.getSname();
					j++;
				} else {
					i++;
					selection[i][0] = teacher.getTname();
					selection[i][1] = student.getSname();
					j = 2;
				}	
			}
		}
		Date date = new Date();
		String string = date.getYear()+"/"+date.getMonth()+"/"+date.getDay()+"_"+college+"师生关系确认表.xls";
		String path = this.getClass().getResource("/").getPath() + string;
		ExclUtil.writeExcel(selection, path);
		return path;
	}

	@Override
	public void select(CMselect cmanagerselect) {
		// TODO Auto-generated method stub
		for(int i=0;i<cmanagerselect.getTid().size();i++){
			int tid=Integer.parseInt(cmanagerselect.getTid().get(i));
		    String sid=cmanagerselect.getSid().get(i);
		    ManagerselectedId managerselectedId = new ManagerselectedId(tid, sid);
		    Managerselected managerselected = new Managerselected(managerselectedId);
			this.getHibernateTemplate().save(managerselected);
			
		}
		
	}

	@Override
    public boolean selectPermition() {
		// TODO Auto-generated method stub
		Selection se = (Selection) this.getHibernateTemplate().find("from com.entity.Selection").get(0);
        
		return se.getCstate() == 0?false:true;
	}

	@Override
	public List<Finalselected> queryFinal(String college) {
		// TODO Auto-generated method stub
				List<Teacher> teachers = new ArrayList<Teacher>();
				List<Major> majors =  this.getHibernateTemplate().find("from com.entity.Major where college=?",college);	
				for (Major major : majors) {
					List<Teacher> teachers1 = this.getHibernateTemplate().find("from com.entity.Teacher where mno=?",major.getMno());	
					for (Teacher teacher : teachers1) {
						teachers.add(teacher);
					}
				}
				List<Finalselected> finalselected = new ArrayList<Finalselected>();
				for (Teacher teacher : teachers) {		
					List<Student> students = new ArrayList<Student>();
					List<Managerselected> managerselecteds = getHibernateTemplate().
							find("from com.entity.Managerselected where id.tid=?",teacher.getTid());
					for (Managerselected managerselected : managerselecteds) {
						students.add(getHibernateTemplate().get(Student.class, managerselected.getId().getSid()));
					}
					Finalselected	finalselect = new Finalselected(teacher.getTid(), teacher.getTname(), students);
					finalselected.add(finalselect);
				}
				return finalselected;
	}

}
