package com.javatrainee.batch27.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.javatrainee.batch27.entity.OrderHistory;

@RepositoryRestResource (collectionResourceRel = "orderhistory", path="orderhistory")
public interface OrderHistoryRepo extends JpaRepository<OrderHistory, Long> {
	
	@Query(value = "SELECT * FROM order_history "
		 		+ "WHERE status='Open' AND jenistransaksi='Sell' "
		 		+ "AND price=:price AND idsaham=:idSaham "
		 		+ "AND lot=:lot" ,nativeQuery = true)
	OrderHistory findMatching(@Param("price") BigDecimal price, 
				 @Param("idSaham") long idSaham, @Param("lot") BigDecimal lot);
	

	@Query(value = "SELECT * FROM order_history "
		 		+ "WHERE status='Open' AND jenistransaksi='Buy'",
		 		nativeQuery = true)
	List<OrderHistory> listStatusOpen();
	
	 @Query(value = "SELECT SUM(lot) AS lot_buy, price AS price_buy "
		 		+ "FROM order_history WHERE status = 'Open' AND idsaham=:idSaham "
		 		+ "AND jenistransaksi='Buy' GROUP BY idsaham,price "
		 		+ "ORDER BY price DESC" ,nativeQuery = true)
	 List<Object> findFloorDataBuy(@Param("idSaham") Long idSaham);
		 
	 @Query(value = "SELECT SUM(lot) AS lot_sell, price AS price_sell "
		 		+ "FROM order_history WHERE status = 'Open' AND idsaham=:idSaham "
		 		+ "AND jenistransaksi='Sell' GROUP BY idsaham,price "
		 		+ "ORDER BY price DESC" ,nativeQuery = true)
	 List<Object> findFloorDataSell(@Param("idSaham") Long idSaham);
		 
	 @Query(value = "SELECT * "
		 		+ "FROM order_history WHERE iduser=:idUser ",nativeQuery = true)
	 List<OrderHistory> findOrderHistoryByIdUser(@Param("idUser") Long idUser);
}