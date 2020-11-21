package sh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sh.entities.Items;
import sh.entities.Pricing;
import sh.entities.SizeandPrice;

@Repository
public class MenuDaoImpl implements MenuDao {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Items> fetchByVegItems( ) {
		Session session = sf.getCurrentSession();
		String hql = String.format("from %s t where t.type=:t_type ", Items.class.getName());
		Query<Items> q = session.createQuery(hql);
		q.setParameter("t_type", "Veg");
		return q.getResultList();
	}
	
	@Override
	public List<Items> fetchByNonVegItems( ) {
		Session session = sf.getCurrentSession();
		String hql = String.format("from %s t where t.type=:t_type ", Items.class.getName());
		Query<Items> q = session.createQuery(hql);
		q.setParameter("t_type", "NonVeg");
		return q.getResultList();
	}
	
	@Override
	public List<Items> fetchByTypeAndCat(){
		Session session = sf.getCurrentSession();
		String hql = String.format("from %s tc where tc.type=:t_type and tc.category=:t_category ", Items.class.getName());
		Query<Items> q = session.createQuery(hql);
		q.setParameter("t_type", "Veg");
		q.setParameter("t_category", "Veg Feast");
		return q.getResultList();
	}
	
	@Override
	public List<Items> fetchByCat(){
		Session session = sf.getCurrentSession();
		String hql = String.format("from %s cat where cat.category=:cat_category ", Items.class.getName());
		Query<Items> q = session.createQuery(hql);
		q.setParameter("cat_category", "Sides");
		return q.getResultList();
	}
	
	@Override
	public Items fetchById(int id){
		Session session = sf.getCurrentSession();
		String hql = String.format("from %s i where i.id=:i_id ", Items.class.getName());
		Query q = session.createQuery(hql);
		q.setParameter("i_id", id);
		return (Items)q.getSingleResult();
		//return (Items)q.list().get(0);
	}
	
	@Override
	public Pricing fetchByItemPrice(int id){
		Session session = sf.getCurrentSession();
		String hql = String.format("from %s p where p.id=:p_id ", Pricing.class.getName());
		Query q = session.createQuery(hql);
		q.setParameter("p_id", id);
		return (Pricing)q.list().get(0);
		
	}
	
	
	@Override
	public SizeandPrice pricing_size(Pricing p) {
		SizeandPrice sp = new SizeandPrice();
		sp.setId(p.getId());
		sp.setPrice(p.getPrice());
		sp.setSize(p.getSize());
		return sp;
	}
	
//	public void priceList(List<Pricing> prices) {
//		Session session = sf.getCurrentSession();
//		List<SizeandPrice> list = new ArrayList<SizeandPrice>();
//		SizeandPrice sp = new SizeandPrice();
//		for(Pricing price : prices) {
//			list.add(sp.setPrice(price.getPrice()) );
//		}
//	}
	
	
}
