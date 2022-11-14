package tn.esprit.spring.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.spring.ServicesInterface.IEtudiantService;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Equipe;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EquipeRepository;
import tn.esprit.spring.repository.EtudiantRepository;

import java.util.List;
@Slf4j
@Service
public class EtudiantServiceImp implements IEtudiantService {

    EtudiantRepository EtudiantRepository;
    DepartementRepository DepartementRepository;
    ContratRepository  ContratRepository;

    EquipeRepository EquipeRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        List<Etudiant> Etudiants=EtudiantRepository.findAll();
        for(Etudiant e:Etudiants) {
            //System.out.println(e);
            log.info(e.toString());
        }
        return Etudiants;
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return  EtudiantRepository.save(e);

    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return  EtudiantRepository.save(e);


    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return EtudiantRepository.findById(idEtudiant).orElse(null);

    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {


            boolean exists =EtudiantRepository.existsById(idEtudiant);
            if(!exists) {

                throw new IllegalStateException (
                        "Etudiant with id" +idEtudiant + "does not exists");
            }

        EtudiantRepository.deleteById(idEtudiant);

        }

    public List<Etudiant> findByDepartementIdDepart(Integer idDepart) {

        return         EtudiantRepository.findByDepartementIdDepart(idDepart);


    }
    public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId)  {

        Etudiant etudiant = EtudiantRepository.findById(etudiantId).orElse(null);
        Departement departement= DepartementRepository.findById(departementId).orElse(null);

        etudiant.setDepartement(departement);
        EtudiantRepository.save(etudiant);
    }



    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat c =ContratRepository.findById(Long.valueOf(idContrat)).orElse(null)  ;
        Equipe equipe = EquipeRepository.findById(idEquipe).orElse(null);
        c.setEtudiant(e);
        equipe.getEtudiant().add(e);
        EtudiantRepository.save(e);
        return e ;


    }

    }
