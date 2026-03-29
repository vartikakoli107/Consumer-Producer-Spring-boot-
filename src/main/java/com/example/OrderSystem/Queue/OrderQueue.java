package com.example.OrderSystem.Queue;

import com.example.OrderSystem.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class OrderQueue {
	
	public BlockingQueue<Long> queue = new LinkedBlockingQueue<>();
	
	public void addOrder(Long id){
		queue.offer(id);
	}
	
	public Long takeOrder() throws InterruptedException {
		return queue.take(); //wait if empty
	}
}
