package com.example.OrderSystem;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
	public OrderService orderService;
	
	public OrderController(OrderService orderService){
		this.orderService = orderService;
	}
	
	@PostMapping
	public Order postOrder(@RequestParam String item){
		return orderService.createOrder(item);
	}
	
	@GetMapping("/{id}")
	public Order getOrder(@PathVariable Long id)
	{
		return orderService.getOrder(id);
	}
	
	@GetMapping
	public List<Order> getAllOrder()
	{
		return orderService.getAllOrders();
	}
	
}
