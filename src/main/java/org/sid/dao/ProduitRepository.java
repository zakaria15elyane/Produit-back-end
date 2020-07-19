package org.sid.dao;



import java.util.List;

import org.sid.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	@RestResource(path="/byDesignation")
	public List<Produit> findByDesignationContains(@Param("mc") String des);
	@RestResource(path="/byDesignationPage")
	public Page<Produit> findByDesignationContains(@Param("mc") String des,Pageable pageable);
}
