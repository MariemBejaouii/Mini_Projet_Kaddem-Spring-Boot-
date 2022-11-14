package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.ServicesInterface.IDepartementService;
import tn.esprit.spring.ServicesInterface.IEtudiantService;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Etudiant;

import java.util.List;


    @Tag(name ="Departement_Controller")
    @RestController
    @RequestMapping("/departements")
    public class DepartementController {

        @Autowired
        private IDepartementService departementService;

        @Operation(description ="Afficher tous les departements")
        @GetMapping("/getAllDepartement")
        public List<Departement> getAllDepartement () {

            return departementService.retrieveAllDepartements();
        }
        @Operation(description ="Ajouter departement ")
        @PostMapping("/AddDepartement")
        public Departement AddDepartement(@RequestBody Departement d) {

            return departementService.addDepartement(d);
        }

        @Operation(description ="Modifier departement ")
        @PutMapping("/updateDepartement")
        public Departement updateDepartement(@RequestBody Departement d) {

            return departementService.updateDepartement(d);

        }

        @Operation(description ="Retrive departement ")
        @GetMapping("/retrieveDepartement/{Departement-id}")
        public Departement retrieveDepartement(@PathVariable("Departement-id") Integer DepartementID) {
            return departementService.retrieveDepartement(DepartementID);
        }

        @Operation(description ="Remove departement ")
        @DeleteMapping("/removeDepartement/{departement-id}")
        public void removeDepartement(@PathVariable("departement-id") Integer departementId) {
            departementService.removeDepartement(departementId);
        }



    }
