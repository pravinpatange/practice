package com.app;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		
//		//save
//		Employee e = new Employee();
//		e.setName("Mahadev");
//		e.setDepartment("Civil");
//		session.save(e);
		
//		Query query=session.createNamedQuery("myQuery1");
//		query.setParameter("department", "IE");
//		
//		Employee result = (Employee) query.getSingleResult();
//		System.out.println(result);
		
		
		TypedQuery query = session.createNamedQuery("myQuery1");
		query.setParameter("department", "R&D");
		
		List<Employee> l= query.getResultList();
		Iterator<Employee> itr = l.iterator();
		if(itr.hasNext())
		{
			while(itr.hasNext())
			{
				Employee e =itr.next();
				System.out.println(e);
			}
		}
		else
		{
			System.out.println("not found");
		}
		
		
//		try
//		{
//			List<Employee> l= query.getResultList();
//			Iterator<Employee> itr = l.iterator();
//			while(itr.hasNext())
//			{
//				Employee e =itr.next();
//				System.out.println(e);
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("Error");
//		}
		
		session.getTransaction().commit();
		System.out.println("Success");
	}
}
