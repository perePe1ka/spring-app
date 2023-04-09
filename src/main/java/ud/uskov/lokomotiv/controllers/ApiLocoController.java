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

    @GetMapping("/main")
    public String gotoMain() {
        return "index";
    }

    @PostMapping("/create")
    public String createLocomotive(Locomotive locomotive) {
        locoService.create(locomotive);
        return "redirect:/";
    } //РАБОТАЕТ
    @GetMapping("/getLoco/{id}")
    public String getLocomotiveById(@PathVariable Long id, Model model) {
        model.addAttribute("locomotive", locoService.getLocomotive(id));
        return "locomotives";
    }
    @DeleteMapping("/deleteLoco/{id}")
    public void deleteLocomotiveById(@PathVariable Long id) {
        locoService.deleteLocomotive(id);
    }

    @GetMapping("/getAll")
    public List<Locomotive> getAll() {
        return locoService.getAll();
    }

    @PutMapping("/update/{id}")
    public Locomotive update(@PathVariable Long id, @RequestBody Locomotive locomotive) {
        return locoService.updateLocomotive(locomotive);
    }
}
