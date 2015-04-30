package com.javatrainee.batch27.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.javatrainee.batch27.entity.Saham;

@RepositoryRestResource (collectionResourceRel = "saham", path="saham")
public interface SahamRepo extends JpaRepository<Saham, Long>  {

}
