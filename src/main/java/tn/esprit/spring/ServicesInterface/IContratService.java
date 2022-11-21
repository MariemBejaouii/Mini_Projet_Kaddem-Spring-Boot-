package tn.esprit.spring.ServicesInterface;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.spring.entity.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {
    List<Contrat> retrieveAllContrats();
    Contrat updateContrat (Contrat ce);
    Contrat addContrat (Contrat ce);
    Contrat retrieveContrat (Integer idContrat);
    void removeContrat(Integer idContrat);
  //  public Integer getnbContratsValides(@PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                    //    Date startDate,
                                    //    @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                   //     Date endDate);
}
