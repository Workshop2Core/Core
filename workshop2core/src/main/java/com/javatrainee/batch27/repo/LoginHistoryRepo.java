package com.javatrainee.batch27.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.javatrainee.batch27.entity.LoginHistory;

@RepositoryRestResource (collectionResourceRel = "loginhistory", path="loginhistory")
public interface LoginHistoryRepo extends JpaRepository<LoginHistory, Long> {
	
	 @Query(value = "SELECT a.* FROM login_history a "
	 		+ "WHERE a.iduser = :userId" ,nativeQuery = true)
	 LoginHistory findLoginHistoryByIdUser(@Param("userId") Long userId);
	 
}
