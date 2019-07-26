package application;

import java.util.Date;

import entities.Order;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		
		Order order = new Order(100, new Date(), OrderStatus.PENDING_PAYMENT);
		
		System.out.println(order);
	}
	
}
