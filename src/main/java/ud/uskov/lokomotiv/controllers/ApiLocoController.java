package ud.uskov.lokomotiv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ud.uskov.lokomotiv.models.Locomotive;
import ud.uskov.lokomotiv.services.ILocoService;
import java.util.List;
import java.util.Optional;

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
    public Optional<Locomotive> getLocomotiveById(@PathVariable Long id) {
        return Optional.of(locoService.getLocomotive(id).get());
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
