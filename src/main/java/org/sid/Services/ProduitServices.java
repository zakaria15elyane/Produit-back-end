package org.sid.Services;

import java.util.List;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProduitServices {

	@Autowired
	private ProduitRepository produitRepository;
	
	public List<Produit> getAllProduits(){
		return produitRepository.findAll();
	}
	public Produit getOneProduits(Long id){
		return produitRepository.findById(id).get();
	}
	public void deleteProduit(Long id){
		produitRepository.deleteById(id);
	}
	public Produit saveProduit(Produit p){
		return produitRepository.save(p);
	}
	public Produit updateProduit(Produit p){
		return produitRepository.save(p);
	}
	
}
