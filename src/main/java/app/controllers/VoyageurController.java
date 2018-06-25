package app.controllers;

import app.entities.Billet;
import app.entities.Voyageur;
import app.services.VoyageurService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Voyageur controller.
 */
@Controller
public class VoyageurController {

    private VoyageurService voyageurService;
  
    @Autowired
    public void setVoyageurService(VoyageurService voyageurService) {
        this.voyageurService = voyageurService;
    }

    /**
     * List all travelers.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/voyageurs", method = RequestMethod.GET)
    public String list(Model model) {
    	Iterable<Voyageur> voys = voyageurService.listAllVoyageurs() ; 
        model.addAttribute("voyageurs", voys);
        System.out.println("Returning travelers:");
        return "voyageurs";
    }
    /**
     * List all bills for a specific traveler.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/billets/{id}", method = RequestMethod.GET)
    public String listBills(@PathVariable Integer id, Model model) {
        model.addAttribute("billets", voyageurService.getVoyageurById(id).getBillets());
        System.out.println("Returning bills:");
        return "billetsVoy";
    }

    /**
     * View a specific Traveler by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("voyageur/{id}")
    public String showVoyageur(@PathVariable Integer id, Model model) {
        model.addAttribute("voyageur", voyageurService.getVoyageurById(id));
        
        return "voyshow";
    }

    // Afficher le formulaire de modification du Voyageur
    @RequestMapping("voyageur/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("voyageur", voyageurService.getVoyageurById(id));
        return "voyform";
    }

    /**
     * New Traveler.
     *
     * @param model
     * @return
     */
    @RequestMapping("voyageur/new")
    public String newVoyageur(Model model) {
        model.addAttribute("voyageur", new Voyageur());
        return "voyform";
    }

    /**
     * Save Traveler to database.
     *
     * @param Voyageur
     * @return
     */
    @RequestMapping(value = "voyageur", method = RequestMethod.POST)
    public String saveVoyageur(Voyageur Voyageur) {
        voyageurService.saveVoyageur(Voyageur);
        return "redirect:/voyageur/" + Voyageur.getIdVoyageur();
    }

    /**
     * Delete Traveler by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("voyageur/delete/{id}")
    public String delete(@PathVariable Integer id) {
        voyageurService.deleteVoyageur(id);
        return "redirect:/voyageurs";
    }

}
