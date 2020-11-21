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
@Table(name = "PIZZA_ITEMS")
public class Items {
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Type")
	private String type;
	@Column(name = "Category")
	private String category;
	@Column(name = "Description")
	private String description;
	@OneToMany(mappedBy = "itemId", fetch = FetchType.EAGER)
	private List<Pricing> pricingList;
	
	public Items() {
		this.pricingList = new ArrayList<>();
	}
	
	public Items(int id, String name, String type, String category, String description) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.category = category;
		this.description = description;
		this.pricingList = new ArrayList<>();
	}
	
	
	public List<Pricing> getPricingList() {
		return pricingList;
	}

	public void setPricingList(List<Pricing> pricingList) {
		this.pricingList = pricingList;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", type=" + type + ", category=" + category + ", description="
				+ description + "]";
	}


	
	
}
