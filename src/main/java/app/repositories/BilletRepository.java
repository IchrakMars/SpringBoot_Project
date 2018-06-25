package app.repositories;

import org.springframework.data.repository.CrudRepository;

import app.entities.Billet;

public interface BilletRepository extends CrudRepository<Billet, Integer> {

}
