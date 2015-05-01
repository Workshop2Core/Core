package com.javatrainee.batch27.web;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javatrainee.batch27.entity.FloorPojo;
import com.javatrainee.batch27.entity.OrderHistory;
import com.javatrainee.batch27.service.OrderHistoryService;

@RestController
@RequestMapping("workshop2/orderHistory")
public class OrderHistoryController {

	@Autowired
	private OrderHistoryService orderHistoryService;
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public ResponseEntity<List<OrderHistory>> getAllOrderHistory() {
		List<OrderHistory> orderHistory = orderHistoryService.findAll();	 
	    return new ResponseEntity<List<OrderHistory>>(orderHistory, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getOrderHistoryByStatus/{orderId}",method=RequestMethod.GET)
	public ResponseEntity<OrderHistory> getOrderHistoryById(@PathVariable("orderId") long orderId) {
		OrderHistory orderHistory = orderHistoryService.findOrderHistoryByOrderId(orderId);	 
	    return new ResponseEntity<OrderHistory>(orderHistory, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllDataFloorByIdSaham/{idSaham}",method=RequestMethod.GET)
	public ResponseEntity<List<FloorPojo>> getAllDataFloorByIdSaham(@PathVariable("idSaham") long idSaham) {
		List<FloorPojo> floorPojo = orderHistoryService.findAllDataFloor(idSaham);	 
	    return new ResponseEntity<List<FloorPojo>>(floorPojo, HttpStatus.OK);
	}
	
	@RequestMapping(value="/listStatusOpenBuy",method=RequestMethod.GET)
	public ResponseEntity<List<OrderHistory>> listStatusOpen() {
		List<OrderHistory> orderHistory = orderHistoryService.listStatusOpenBuy();	 
	    return new ResponseEntity<List<OrderHistory>>(orderHistory, HttpStatus.OK);
	}

	@RequestMapping(value="/findMatching/{price}/{idSaham}/{lot}",method=RequestMethod.GET)
	public ResponseEntity<OrderHistory> findMatching(@PathVariable("price") BigDecimal price,
			@PathVariable("idSaham") long idSaham, @PathVariable("lot") BigDecimal lot) {
		OrderHistory orderHistory = orderHistoryService.findMatching(price, idSaham, lot);	 
	    return new ResponseEntity<OrderHistory>(orderHistory, HttpStatus.OK);
	}

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public ResponseEntity<OrderHistory> insertOrderHistory(@RequestBody @Valid OrderHistory orderHistory){
		orderHistoryService.insert(orderHistory);
		return new ResponseEntity<OrderHistory>(HttpStatus.NO_CONTENT);
	}
}
