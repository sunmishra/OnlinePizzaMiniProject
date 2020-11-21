package sh.entities;

public class SizeandPrice {
	private int id;
	private double price;
	private String size;
	public SizeandPrice() {
	}
	public SizeandPrice(int id, double price, String size) {
		this.id = id;
		this.price = price;
		this.size = size;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "SizeandPrice [Id="+ id + ", price" + price + ", size=" + size + "]";
	}
	
	
}
