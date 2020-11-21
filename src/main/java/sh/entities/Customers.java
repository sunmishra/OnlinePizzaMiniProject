package sh.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_CUSTOMERS")
public class Customers {
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Password")
	private String password;
	@Column(name = "Mobile")
	private String mobile;
	@Column(name = "Address")
	private String address;
	@Column(name = "Email")
	private String email;
	
	@OneToMany(mappedBy = "orderId", fetch = FetchType.EAGER)
	private List<Orders> orderList;
	
	public Customers() {
		this.orderList = new ArrayList<Orders>();
	}
	
	public Customers(int id, String name, String password, String mobile, String address, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.orderList = new ArrayList<Orders>();
	}

	public List<Orders> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Orders> orderList) {
		this.orderList = orderList;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", name=" + name + ", password=" + password + ", mobile=" + mobile + ", address="
				+ address + ", email=" + email + "]";
	}
	
	
}
