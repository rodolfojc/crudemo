package com.springboot.crudemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.crudemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//DEFINE FIELD FOR ENTITYMANAGER
	private EntityManager entityManager;
	
	//CONTRUCTOR INJECTION
	//AUTOWIRED IS NOT REQUIRED AS THERE IS JUST ONE CONTRUCTOR
	//ENTITYMANAGER IS CREATED AUTOMATICALLY BY SPRING BOOT
	
	@Autowired
	public EmployeeDAOHibernateImpl (EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional // HANDLES TRANSACTION MANAGMENT - NO NEED OF MANUALLY START / COMMIT TRASAC.. 
	public List<Employee> findAll() {
		
		// GET CURRENT HIBERNATE SESSION
		Session currentSession = this.entityManager.unwrap(Session.class);
		
		// CREATE QUERY
		Query<Employee> theQuery = currentSession.createQuery("from employee", Employee.class);
		
		// EXECUTE THE QUERY AND GET THE RESULT LIST
		List<Employee> employees = theQuery.getResultList();
		
		// RETURN THE RESULT 
	
		return employees;
	}

}
