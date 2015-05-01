package com.javatrainee.batch27.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.javatrainee.batch27.entity.PasswordHistory;

@RepositoryRestResource (collectionResourceRel = "passwordhistory", path="passwordhistory")
public interface PasswordHistoryRepo extends JpaRepository<PasswordHistory, Long> {
	
	 @Query(value = "SELECT a.* FROM password_history a WHERE a.iduser = :userId"
	 		+ " AND a.oldpwd=:password" ,nativeQuery = true)
		 PasswordHistory findPasswordHistoryByIdUserAndPassword(
				 @Param("userId") Long userId,
				 @Param("password") String password);
	 
	 public PasswordHistory findPasswordByIduser(@Param("idUser") long idUser);
}
