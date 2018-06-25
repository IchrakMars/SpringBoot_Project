package app.services;

import app.entities.Voyageur;
import app.repositories.VoyageurRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Voyageur service implement.
 */

@Service
public class VoyageurServiceImpl implements VoyageurService {

    private VoyageurRepository voyageurRepository;

    @Autowired
    public void setVoyageurRepository(VoyageurRepository voyageurRepository) {
        this.voyageurRepository = voyageurRepository;
    }

    @Override
    public Iterable<Voyageur> listAllVoyageurs() {
        return voyageurRepository.findAll();
    }

    @Override
    public Voyageur getVoyageurById(int id) {
        return voyageurRepository.findOne(id);
    }

    @Override
    public Voyageur saveVoyageur(Voyageur voyageur) {
        return voyageurRepository.save(voyageur);
    }

    @Override
    public void deleteVoyageur(Integer id) {
        voyageurRepository.delete(id);
    }
    
    
    
}
