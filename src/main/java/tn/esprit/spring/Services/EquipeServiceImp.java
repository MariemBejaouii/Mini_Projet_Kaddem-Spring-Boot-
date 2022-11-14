package tn.esprit.spring.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.spring.ServicesInterface.IEquipeService;
import tn.esprit.spring.entity.Equipe;
import tn.esprit.spring.repository.EquipeRepository;

import java.util.List;
@Slf4j
@Service
public class EquipeServiceImp  implements IEquipeService {

    EquipeRepository EquipeRepository;
    @Override
    public List<Equipe> retrieveAllEquipes() {
        List<Equipe> Equipes=EquipeRepository.findAll();
        for(Equipe e:Equipes) {
            //System.out.println(e);
            log.info(e.toString());
        }
        return Equipes;
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return  EquipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return  EquipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return EquipeRepository.findById(idEquipe).orElse(null);
    }

/*
    @Override
    void removeEquipe(Integer equipeId) {
    }*/

    @Override
    public void removeEquipe(Integer equipeId) {
        boolean exists =EquipeRepository.existsById
                (equipeId);
        if(!exists) {

            throw new IllegalStateException (
                    "Equipe with id" +equipeId + "does not exists");
        }

        EquipeRepository.deleteById(equipeId);

    }
}
