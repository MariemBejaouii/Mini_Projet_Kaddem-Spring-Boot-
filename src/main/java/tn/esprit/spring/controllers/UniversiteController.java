package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.ServicesInterface.IEtudiantService;
import tn.esprit.spring.ServicesInterface.IUniverisiteService;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Universite;

import java.util.List;

@Tag(name ="Universite_Controller")
@RestController
@RequestMapping("/universites")
public class UniversiteController {

    @Autowired
    private IUniverisiteService univerisiteService;

    @Operation(description ="Afficher tous les universités")
    @GetMapping("/getAllUniversites")
    public List<Universite> getAllUniversites() {

        return univerisiteService.retrieveAllUniversites();
    }
    @Operation(description ="Ajouter universite ")
    @PostMapping("/AddUniversite")
    public Universite AddUniversite(@RequestBody Universite u) {

        return univerisiteService.addUniversite(u);
    }

    @Operation(description ="Modifier universite ")
    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite u) {

        return univerisiteService.updateUniversite(u);

    }
    @Operation(description ="Retrive universite ")
    @GetMapping("/retrieveUniversite/{Universite-id}")
    public Universite retrieveUniversite(@PathVariable("Universite-id") Integer UniversiteId) {
        return univerisiteService.retrieveUniversite(UniversiteId);
    }

    @Operation(description ="Remove universite ")
    @DeleteMapping("/removeUniversite/{Universite-id}")
    public void removeUniversite(@PathVariable("Universite-id") Integer UniversiteId) {
        univerisiteService.removeUniversite(UniversiteId);
    }

    @PutMapping(value = "/affecter-Universite-departement/{universiteID}/{departementID}")
    public void affecterUniversiteToDepartement(@PathVariable("universiteID") Integer universiteID,
                                                @PathVariable("departementID")Integer departementID)
    {
        univerisiteService.assignUniversiteToDepartement(universiteID,departementID);
    }
}



