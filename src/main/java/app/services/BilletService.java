package app.services;

import app.entities.Billet;

public interface BilletService {

	Iterable<Billet> listAllBillets();

	Billet getBilletById(int id);

	Billet saveBillet(Billet billet);

	void deleteBillet(Integer id);

	// long count();
}
