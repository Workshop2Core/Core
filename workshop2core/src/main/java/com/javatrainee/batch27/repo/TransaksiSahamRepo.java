package com.javatrainee.batch27.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.javatrainee.batch27.entity.TransaksiSaham;


@RepositoryRestResource (collectionResourceRel = "transaksisaham", path="transaksisaham")
public interface TransaksiSahamRepo extends JpaRepository<TransaksiSaham, Long>  {
	 @Query(value = "SELECT a.* FROM transaksi_saham a "
		 		+ "WHERE a.iduser=:userId" ,nativeQuery = true)
		 List<TransaksiSaham> findDataSahamByUserId(@Param("userId") Long userId);
}
