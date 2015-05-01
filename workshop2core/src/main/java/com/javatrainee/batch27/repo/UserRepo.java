package com.javatrainee.batch27.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.javatrainee.batch27.entity.User;

@RepositoryRestResource (collectionResourceRel = "user", path="user")
public interface UserRepo extends JpaRepository<User, Long>   {
	
	 @Query(value = "SELECT a.* FROM users a "
		 		+ "WHERE a.username=:username AND a.password = :password" ,nativeQuery = true)
		 User findUserByUsernameAndPassword(@Param("username") String username, 
				 @Param("password") String password);
	 	 
}
