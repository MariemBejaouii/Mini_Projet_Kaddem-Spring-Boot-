package tn.esprit.spring.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.spring.ServicesInterface.IContratService;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EtudiantRepository;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class ContratServiceImp implements IContratService {

    ContratRepository ContratRepository;
    EtudiantRepository  EtudiantRepository;
    @Override
    public List<Contrat> retrieveAllContrats() {
        List<Contrat> contrats=ContratRepository.findAll();
        for(Contrat c:contrats) {
            //System.out.println(e);
            log.info(c.toString());
        }
        return contrats;
    }


    @Override
    public Contrat updateContrat(Contrat ce) {
        return  ContratRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return  ContratRepository.save(ce);    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return ContratRepository.findById(Long.valueOf(idContrat)).orElse(null);

    }

    @Override
    public void removeContrat(Integer idContrat) {
        boolean exists =ContratRepository.existsById
                (Long.valueOf(idContrat));
        if(!exists) {

            throw new IllegalStateException (
                    "contrat with id" +idContrat + "does not exists");
        }

        ContratRepository.deleteById(Long.valueOf(idContrat));

    }

    public Contrat affectContratToEtudiant(Integer idContrat , String nomE , String prenomE) {

        Etudiant e=EtudiantRepository.finfByNomLikeAndPrenomLike(nomE ,prenomE);
        Contrat c=ContratRepository.findById(Long.valueOf(idContrat)).get();

        Set<Contrat> contrats=e.getContrat();
        int nbContratsActifs=0;

        if(!contrats.isEmpty()) {
            for(Contrat contrat:contrats) {
                if(((contrat.getArchive())!=null) && (!(contrat.getArchive()))) {
                    nbContratsActifs++;
                }
            }

        }
        if(nbContratsActifs<=4) {
            c.setEtudiant(e);
            ContratRepository.save(c);
        }
        return c;

    }
}
