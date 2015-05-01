package com.javatrainee.batch27.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatrainee.batch27.entity.FloorPojo;
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
	
	@Override
	public OrderHistory findMatching(BigDecimal price, long idSaham, BigDecimal lot)
	{
		return orderHistoryRepo.findMatching(price, idSaham, lot);
	}
	
	@Override
	public List<OrderHistory> listStatusOpen()
	{
		return orderHistoryRepo.listStatusOpen();
	}
	
	@Override
	public void update(long idOrder, OrderHistory orderHistory) {
		OrderHistory orderHistoryUpdate = orderHistoryRepo.findOne(idOrder);
		orderHistoryUpdate.setDateorder(orderHistory.getDateorder());
		orderHistoryUpdate.setIdcounterpart(orderHistory.getIdcounterpart());
		orderHistoryUpdate.setIdorder(orderHistory.getIdorder());
		orderHistoryUpdate.setJenistransaksi(orderHistory.getJenistransaksi());
		orderHistoryUpdate.setLot(orderHistory.getLot());
		orderHistoryUpdate.setPrice(orderHistory.getPrice());
		orderHistoryUpdate.setSaham(orderHistory.getSaham());
		orderHistoryUpdate.setStatus(orderHistory.getStatus());
		orderHistoryUpdate.setUser(orderHistory.getUser());
		
		orderHistoryRepo.save(orderHistoryUpdate);
	}

	private List<FloorPojo> getDataFloor(int sizeData, int sizeBuy, int sizeSell, List<Object> listBuy,List<Object> listSell){

		List<FloorPojo> listFloor = new ArrayList<FloorPojo>();
		for (int i = 0; i<sizeData; i++) {
			Object[] objBuys;
			Object[] objSells;
			
			FloorPojo floor = new FloorPojo();
			if (i<sizeBuy) {
				objBuys = (Object[]) listBuy.get(i);
				floor.setBuyLot(objBuys[0].toString());
				floor.setBuyPrice(objBuys[1].toString());
			}else{
				floor.setBuyLot("");
				floor.setBuyPrice("");
			}
			if (i<sizeSell) {
				objSells = (Object[]) listSell.get(i);
				floor.setSellLot(objSells[0].toString());
				floor.setSellPrice(objSells[1].toString());
			}else{
				floor.setSellLot("");
				floor.setSellPrice("");
			}
			
			listFloor.add(floor);
		}
		return listFloor;
	}
	
	@Override
	public List<FloorPojo> findAllDataFloor(long idSaham) {
		// TODO Auto-generated method stub
		List<Object> listBuy = orderHistoryRepo.findFloorDataBuy(idSaham);
		List<Object> listSell = orderHistoryRepo.findFloorDataSell(idSaham);
		List<FloorPojo> listFloor = new ArrayList<FloorPojo>();
		if (listBuy.size() > listSell.size()) {
			listFloor = getDataFloor(listBuy.size(),listBuy.size(),listSell.size(),listBuy,listSell);
		}else{
			listFloor = getDataFloor(listSell.size(),listBuy.size(),listSell.size(),listBuy,listSell);
		}
		return listFloor;
	}

	@Override
	public List<OrderHistory> findOrderHistoryByIdUser(long idUser) {
		// TODO Auto-generated method stub
		return orderHistoryRepo.findOrderHistoryByIdUser(idUser);
	}
}
