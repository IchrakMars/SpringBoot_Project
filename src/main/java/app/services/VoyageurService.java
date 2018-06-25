package app.services;

import app.entities.Voyageur;

public interface VoyageurService {

	Iterable<Voyageur> listAllVoyageurs();

	Voyageur getVoyageurById(int id);

	Voyageur saveVoyageur(Voyageur voyageur);

	void deleteVoyageur(Integer id);	

}
