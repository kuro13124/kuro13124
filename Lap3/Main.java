package lap3;

public class Main {

	public static void main(String[] args) {
		OrderDetail or = new OrderDetail();
		Order o = new Order();
		Product p = new Product();
		or.nhap();
		or.add(or);
		p.nhapq();	
		p.add(p);
		o.addLineItem(or.product,or.quatity);
		or.display();
	}
}
