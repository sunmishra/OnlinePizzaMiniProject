package sh.services;

import sh.entities.Customers;

public interface LoginService {

	void addCustomer(Customers c);

	Customers fetchCustomer(String email);
	
	Customers findCustomer(String email, String password);

}