package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.ServicesInterface.IContratService;
import tn.esprit.spring.ServicesInterface.IEtudiantService;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Etudiant;

import java.util.List;
@Tag(name ="Contrat_Controller")
@RestController
@RequestMapping("/contrats")
public class ContratController {


        @Autowired
        private IContratService contratService;

       @Operation(description ="Afficher tous les contrats")
        @GetMapping("/getAllContrats")
        public List<Contrat> getAllContrats () {

            return contratService.retrieveAllContrats();
        }
        @Operation(description ="Ajouter contrat")
        @PostMapping("/AddContrat")
        public Contrat AddContrat(@RequestBody Contrat c) {

            return contratService.addContrat(c);
        }
        @Operation(description ="Modifier contrat")
        @PutMapping("/updateContrat")
        public Contrat updateContrat(@RequestBody Contrat c) {

            return contratService.updateContrat(c);

        }
        @Operation(description ="Retrive contrat")
        @GetMapping("/retrieveContrat/{contrat-id}")
        public Contrat retrieveContrat(@PathVariable("contrat-id") Integer contratId) {
            return contratService.retrieveContrat(contratId);
        }

        @Operation(description ="Remove contrat")
        @DeleteMapping("/removeContrat/{contrat-id}")
        public void removeContrat(@PathVariable("contrat-id") Integer contratId) {
            contratService.removeContrat(contratId);
        }



    }
