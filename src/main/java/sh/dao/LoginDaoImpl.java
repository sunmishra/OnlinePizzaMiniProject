package sh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sh.entities.Customers;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public void addCustomer(Customers c) {
		Session session = sf.getCurrentSession();
		session.persist(c);
		System.out.println("Customer added");
	}
	
	@Override
	public Customers fetchCustomer(String email) {
		Session session = sf.getCurrentSession();
		String hql = String.format("from %s e where e.email=:e_email", Customers.class.getName());
		Query q = session.createQuery(hql);
		q.setParameter("e_email", email);
		//return (Customers) q.list().get(0);
		return (Customers) q.getSingleResult();
	}
	
}
