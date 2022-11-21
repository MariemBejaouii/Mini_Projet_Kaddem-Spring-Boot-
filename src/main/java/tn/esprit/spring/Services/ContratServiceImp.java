package tn.esprit.spring.Services;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.ServicesInterface.IContratService;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Universite;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EtudiantRepository;
import tn.esprit.spring.repository.UniversiteRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@Tag(name ="Contrat_Service")
@RestController
public class ContratServiceImp implements IContratService {

    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

    UniversiteRepository universiteRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        List<Contrat> contrats = contratRepository.findAll();
        for (Contrat c : contrats) {
            //System.out.println(e);
            log.info(c.toString());
        }
        return contrats;
    }


    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(Long.valueOf(idContrat)).orElse(null);

    }

    @Override
    public void removeContrat(Integer idContrat) {
        boolean exists = contratRepository.existsById
                (Long.valueOf(idContrat));
        if (!exists) {

            throw new IllegalStateException(
                    "contrat with id" + idContrat + "does not exists");
        }

        contratRepository.deleteById(Long.valueOf(idContrat));

    }

    public Contrat affectContratToEtudiant(Integer idContrat, String nomE, String prenomE) //on affect des etudiants au contrat car le contrat à la valeur la plus grand many to one)
    {

        Etudiant e = EtudiantRepository.findByNomELikeAndPrenomELike(nomE, prenomE);
        Contrat c = contratRepository.findById(Long.valueOf(idContrat)).get();

        Set<Contrat> contrats = e.getContrat();
        int nbContratsActifs = 0;

        if (!contrats.isEmpty()) {
            for (Contrat contrat : contrats) {
                if (((contrat.getArchive()) != null) && (!(contrat.getArchive()))) {
                    nbContratsActifs++;
                }
            }

        }
        if (nbContratsActifs <= 4) {
            c.setEtudiant(e); //j'ai un attribut etudiant (foreign key) dans le table contrat (car la relation many to one)
            contratRepository.save(c);
        }
        return c;

    }


    /*@GetMapping(value = "/getnbContratsValides/{startDate}/{endDate}")
    public Integer getnbContratsValides(@PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                            Date startDate,
                                        @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                        Date endDate)
    {

        return contratRepository.nbContratsValides(startDate, endDate);
    }*/

    public float getMontantContratEntreDeuxDate(int idUniv , Date startDate , Date endDate) {

        List<Contrat> listContrat=new ArrayList<>();
        float MontantContratEntreDeuxDate=0;
        Universite u=universiteRepository.findById(idUniv).orElse(null);

        u.getDepartement().forEach(
                department -> {
                    department.getEtudiant().forEach(
                            etudiant->etudiant.getContrat().forEach(
                                    contrat-> {
                                        listContrat.add(contrat);
                                    }
                            )
                    );
                }
        );

        List<Contrat> contrats=contratRepository.
    }
}

