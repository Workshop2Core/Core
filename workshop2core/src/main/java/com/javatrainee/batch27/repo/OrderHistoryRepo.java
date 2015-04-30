package com.javatrainee.batch27.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.javatrainee.batch27.entity.OrderHistory;

@RepositoryRestResource (collectionResourceRel = "orderhistory", path="orderhistory")
public interface OrderHistoryRepo extends JpaRepository<OrderHistory, Long> {

}
