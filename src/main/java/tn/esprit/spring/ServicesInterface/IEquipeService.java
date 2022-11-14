package tn.esprit.spring.ServicesInterface;

import tn.esprit.spring.entity.Equipe;
import java.util.List;

public interface IEquipeService {
    List<Equipe> retrieveAllEquipes();
    Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail
    Equipe updateEquipe (Equipe e);
    Equipe retrieveEquipe (Integer idEquipe);

    void removeEquipe(Integer equipeId);

    //void removeEquipe(Integer equipeId);
}
