package com.javatrainee.batch27.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatrainee.batch27.entity.OrderHistory;
import com.javatrainee.batch27.repo.OrderHistoryRepo;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

	@Autowired
	private OrderHistoryRepo orderHistoryRepo;
	
	@Override
	public OrderHistory findById(long idUser) {
		// TODO Auto-generated method stub
		return orderHistoryRepo.findOne(idUser);
	}

	@Override
	public void insert(OrderHistory orderHistory) {
		// TODO Auto-generated method stub
		orderHistoryRepo.save(orderHistory);
	}

	@Override
	public void update(long idOrder, OrderHistory orderHistory) {
		// TODO Auto-generated method stub		
		OrderHistory o = orderHistoryRepo.findOne(idOrder);
		orderHistory.setIdorder(idOrder);
		orderHistoryRepo.save(o);
	}

	@Override
	public void delete(long idOrder) {
		// TODO Auto-generated method stub
		orderHistoryRepo.delete(idOrder);
	}

}
