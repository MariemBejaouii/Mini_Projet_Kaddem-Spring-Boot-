package tn.esprit.spring.ServicesInterface;

import tn.esprit.spring.entity.Contrat;
import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();
    Contrat updateContrat (Contrat ce);
    Contrat addContrat (Contrat ce);
    Contrat retrieveContrat (Integer idContrat);
    void removeContrat(Integer idContrat);
}
