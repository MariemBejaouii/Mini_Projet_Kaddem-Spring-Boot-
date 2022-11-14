package tn.esprit.spring.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.spring.ServicesInterface.IDepartementService;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.repository.DepartementRepository;

import java.util.List;
@Slf4j
@Service

public class DepartementServiceImp  implements IDepartementService {

    DepartementRepository DepartementRepository;
    @Override
    public List<Departement> retrieveAllDepartements() {
        List<Departement> Departements=DepartementRepository.findAll();
        for(Departement d:Departements) {
            //System.out.println(e);
            log.info(d.toString());
        }
        return Departements;    }

    @Override
    public Departement addDepartement(Departement d) {

        return  DepartementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return  DepartementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {

        return DepartementRepository.findById(idDepart).orElse(null);

    }

    @Override
    public void removeDepartement(Integer idDepart) {

        boolean exists =DepartementRepository.existsById(idDepart);
        if(!exists) {

            throw new IllegalStateException (
                    "Depart with id" +idDepart + "does not exists");
        }

        DepartementRepository.deleteById(idDepart);

    }



}
