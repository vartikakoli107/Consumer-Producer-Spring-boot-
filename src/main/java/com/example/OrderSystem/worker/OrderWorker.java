package com.example.OrderSystem.worker;

import com.example.OrderSystem.Order;
import com.example.OrderSystem.OrderRepository;
import com.example.OrderSystem.Queue.OrderQueue;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class OrderWorker {
	
	
	public OrderQueue orderQueue;
	public OrderRepository orderRepository;
	public ExecutorService executor = Executors.newFixedThreadPool(3);
	
	public OrderWorker(OrderQueue orderQueue, OrderRepository orderRepository){
		this.orderRepository = orderRepository;
		this.orderQueue = orderQueue;
	}
	
	@PostConstruct
	public void startWorker() {
		for(int i =0; i<3; i++) {
			//sets worker0, worker1 as thread name
			executor.submit((this::run), "worker" + i);
		}
	}
	
	private void run() {
		while (true) {
			try {
			Long orderId = orderQueue.takeOrder();
				System.out.println("Processing order by Thread: "+ Thread.currentThread().getName() + ", orderId:" + orderId);
				Order order = orderRepository.findById(orderId).orElse(null);
			Thread.sleep(5000);
				if(order!=null) {
					order.setStatus("Completed");
					orderRepository.save(order);
					System.out.println("Order is Completed, orderId: " + orderId);
				}
			
			} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}
}
