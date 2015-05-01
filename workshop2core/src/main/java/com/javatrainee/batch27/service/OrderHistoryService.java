package com.javatrainee.batch27.service;

import java.util.List;

import com.javatrainee.batch27.entity.OrderHistory;

public interface OrderHistoryService {
	
	//path : workshop2/orderHistory
	public List<OrderHistory> findAll();							//-->getAll
	public OrderHistory findOrderHistoryByOrderId(long orderId);	//-->getOrderHistoryByOrderId/{orderId}
	public void insert(OrderHistory orderHistory);					//-->insert
	
}
