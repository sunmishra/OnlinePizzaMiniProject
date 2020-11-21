package sh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PIZZA_PRICING")
public class Pricing {
	@Id
	@Column(name = "ID")
	private int pId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ITEMID")
	private Items itemId;
	@Column(name = "SIZES")
	private String size;
	@Column(name = "Price")
	private double price;
	
	public Pricing() {
	}
	public Pricing(int pId, Items itemId, String size, double price) {
		this.pId = pId;
		this.itemId = itemId;
		this.size = size;
		this.price = price;
	}
	
	public int getId() {
		return pId;
	}
	public void setId(int id) {
		this.pId = id;
	}
	public Items getItemId() {
		return itemId;
	}
	public void setItemId(Items items) {
		this.itemId = items;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Pricing [pId=" + pId + ", itemId=" + itemId + ", size=" + size + ", price=" + price + "]";
	}		
}
