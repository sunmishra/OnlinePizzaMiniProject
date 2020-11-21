package sh.entities;


import java.util.ArrayList;
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
@Table(name = "PIZZA_ORDERDETAILS")
public class OrderDetails {
	@Id
	@Column(name = "ID")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OrderId")
	private Orders order;
	@Column(name = "PRICEID")
	private int priceId;
	@OneToMany(mappedBy = "pId")
	private List<Pricing> list ;
	
	public OrderDetails() {
		this.order = new Orders();
		this.list = new ArrayList<>();
	}
	
	public OrderDetails(int id, int priceId) {
		this.order = new Orders();
		this.id = id;
		this.priceId = priceId;
		this.list = new ArrayList<>();
	}

	public List<Pricing> getList() {
		return list;
	}

	public void setList(List<Pricing> list) {
		this.list = list;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPriceId() {
		return priceId;
	}
	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	@Override
	public String toString() {
		return "OrderDetails [Id=" + id +  ", priceId=" + priceId + "]";
	}
	
	
}
