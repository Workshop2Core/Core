package com.javatrainee.batch27.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatrainee.batch27.entity.OrderHistory;
import com.javatrainee.batch27.repo.OrderHistoryRepo;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

	@Autowired
	private OrderHistoryRepo orderHistoryRepo;
	
	@Override
	public List<OrderHistory> findAll() {
		// TODO Auto-generated method stub
		return orderHistoryRepo.findAll();
	}

	@Override
	public OrderHistory findOrderHistoryByOrderId(long orderId) {
		// TODO Auto-generated method stub
		return orderHistoryRepo.findOne(orderId);
	}

	@Override
	public void insert(OrderHistory orderHistory) {
		// TODO Auto-generated method stub
		orderHistoryRepo.save(orderHistory);
	}



}
