package tn.esprit.spring.ServicesInterface;

import tn.esprit.spring.entity.Departement;
import java.util.List;

public interface IDepartementService {
    List<Departement> retrieveAllDepartements();
    Departement addDepartement (Departement d);
    Departement updateDepartement (Departement d);
    Departement retrieveDepartement (Integer idDepart);

    void removeDepartement(Integer departementId);
}
