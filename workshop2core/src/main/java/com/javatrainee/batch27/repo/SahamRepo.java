package com.javatrainee.batch27.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.javatrainee.batch27.entity.Saham;

@RepositoryRestResource (collectionResourceRel = "saham", path="saham")
public interface SahamRepo extends JpaRepository<Saham, Long>  {
	 
	@Query(value = "SELECT a.* FROM saham a "
		 		+ "WHERE a.nama =:sahamName" ,nativeQuery = true)
		 Saham findSahamBySahamName(@Param("sahamName") String sahamName);
	 
	 @Query(value = "SELECT a.* FROM saham a "
		 		+ "WHERE a.kode_saham =:kodeSaham" ,nativeQuery = true)
		 Saham findSahamByKodeSaham(@Param("kodeSaham") String kodeSaham);
	 
}
