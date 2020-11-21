package sh.services;

import java.util.List;

import sh.entities.Orders;

public interface OrderService {

	void addOrder(Orders order);

	Orders fetchOrderById(int id);

	List<Orders> fetchOrderByTime();

}