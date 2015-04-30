package com.javatrainee.batch27.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.javatrainee.batch27.entity.TransaksiSaham;


@RepositoryRestResource (collectionResourceRel = "transaksisaham", path="transaksisaham")
public interface TransaksiSahamRepo extends JpaRepository<TransaksiSaham, Long>  {

}
