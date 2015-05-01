package com.javatrainee.batch27.service;

import java.math.BigDecimal;
import java.util.List;

import com.javatrainee.batch27.entity.FloorPojo;
import com.javatrainee.batch27.entity.OrderHistory;

public interface OrderHistoryService {
	
	//path : workshop2/orderHistory
	public List<OrderHistory> findAll();												//-->getAll
	public OrderHistory findOrderHistoryByOrderId(long orderId);						//-->getOrderHistoryByOrderId/{orderId}
	public void insert(OrderHistory orderHistory);										//-->insert
	public OrderHistory findMatching(BigDecimal price, long idSaham, BigDecimal lot);	//-->getMatchingSell
	public List<OrderHistory> listStatusOpenBuy();										//-->getBuyList
	public void update(long idOrder, OrderHistory orderHistory);
	public List<FloorPojo> findAllDataFloor(long idSaham);
	public List<OrderHistory> findOrderHistoryByIdUser(long idUser);
	
}
