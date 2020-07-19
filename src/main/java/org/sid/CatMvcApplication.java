package org.sid;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CatMvcApplication implements CommandLineRunner {
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(CatMvcApplication.class, args);
		//ProduitRepository produitRepository=ctx.getBean(ProduitRepository.class);
		

}
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Produit.class);
		
		produitRepository.save(new Produit("Compaq",890,90));
		produitRepository.save(new Produit("HPpc",9000,10));
		produitRepository.save(new Produit("Asus",3000,30));
		produitRepository.save(new Produit("Imprimante",300,39));
		
		produitRepository.findAll().forEach(p->{
			
		System.out.println(p.toString());
	});
		
	}}
