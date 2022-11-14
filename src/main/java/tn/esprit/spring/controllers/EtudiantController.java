package tn.esprit.spring.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.ServicesInterface.IEtudiantService;
import tn.esprit.spring.entity.Etudiant;

import java.util.List;

@Tag(name ="Etudiant_Controller")
@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private IEtudiantService etudiantService;

    @Operation(description ="Afficher tous les etudiants")
    @GetMapping("/getAllEtudiant")
    public List<Etudiant> getAllEtudiant () {

        return etudiantService.retrieveAllEtudiants();
    }
    @Operation(description ="Ajouter etudiant")
    @PostMapping("/AddEtudiant")
    public Etudiant AddEtudiant(@RequestBody Etudiant e) {

        return etudiantService.addEtudiant(e);
    }

    @Operation(description ="Modifier etudiant")
    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {

        return etudiantService.updateEtudiant(e);

    }

    @Operation(description ="Retrive etudiant")
    @GetMapping("/retrieveEtudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Integer etudiantId) {
        return etudiantService.retrieveEtudiant(etudiantId);
    }

    @Operation(description ="Supprimer etudiant")
    @DeleteMapping("/removeEtudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Integer etudiantId) {
        etudiantService.removeEtudiant(etudiantId);
    }

    @PutMapping(value = "/affecter-etudiant-departement/{etudiantID}/{departementID}")
    public void affecterEtudiantToDepartement(@PathVariable("etudiantID") Integer etudiantID,
                                              @PathVariable("departementID")Integer departementID)
    {
        etudiantService.assignEtudiantToDepartement(etudiantID,departementID);
    }



    @PutMapping(value = "/affecter-etudiant-Contrat-equipe/{e}/{idContrat}/{EquipeID}")
    public void addAndAssignEtudiantToEquipeAndContract(@PathVariable("e") Etudiant e,
                                                        @PathVariable("idContrat")Integer idContrat ,
                                                        @PathVariable("EquipeID")Integer EquipeId      )
    {
        etudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,EquipeId);
    }





}
