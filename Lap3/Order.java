package lap3;

import java.time.LocalDate;

public class Order {
	public int orderId;
	public LocalDate orderDate;
	public OrderDetail lineItems;
	public int count;
	
	public Order(int orderId,LocalDate orderDate) {
		// TODO Auto-generated constructor stub
		super();
		this.orderDate = orderDate;
		this.orderId = orderId;
	}
	public Order() {
		
	}
	public OrderDetail getLineItems() {
		return lineItems;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	public void addLineItem(Product p,int q) {
		lineItems.add(new OrderDetail(p,q));
	}
	public double calcTotalCharge(int q) {
		double count =0;
		int i;
		for(i =0 ; i < q ; i++) {
			count += lineItems.calcTotalPrice();
		}
		return count;
	}
}
