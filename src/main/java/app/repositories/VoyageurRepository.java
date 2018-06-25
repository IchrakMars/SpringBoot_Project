package app.repositories;

import org.springframework.data.repository.CrudRepository;

import app.entities.Voyageur;

public interface VoyageurRepository extends CrudRepository<Voyageur, Integer> {
	
}
