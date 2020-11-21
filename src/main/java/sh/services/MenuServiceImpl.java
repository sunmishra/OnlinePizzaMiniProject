package sh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sh.dao.MenuDao;
import sh.entities.Items;
import sh.entities.Pricing;
import sh.entities.SizeandPrice;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao dao;

	@Transactional
	@Override
	public List<Items> fetchByVegItems( ){
		return dao.fetchByVegItems( );
	}
	
	@Transactional
	@Override
	public List<Items> fetchByNonVegItems( ){
		return dao.fetchByNonVegItems( );
	}
	
	@Transactional
	@Override
	public List<Items> fetchByTypeAndCat(){
		return dao.fetchByTypeAndCat();
	}
	
	@Transactional
	@Override
	public List<Items> fetchByCat(){
		return dao.fetchByCat();
	}
	
	@Transactional
	@Override
	public Items fetchById(int id){
		return dao.fetchById(id);
	}
	
	@Transactional
	@Override
	public Pricing fetchByItemPrice(int id){
		return dao.fetchByItemPrice(id);
	}

	@Override
	public SizeandPrice pricing_size(Pricing p) {
		return dao.pricing_size(p);
	}
	
}
