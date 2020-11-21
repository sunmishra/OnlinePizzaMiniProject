package sh.dao;

import java.util.List;

import sh.entities.Items;
import sh.entities.Pricing;
import sh.entities.SizeandPrice;

public interface MenuDao {

	List<Items> fetchByVegItems();

	List<Items> fetchByNonVegItems();

	List<Items> fetchByTypeAndCat();

	List<Items> fetchByCat();

	Items fetchById(int id);

	Pricing fetchByItemPrice(int id);

	public SizeandPrice pricing_size(Pricing p);

}