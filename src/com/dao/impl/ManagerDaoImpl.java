package com.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ManagerDao;
import com.entity.Cmanager;
import com.entity.Finalselected;
import com.entity.Major;
import com.entity.Manager;
import com.entity.Managerselected;
import com.entity.Selection;
import com.entity.Student;
import com.entity.Teacher;
import com.entity.Teacherselected;
import com.util.ExclUtil;

@Service("managerDao")
@Transactional
public class ManagerDaoImpl extends HibernateDaoSupport implements ManagerDao {

	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public boolean login(int mid, String mpwd) {
		// TODO Auto-generated method stub
		Manager manager = null;
		try {
			manager = this.getHibernateTemplate().get(Manager.class, mid);
		} catch (Exception e) {
			return false;
		}
		return manager.getMpwd().equals(mpwd)?true:false;
	}

	@Override
	public boolean importStudent(List<Student> students) {
		// TODO Auto-generated method stub
		try {
			for (Student student : students) {
				this.getHibernateTemplate().save(student);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean importTeacher(List<Teacher> teachers) {
		// TODO Auto-generated method stub
		try {
			for (Teacher teacher : teachers) {
				this.getHibernateTemplate().save(teacher);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(student);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(teacher);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(student);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(teacher);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Student queryStudentById(String sid) {
		// TODO Auto-generated method stub
		return (Student)this.getHibernateTemplate().get(Student.class, sid);
	}

	@Override
	public Teacher queryTeacherById(int tid) {
		// TODO Auto-generated method stub
		return (Teacher)this.getHibernateTemplate().get(Teacher.class, tid);
	}

	@Override
	public Cmanager queryCmanagerById(int cid) {
		// TODO Auto-generated method stub
		return (Cmanager)this.getHibernateTemplate().get(Cmanager.class, cid);
	}

	@Override
	public boolean update(Cmanager cmanager) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(cmanager);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Cmanager cmanager) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(cmanager);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	@Override
	public Major queryMajorByNo(int no) {
		// TODO Auto-generated method stub
		return (Major)this.getHibernateTemplate().get(Major.class, no);
	}

	@Override
	public boolean addMajor(Major major) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(major);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteMajor(Major major) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().delete(major);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateMajor(Major major) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(major);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String[][] querySelection() {
		// TODO Auto-generated method stub
		//String hql = "select count(*) from com.entity.Managerselected as id.tid";
		//int count = (Integer)this.getHibernateTemplate().iterate(hql).next();
		List<Teacher> teachers = this.getHibernateTemplate().find("from com.entity.Teacher");	
		String[][] selections = new String[teachers.size()][4];
		for (Teacher teacher : teachers) {
			List<Managerselected> managerselecteds = this.getHibernateTemplate().
					find("from com.entity.Managerselected where id.tid=?", teacher.getTid());
			int i = 0;
			for (Managerselected managerselected : managerselecteds) {
				if (selections[i][0] == null || !selections[i][0].equals(teacher.getTname())) {
					selections[i][0] = teacher.getTname();
				}
				List<Student> students = this.getHibernateTemplate().
						find("from com.entity.Student where sid=?", managerselected.getId().getSid());
				int j = 1;
				for (Student student : students) {
					selections[i][j] = student.getSname();
					j++;
				}
				i++;
			}
		}
		return selections;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String[][] querySelectionByMNo(int mno) {
		// TODO Auto-generated method stub
		List<Teacher> teachers = this.getHibernateTemplate().
				find("from com.entity.Teacher where mno=?", mno);
		String[][] selections = new String[teachers.size()][4];
		for (Teacher teacher : teachers) {
			List<Managerselected> managerselecteds = this.getHibernateTemplate().
					find("from com.entity.Managerselected where id.tid=?", teacher.getTid());
			int i = 0;
			for (Managerselected managerselected : managerselecteds) {
				if (selections[i][0] == null || !selections[i][0].equals(teacher.getTname())) {
					selections[i][0] = teacher.getTname();
				}
				List<Student> students = this.getHibernateTemplate().
						find("from com.entity.Student where sid=?", managerselected.getId().getSid());
				int j = 1;
				for (Student student : students) {
					selections[i][j] = student.getSname();
					j++;
				}
				i++;
			}
		}
		return selections;
	}

	@Override
	public String exportSelection() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from com.entity.Teacher";
		int count = (Integer)this.getHibernateTemplate().iterate(hql).next();
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
		String string = date.getYear()+"/"+date.getMonth()+"/"+date.getDay()+"_"+"师生关系确认表.xls";
		String path = this.getClass().getResource("/").getPath() + string;
		ExclUtil.writeExcel(selection, path);
		return path;
	}

	@Override
	public String exportSelectionByMNo(int mno) {
		// TODO Auto-generated method stub
		Major major = this.getHibernateTemplate().get(Major.class, mno);
		String hql = "select count(*) from com.entity.Teacher where mno='"+mno+"'";
		int count = (Integer)this.getHibernateTemplate().iterate(hql).next();
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
		String string = date.getYear()+"/"+date.getMonth()+"/"+date.getDay()+"_"+major.getMname()+"专业师生关系确认表.xls";
		String path = this.getClass().getResource("/").getPath() + string;
		ExclUtil.writeExcel(selection, path);
		return path;
	}

	@Override
	public void openSelection() {
		// TODO Auto-generated method stub
		Selection selection = (Selection)this.getHibernateTemplate().get(Selection.class,1);
		selection.setState(1);
		selection.setCstate(0);
		selection.setTstate(0);
		this.getHibernateTemplate().update(selection);
	}

	@Override
	public void closeSelection() {
		// TODO Auto-generated method stub
		Selection selection = (Selection)this.getHibernateTemplate().get(Selection.class,1);
		selection.setState(0);
		this.getHibernateTemplate().update(selection);
	}

	@Override
	public void openCManagement() {
		// TODO Auto-generated method stub
		Selection selection = (Selection)this.getHibernateTemplate().get(Selection.class,1);
		selection.setState(0);
		selection.setCstate(1);
		selection.setTstate(0);
		this.getHibernateTemplate().update(selection);
	}

	@Override
	public void closeCManagement() {
		// TODO Auto-generated method stub
		Selection selection = (Selection)this.getHibernateTemplate().get(Selection.class,1);
		selection.setCstate(0);
		this.getHibernateTemplate().update(selection);
	}

	@Override
	public List<Major> queryMajor() {
		// TODO Auto-generated method stub
		 return this.getHibernateTemplate().find("from com.entity.Major");
	}

	@Override
	public List<Student> qstudent(int mno) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from com.entity.Student Where mno=?",mno);
	}

	@Override
	public List<Teacher> qteacher(int mno) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from com.entity.Teacher Where mno=?",mno);
	}

	@Override
	public List<Cmanager> qcmanager() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from com.entity.Cmanager");
	}

	@Override
	public void closeTSelection() {
		// TODO Auto-generated method stub
		Selection selection = (Selection)this.getHibernateTemplate().get(Selection.class,1);
		selection.setTstate(0);
		this.getHibernateTemplate().update(selection);
	
	}

	@Override
	public void openTSelection() {
		// TODO Auto-generated method stub
		Selection selection = (Selection)this.getHibernateTemplate().get(Selection.class,1);
		selection.setState(0);
		selection.setCstate(0);
		selection.setTstate(1);
		this.getHibernateTemplate().update(selection);
	}

	@Override
	public void savestudent(Student student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(student);
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
