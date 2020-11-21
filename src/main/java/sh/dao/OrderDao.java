package sh.dao;

import java.util.List;

import sh.entities.Orders;

public interface OrderDao {

	void addOrder(Orders order);

	Orders fetchOrderById(int id);

	List<Orders> fetchOrderByTime();

}