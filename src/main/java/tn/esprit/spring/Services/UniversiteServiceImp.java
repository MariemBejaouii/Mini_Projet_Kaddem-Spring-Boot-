package tn.esprit.spring.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.ServicesInterface.IUniverisiteService;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Universite;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.UniversiteRepository;
import java.util.List;
import tn.esprit.spring.entity.Departement;

@Slf4j
@Service
public class UniversiteServiceImp implements IUniverisiteService  {

    @Autowired
    UniversiteRepository UniversiteRepository;
    DepartementRepository DepartementRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        List<Universite> Universites = UniversiteRepository.findAll();
        for (Universite u : Universites) {
            //System.out.println(e);
            log.info(u.toString());
        }
        return Universites;
    }
    @Override
    public Universite addUniversite(Universite u) {
        return    UniversiteRepository.save(u);
   }

    @Override
    public Universite updateUniversite(Universite u) {
        return  UniversiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return UniversiteRepository.findById(idUniversite).orElse(null);


    }

    @Override
    public void removeUniversite(Integer idUniversite) {


        boolean exists =UniversiteRepository.existsById(idUniversite);
        if(!exists) {

            throw new IllegalStateException (
                    "Universite with id" +idUniversite + "does not exists");
        }

        UniversiteRepository.deleteById(idUniversite);

    }

    public void assignUniversiteToDepartement(Integer idUniversite , Integer idDepartement) {

        Universite u=UniversiteRepository.findById(idUniversite).orElse(null);
        Departement d= DepartementRepository.findById(idDepartement).orElse(null);
        u.getDepartement().add(d);
        UniversiteRepository.save(u);


    }








}
