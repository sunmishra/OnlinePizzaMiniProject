package sh.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA_ORDERS")
public class Orders {
	@Id
	@Column(name = "ID")
	private int orderId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CustomerId")
	private Customers customer;
	@Column(name = "OrderTime")
	private Date orderTime;
	@Column(name = "STATUS")
	private String status;
	@OneToMany(mappedBy = "id")
	private List<OrderDetails> list;
	
	public Orders() {
		this.customer = new Customers();
		this.list = new ArrayList<>();
	}
	
	public Orders(int orderId, int customerId, Date orderTime, String status) {
		this.customer = new Customers();
		this.orderId = orderId;
		this.orderTime = orderTime;
		this.status = status;
		this.list = new ArrayList<>();
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<OrderDetails> getList() {
		return list;
	}

	public void setList(List<OrderDetails> list) {
		this.list = list;
	}

	public int getorderId() {
		return orderId;
	}
	public void setorderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId +  ", orderTime=" + orderTime + ", status=" + status
				+ "]";
	}
	
	
}
