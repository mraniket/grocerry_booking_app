package com.qpassessment.qpgrocery.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.qpassessment.qpgrocery.model.Employee;

@Repository
public class EmployeeDao {

	private final SessionFactory sessionFactory;

	@Autowired
	public EmployeeDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Employee saveUser(Employee emp) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
//	    CriteriaBuilder builder = session.getCriteriaBuilder();
//		session.save(emp);
		System.out.println(emp.toString());
		session.saveOrUpdate("Employee", emp);
		session.getTransaction().commit();
		session.close();
		return emp;

	}
	
	public Employee getEmployee(Employee emp) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery <Employee>  query =  builder.createQuery(Employee.class);
	    
	    
//        Root<GroceryItem> root = query.from(GroceryItem.class);
//        // Step 6: Add conditions (e.g., filtering by a specific name)
//        Predicate condition = builder.equal(root.get("name"), "Apple");
//        query.select(root).where(condition);
//        // Step 7: Execute the query and fetch results
//        List<GroceryItem> items = session.createQuery(query).getResultList();

	   
		session.close();
		return emp;

	}

}
