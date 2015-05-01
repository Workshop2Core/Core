package com.javatrainee.batch27.web;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javatrainee.batch27.entity.OrderHistory;
import com.javatrainee.batch27.entity.Saham;
import com.javatrainee.batch27.entity.TransaksiSaham;
import com.javatrainee.batch27.entity.User;
import com.javatrainee.batch27.service.OrderHistoryService;
import com.javatrainee.batch27.service.SahamService;
import com.javatrainee.batch27.service.TransaksiSahamService;
import com.javatrainee.batch27.service.UserService;

/*@RestController
@RequestMapping("workshop2/matching")*/
@Component
public class MatchingController {
	@Autowired
	private OrderHistoryService orderHistoryService;
	
	@Autowired
	private SahamService sahamService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TransaksiSahamService transaksiSahamService;
	
	/*@RequestMapping(method=RequestMethod.GET)*/
	@Scheduled(fixedRate=5000)
	public void matching()
	{
		System.out.println("masuk matching");
		String status = "Open";
		List<OrderHistory> listBuy = orderHistoryService.listStatusOpen();
		for(OrderHistory orderListBuy : listBuy)
		{ 
			OrderHistory listSell = orderHistoryService.findMatching (orderListBuy.getPrice(), 
						orderListBuy.getSaham().getIdsaham(), orderListBuy.getLot());
			if(listSell != null)
			{
				long idBuyer = orderListBuy.getUser().getIduser();
				long idSeller = listSell.getUser().getIduser();
				BigDecimal perLot = new BigDecimal(100);
				
				//Update OrderHistory for Seller
				BigDecimal idCounterPart = new BigDecimal(idBuyer);
				listSell.setIdcounterpart(idCounterPart);
				listSell.setStatus("Done");
				orderHistoryService.update(listSell.getIdorder(), listSell);
				
				//Update OrderHistory for Buyer
				idCounterPart = new BigDecimal(idSeller);
				orderListBuy.setIdcounterpart(idCounterPart);
				orderListBuy.setStatus("Done");
				orderHistoryService.update(orderListBuy.getIdorder(), orderListBuy);
				
				//Update LastPrice in Table SAHAM
				long idSaham = listSell.getSaham().getIdsaham();
				Saham sahamUpdate = sahamService.findSahamByIdSaham(idSaham);
				sahamUpdate.setLastprice(listSell.getPrice());
				sahamService.update(idSaham, sahamUpdate);
				
				//Update Saldo for Seller
				User userSeller = userService.findById(idSeller);
				BigDecimal saldoSeller = listSell.getUser().getSaldo().add(listSell.getPrice().multiply(listSell.getLot().multiply(perLot)));
				userSeller.setSaldo(saldoSeller);
				userService.update(idSeller, userSeller);
				
				//Update Saldo for Buyer
				User userBuyer = userService.findById(idBuyer);
				BigDecimal saldoBuyer = orderListBuy.getUser().getSaldo().subtract(orderListBuy.getPrice().multiply(orderListBuy.getLot().multiply(perLot)));
				userBuyer.setSaldo(saldoBuyer);
				userService.update(idBuyer, userBuyer);
				
				//Update Transaksi Saham Seller
				TransaksiSaham transaksiSahamUpdateSeller = transaksiSahamService.findDataSahamByUserIdAndIdSaham(idSeller, idSaham);
				transaksiSahamUpdateSeller.setLot(transaksiSahamUpdateSeller.getLot().subtract(listSell.getLot()));
				transaksiSahamService.update(transaksiSahamUpdateSeller.getIdtransaksi(), transaksiSahamUpdateSeller);
				
				//Update Transaksi Saham Buyer
				TransaksiSaham transaksiSahamUpdateBuyer = transaksiSahamService.findDataSahamByUserIdAndIdSaham(idBuyer, idSaham);
				if(transaksiSahamUpdateBuyer==null)
				{
					TransaksiSaham transaksiInsert = new TransaksiSaham();
					transaksiInsert.setUser(userBuyer);
					transaksiInsert.setSaham(sahamUpdate);
					transaksiInsert.setLot(orderListBuy.getLot());
					
					transaksiSahamService.insert(transaksiInsert);
				}
				else
				{	
					transaksiSahamUpdateBuyer.setLot(transaksiSahamUpdateBuyer.getLot().add(orderListBuy.getLot()));
					transaksiSahamService.update(transaksiSahamUpdateBuyer.getIdtransaksi(), transaksiSahamUpdateBuyer);
				}
			}
		}
		
	}
}
