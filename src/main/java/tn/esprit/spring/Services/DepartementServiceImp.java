package tn.esprit.spring.Services;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.ServicesInterface.IDepartementService;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Universite;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.UniversiteRepository;

import java.util.List;
@Slf4j
@Service
@Tag(name ="DepartementService")
@RestController

public class DepartementServiceImp  implements IDepartementService {

    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    UniversiteRepository UniversiteRepository;

    @Operation(description ="retrieve All Departements")
    @GetMapping("/retrieveAllDepartements")
    @Override
    public List<Departement> retrieveAllDepartements() {
        List<Departement> Departements=departementRepository.findAll();
        for(Departement d:Departements) {
            //System.out.println(e);
            log.info(d.toString());
        }
        return Departements;    }

    @Operation(description ="add Departement")
    @GetMapping("/addDepartement")
    @Override
    public Departement addDepartement(Departement d) {
System.out.println(d);
        return  departementRepository.save(d);
    }

    @Operation(description ="update Departement")
    @GetMapping("/updateDepartement")
    @Override
    public Departement updateDepartement(Departement d) {
        return  departementRepository.save(d);
    }

    @Operation(description ="retrieve Departement")
    @GetMapping("/retrieveDepartement")
    @Override
    public Departement retrieveDepartement(Integer idDepart) {

        return departementRepository.findById(idDepart).orElse(null);

    }

    @Operation(description ="remove Departement")
    @GetMapping("/removeDepartement")
    @Override
    public void removeDepartement(Integer idDepart) {

        boolean exists =departementRepository.existsById(idDepart);
        if(!exists) {

            throw new IllegalStateException (
                    "Depart with id" +idDepart + "does not exists");
        }

        departementRepository.deleteById(idDepart);

    }







}
