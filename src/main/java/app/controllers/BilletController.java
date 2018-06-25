package app.controllers;

import app.entities.Billet;
import app.services.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Bill controller.
 */
@Controller
public class BilletController {

    private BilletService billetService;

    @Autowired
    public void setBilletService(BilletService billetService) {
        this.billetService = billetService;
    }

    /**
     * List all bills.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/billets", method = RequestMethod.POST)
    public String listP(Model model) {
        model.addAttribute("billets", billetService.listAllBillets());
        System.out.println("Returning bills:");
        return "billets";
    }
    @RequestMapping(value = "/billets", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("billets", billetService.listAllBillets());
        System.out.println("Returning bills:");
        return "billets";
    }
    

    /**
     * View a specific Bill by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("billet/{id}")
    public String showBillet(@PathVariable Integer id, Model model) {
        model.addAttribute("billet", billetService.getBilletById(id));
        return "billetshow";
    }

    // Afficher le formulaire de modification du Billet
    @RequestMapping("billet/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("billet", billetService.getBilletById(id));
        return "billetform";
    }

    /**
     * New Bill.
     *
     * @param model
     * @return
     */
    @RequestMapping("billet/new")
    public String newBillet(Model model) {
        model.addAttribute("billet", new Billet());
        return "billetform";
    }

    /**
     * Save Bill to database.
     *
     * @param Billet
     * @return
     */
    @RequestMapping(value = "billet", method = RequestMethod.POST)
    public String saveBillet(Billet billet) {
        billetService.saveBillet(billet);
        return "redirect:/billet/" + billet.getIdBillet() ;
    }

    /**
     * Delete Bill by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("billet/delete/{id}")
    public String delete(@PathVariable Integer id) {
        billetService.deleteBillet(id);
        return "redirect:/billets";
    }

}
