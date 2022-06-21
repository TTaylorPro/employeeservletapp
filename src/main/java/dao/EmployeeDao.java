package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.util.HibernateUtil;

import models.Employee;

public class EmployeeDao {
	//CRUD
	public int insert (Employee e) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(e);
		
		return pk;
		
		
	}
	
	public List<Employee> findAll(){
		Session ses = HibernateUtil.getSession();
		
		
	}
	
	public boolean delete(Employee e) {
		
	}
}
