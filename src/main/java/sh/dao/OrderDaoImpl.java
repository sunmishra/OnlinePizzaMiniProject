package sh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sh.entities.Orders;

@Repository
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public void addOrder(Orders order) {
		Session session = sf.getCurrentSession();
		session.persist(order);
	}
	
	@Override
	public Orders fetchOrderById(int id) {
		Session session = sf.getCurrentSession();
		return session.find(Orders.class, id);
	}
	
	@Override
	public List<Orders> fetchOrderByTime(){
		Session session = sf.getCurrentSession();
		String hql = "from "+Orders.class.getName()+" o order by o.orderTime desc";
		Query<Orders> q = session.createQuery(hql); 
		return q.getResultList();
	}
	
	
}
