package com.example.OrderSystem;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

	public OrderRepository orderRepository ;
	
	public OrderService(OrderRepository orderRepository){
		this.orderRepository = orderRepository;
	}
	
	public Order getOrder(Long id){
		return orderRepository.findById(id).orElse(null);
	}
	
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
	public Order createOrder(String item){
		Order order = new Order();
		//order.setOrderId(124);
		order.setItem(item);
		order.setStatus("Pending");
		
		Order savedOrder = orderRepository.save(order);
		orderAsyncProcess(savedOrder.orderId);
		return savedOrder;
	}
	
	public void orderAsyncProcess(Long orderId){
		try{
			Order order = orderRepository.findById(orderId).orElse(null);
			Thread.sleep(5000);
			if(order!=null)
			{
				System.out.println("Processing order: " + orderId);
				order.setStatus("Completed");
				orderRepository.save(order);
				System.out.println("Order completed: " + orderId);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
