package sh.dao;

import sh.entities.Customers;

public interface LoginDao {

	void addCustomer(Customers c);

	Customers fetchCustomer(String email);

}