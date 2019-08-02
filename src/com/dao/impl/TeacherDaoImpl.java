package com.dao.impl;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TeacherDao;
import com.entity.Managerselected;
import com.entity.Selection;
import com.entity.Student;
import com.entity.StudentInfo;
import com.entity.StudentselectedId;
import com.entity.TeaSelected;
import com.entity.Teacher;
import com.entity.Studentselected;
import com.entity.Teacherselected;
import com.entity.TeacherselectedId;

@Service("teacherDao")
@Transactional
public class TeacherDaoImpl extends HibernateDaoSupport implements TeacherDao
{

	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}
	

	@Override
	public boolean login(int tid, String tpwd) {
		List<Teacher> teacher = this.getHibernateTemplate().find("from com.entity.Teacher Where tid=?",tid);
		Teacher t = teacher.get(0);
			if(t.getTpwd().equals(tpwd)){
	    		
			return true;
		  }
			else 
				return false;
		}
		
	
	

	@Transactional
	public void update(Teacher teacher) {
		if(teacher!=null){
			this.getHibernateTemplate().update(teacher);
		}
	}


	@Override
	public String[][] query(int tid) {
		List<Studentselected> studentselecteds = this.getHibernateTemplate().
				find("from com.entity.Studentselected where id.tid = ?", tid);
		String[][] selections = new String[studentselecteds.size()][8];
		int i = 0;
		for (Studentselected studentselected : studentselecteds) {
			selections[i][0] =String.valueOf(studentselected.getId().getTid());
			selections[i][1] =studentselected.getId().getSid();
			selections[i][2] = this.getHibernateTemplate().
					get(Student.class, studentselected.getId().getSid()).getSname();
			selections[i][3] = this.getHibernateTemplate().
					get(Student.class, studentselected.getId().getSid()).getSex();
			Timestamp date=(Timestamp) this.getHibernateTemplate().
					get(Student.class, studentselected.getId().getSid()).getBirth();
			
			selections[i][4] = date.getYear()+"/"+date.getMonth()+"/"+date.getDay();
			List<Studentselected> studentselecteds2 = this.getHibernateTemplate().
					find("from com.entity.Studentselected where id.sid = ?", studentselected.getId().getSid());
			int j = 5;
			for (Studentselected studentselected2 : studentselecteds2) {
				selections[i][j] = this.getHibernateTemplate().
						get(Teacher.class, studentselected2.getId().getTid()).getTname();
				j++;
			}
			i++;
			
		}
		return selections;
	}




	@Override
	public List<Teacher> teacherBytid(int tid) {
			return (List<Teacher>)this.getHibernateTemplate().find("from com.entity.Teacher Where tid=?",tid);
		
	}


	
	@Transactional
	@Override
	public void select(TeaSelected selectinfo) {
		// TODO Auto-generated method stub
		for(int i=0;i<selectinfo.getTid().size();i++){
			int tid=Integer.parseInt(selectinfo.getTid().get(i));
		    String sid=selectinfo.getSid().get(i);
	     	int rank=Integer.parseInt(selectinfo.getRank().get(i));
		TeacherselectedId teacherselectedId = new TeacherselectedId(tid, sid);
		Date date = new Date();       
		Timestamp nousedate = new Timestamp(date.getTime());
		Teacherselected teacherselected = new Teacherselected(teacherselectedId,nousedate,rank);
		System.out.println("tid"+tid+"sid"+sid);
		List<Teacherselected> tquery = this.getHibernateTemplate().find("from com.entity.Teacherselected Where id.tid="+tid+"and id.sid="+sid);
		System.out.println("tquery"+tquery);
		
		if(tquery.size()==0){
			this.getHibernateTemplate().save(teacherselected);
		}
		else
		this.getHibernateTemplate().update(teacherselected);
		
		}
		
		
		}
	@Override
	public String[][] tselected(int tid) {
		List<Teacherselected> teacherselecteds = this.getHibernateTemplate().
				find("from com.entity.Teacherselected where id.tid = ?", tid);
		String[][] selected = new String[teacherselecteds.size()][5];
		int i = 0;
		for (Teacherselected teacherselected : teacherselecteds) {
			selected[i][0] =teacherselected.getWanted()+"";
			selected[i][1] =this.getHibernateTemplate().
					get(Student.class, teacherselected.getId().getSid()).getSname();
			selected[i][2] = this.getHibernateTemplate().
					get(Student.class, teacherselected.getId().getSid()).getSex();
			Timestamp date=(Timestamp) this.getHibernateTemplate().
					get(Student.class, teacherselected.getId().getSid()).getBirth();
			selected[i][3] = date.getYear()+"/"+date.getMonth()+"/"+date.getDay();
			selected[i][4] = this.getHibernateTemplate().
					get(Student.class, teacherselected.getId().getSid()).getTips();
			i++;
			
		}
		return selected;
	}


	public boolean selectPermition() {
		// TODO Auto-generated method stub
		Selection se = (Selection) this.getHibernateTemplate().find("from com.entity.Selection").get(0);
        
		return se.getTstate() == 0?false:true;
	}
	@Override
	public List<Student> getmyStudents(int tid) {
		// TODO Auto-generated method stub
		Managerselected ma = (Managerselected)getHibernateTemplate().find("from com.entity.Managerselected where id.tid=?", tid).get(0);
		return getHibernateTemplate().find("from com.entity.Student where sid=?",ma.getId().getSid());
	}
	
}