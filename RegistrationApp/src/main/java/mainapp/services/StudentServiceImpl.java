package mainapp.services;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import mainapp.entities.StudentRecord;




@Repository
public class StudentServiceImpl implements StudentService {
	
	private SessionFactory sessionFactory;
	
	//Constructors
	public StudentServiceImpl() {
		super();
	}
	

	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}



	// Interface method implementations
	public List<StudentRecord> getAllStudents() {
		Session sessionObj = sessionFactory.getCurrentSession();
		Transaction tx = sessionObj.beginTransaction();
		List<StudentRecord> students = null;
		try {
			students = sessionObj.createQuery("from StudentRecord", StudentRecord.class).list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			sessionObj.close();
		}//finally-ends
		
		return students;
	}

	
	public StudentRecord getStudentById(int id) {
		
		Session sessionObj = sessionFactory.getCurrentSession();
		Transaction tx = sessionObj.beginTransaction();
		StudentRecord student = null;
		try {
			student = sessionObj.get(StudentRecord.class, id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			sessionObj.close();
		}//finally-ends
		
		return student;
	}

	public Boolean saveStudent(StudentRecord student) {
		Session sessionObj = sessionFactory.getCurrentSession();
		Transaction tx = sessionObj.beginTransaction();
		Boolean bool = false;
		
		try {
			sessionObj.saveOrUpdate(student);
			bool = true;
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			bool = false;
			tx.rollback();
		}finally {
			sessionObj.close();
		}//finally-ends
		
		
		return bool;
	}

	public Boolean deleteStudentById(int id) {
	Boolean bool = false;
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			StudentRecord student = session.get(StudentRecord.class, id);
			if(student != null) {
				session.delete(student);
				bool=true;
			}else {
				bool = false;
			}
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			bool = false;
		}finally {
			session.close();
		}
		
		return bool;
	}
	



}
