package org.sid.web;

import java.util.List;
import org.sid.Services.ProduitServices;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value="Cette API utilisé pour la gestion des Produits")
@RequestMapping("api/v1/")

@RestController
public class ProduitController {

	@Autowired
	private ProduitServices produitServices;
	
	@ApiOperation(value="Méthode utilisée pour afficher la liste des Produits")
	@GetMapping(path="/listeProduits")
	public List<Produit> listeProduits(){
		return produitServices.getAllProduits();
	}
	@ApiOperation(value="méthode utilisée pour afficher un seule produits")
	@GetMapping(path="/listeProduits/{id}")
	public Produit listeProduits(@PathVariable (name="id")Long id){
		return produitServices.getOneProduits(id);
	}
	@ApiOperation(value="méthode utilisée pour modifier un produit")
	@PutMapping(path="/listeProduits/{id}")
	public Produit updateProduits(@PathVariable (name="id") Long id, @RequestBody Produit p){
		p.setId(id);
		return produitServices.updateProduit(p);
	}
	@ApiOperation(value="méthode utilisée pour enregister un produits")
	@PostMapping(path="/listeProduits")
	public Produit save(@RequestBody Produit p){
		return produitServices.saveProduit(p);
	}
	@ApiOperation(value="méthode utilisée pour supprimer un produits")
	@DeleteMapping(path="/listeProduits/{id}")
	public void delete(@PathVariable (name="id") Long id){
		produitServices.deleteProduit(id);
	}
	
}
	