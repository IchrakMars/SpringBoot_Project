package app.services;

import app.entities.Billet;
import app.repositories.BilletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Billet service implement.
 */

@Service
public class BilletServiceImpl implements BilletService {

    private BilletRepository billetRepository;

    @Autowired
    public void setBilletRepository(BilletRepository billetRepository) {
        this.billetRepository = billetRepository;
    }

    @Override
    public Iterable<Billet> listAllBillets() {
        return billetRepository.findAll();
    }

    @Override
    public Billet getBilletById(int id) {
        return billetRepository.findOne(id);
    }

    @Override
    public Billet saveBillet(Billet billet) {
        return billetRepository.save(billet);
    }

    @Override
    public void deleteBillet(Integer id) {
        billetRepository.delete(id);
    }

}
