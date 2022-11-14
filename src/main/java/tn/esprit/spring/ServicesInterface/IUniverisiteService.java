package tn.esprit.spring.ServicesInterface;
import tn.esprit.spring.entity.Universite;
import java.util.List;
public interface IUniverisiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);

    void removeUniversite(Integer universiteId);

    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
