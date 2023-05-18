package lap3;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {
	OrderDetail or = new OrderDetail();
	public String description;
	public String productId;
	public double price;
	
	private ArrayList<Product> p;
	public Product() {
		this.p = new ArrayList<>();
	}
	public Product(ArrayList<Product> p) {
		this.p = p;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public void add(Product product) {
		this.p.add(product);
		
	}
	public Product(String description,String productID,double price) {
		this.description = description;
		this.price = price;
		this.productId = productID;
	}
	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return price;
	}
	public String getProductId() {
		return productId;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void nhapq() {
		for(int i = 0;i < or.quatity;i++) {
		Scanner sc = new Scanner(System.in);
		System.out.println("mo ta");
		description = sc.nextLine();
		System.out.println("id");
		productId = sc.nextLine();
		System.out.println("gia");
		price = sc.nextDouble();
		}
	}
}
