package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.StudentDao;
import com.entity.Managerselected;
import com.entity.Selection;
import com.entity.Student;
import com.entity.Studentselected;
import com.entity.StudentselectedId;
import com.entity.Teacher;


@Service("studentDao")
@Transactional
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao
{

	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public List<Student> studentBysid(String sid) {
		return (List<Student>)this.getHibernateTemplate().find("from com.entity.Student Where sid=?",sid);
	}
	@Override
	public boolean login(String sid, String spwd) {
	List<Student> student = this.getHibernateTemplate().find("from com.entity.Student Where sid=?",sid);
	Student s = student.get(0);
	System.out.println("student"+s);
		if(s.getSpwd().equals(spwd)){
    		
		return true;
	  }
		else 
			return false;
	}
	
	

	@Transactional
	public void update(Student student) {
		if(student!=null){
			this.getHibernateTemplate().update(student);
		}
	}

	
	@Override
	public List<Teacher> teacherBymno(int mno) {
		return (List<Teacher>)this.getHibernateTemplate().find("from com.entity.Teacher Where mno=?",mno);
	}
	
	@Transactional
	@Override
	public void select(List<String> ids) {
		// TODO Auto-generated method stub
		for (int i = 1; i < ids.size(); i++) {
			StudentselectedId studentselectedId = new StudentselectedId(ids.get(0), Integer.parseInt(ids.get(i)));
			Studentselected studentselected = new Studentselected(studentselectedId, i);
			System.out.println("ssdas         "+i);
			this.getHibernateTemplate().save(studentselected);
		}
		
		}
	@Override
	public List<String> selectwanted(String sid) {
		List<Studentselected> studentselecteds = this.getHibernateTemplate().find("from com.entity.Studentselected Where sid=?",sid);
		
		List<String> wanted =new ArrayList<String>();
		for(Studentselected studentselected : studentselecteds) {
			wanted.add(this.getHibernateTemplate().get(Teacher.class, studentselected.getId().getTid()).getTname());
		}
		return wanted;
	}

	@Override
	public boolean selectPermition() {
		// TODO Auto-generated method stub
		Selection se = (Selection) this.getHibernateTemplate().find("from com.entity.Selection").get(0);
        
		return se.getState() == 0?false:true;
	}

	@Override
	public Teacher getMyTeacher(String sid) {
		// TODO Auto-generated method stub
		Managerselected ma = (Managerselected)getHibernateTemplate().find("from com.entity.Managerselected where id.sid=?", sid).get(0);
		return getHibernateTemplate().get(Teacher.class, ma.getId().getTid());
	}

}