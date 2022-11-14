package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.ServicesInterface.IEquipeService;
import tn.esprit.spring.entity.Equipe;

import java.util.List;

@Tag(name ="Equipe_Controller")
@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    private IEquipeService equipeService;

    @Operation(description ="Afficher tous les equipes")
    @GetMapping("/getAllEquipes")
    public List<Equipe> getAllEquipes () {

        return equipeService.retrieveAllEquipes();
    }

    @Operation(description ="Ajouter equipe")
    @PostMapping("/AddEquipe")
    public Equipe AddEquipe(@RequestBody Equipe e) {

        return equipeService.addEquipe(e);
    }

    @Operation(description ="Modifier equipe")
    @PutMapping("/updateEquipe")
    public Equipe updateEquipe(@RequestBody Equipe e) {

        return equipeService.updateEquipe(e);

    }
    @Operation(description ="Retrive equipe")
    @GetMapping("/retrieveEquipe/{equipe-id}")
    public Equipe retrieveEquipe(@PathVariable("equipe-id") Integer equipeId) {
        return equipeService.retrieveEquipe(equipeId);
    }

    @Operation(description ="Remove equipe")
    @DeleteMapping("/removeEquipe/{equipe-id}")
    public void removeEquipe(@PathVariable("equipe-id") Integer equipeId) {
        equipeService.removeEquipe(equipeId);
    }
}
