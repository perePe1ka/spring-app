package ud.uskov.lokomotiv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ud.uskov.lokomotiv.models.Locomotive;
import ud.uskov.lokomotiv.services.ILocoService;

import java.util.List;

@Controller
public class ApiLocoController{
    private final ILocoService locoService;

    @Autowired
    public ApiLocoController(ILocoService locoService) {
        this.locoService = locoService;
    }

    @GetMapping("/")
    public String locomotives(Model model) {
        model.addAttribute("locomotives", locoService.getAll());
        return "index";
    }
    @GetMapping("/loco/{id}")
    public String getLocomotiveById(@PathVariable Long id, Model model) {
        model.addAttribute("locomotive", locoService.getLocomotive(id));
        return "locoinfo";
    }

    @PostMapping("/create")
    public String createLocomotive(Locomotive locomotive) {
        locoService.create(locomotive);
        return "redirect:/";
    }
    @PostMapping("/loco/delete/{id}")
    public String deleteLocomotiveById(@PathVariable Long id) {
        locoService.deleteLocomotive(id);
        return "redirect:/";
    }


    @GetMapping("/getAll")
    public List<Locomotive> getAll() {
        return locoService.getAll();
    }

    @GetMapping("/loco/edit/{id}")
    public String editLoco(@PathVariable Long id, Model model) {
        model.addAttribute("locomotive", locoService.getLocomotive(id));
        return "locoedit";
    }

    @PostMapping("/edit")
    public String update(Locomotive locomotive, Model model) {
        locoService.updateLocomotive(locomotive);
        model.addAttribute("locomotive", locomotive);
        return "locoinfo";
    }
}
