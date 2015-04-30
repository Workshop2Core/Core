package com.javatrainee.batch27.service;

import java.util.List;

import com.javatrainee.batch27.entity.OrderHistory;

public interface OrderHistoryService {
	public List<OrderHistory> findAll();
	public OrderHistory findById(long idOrder);
	public void insert(OrderHistory orderHistory);
	public void update(long idOrder, OrderHistory orderHistory);
	public void delete(long idOrder);
	
}
