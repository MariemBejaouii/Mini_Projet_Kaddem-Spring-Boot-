package tn.esprit.spring.ServicesInterface;

import tn.esprit.spring.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {

    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant (Etudiant e);
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);
    void removeEtudiant(Integer idEtudiant);
    List<Etudiant> findByDepartementIdDepart(Integer idDepart);

     void assignEtudiantToDepartement (Integer etudiantId, Integer departementId) ;

    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);



    }
