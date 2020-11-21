package sh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sh.dao.LoginDao;
import sh.entities.Customers;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao dao;
	
	@Transactional
	@Override
	public void addCustomer(Customers c) {
		dao.addCustomer(c);
	}
	
	@Transactional
	@Override
	public Customers fetchCustomer(String email) {
		return dao.fetchCustomer(email);
	}
	
	@Transactional
	@Override
	public Customers findCustomer(String email, String password) {
		Customers customer = fetchCustomer(email);
		if (customer != null && customer.getPassword().equals(password))
			return customer;
		return null;
	}
	
}
