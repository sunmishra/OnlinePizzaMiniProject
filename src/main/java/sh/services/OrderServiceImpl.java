package sh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sh.dao.OrderDao;
import sh.entities.Orders;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao dao;
	
	@Transactional
	@Override
	public void addOrder(Orders order) {
		dao.addOrder(order);
	}
	
	@Transactional
	@Override
	public Orders fetchOrderById(int id) {
		return dao.fetchOrderById(id);
	}
	
	@Transactional
	@Override
	public List<Orders> fetchOrderByTime(){
		return dao.fetchOrderByTime();
	}
}

