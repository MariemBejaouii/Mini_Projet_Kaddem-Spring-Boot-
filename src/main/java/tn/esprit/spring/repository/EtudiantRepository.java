package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.entity.Niveau;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

List<Etudiant> findByDepartementIdDepart(Integer idDepart);
 // findByDepartement nom de l'association
  //  List<Etudiant> findByEquipesNiveau(Niveau niveau);

   // List <Etudiant> findByEquipeNiveauLike(Niveau SENIOR);

   @Query("select  et From Etudiant et where et.nomE =:nomE and et.prenomE =:prenomE")
    public Etudiant findByNomEAndPrenomE(@Param("nomE") String nomE , @Param("prenomE") String prenomE);


   public Etudiant findByNomELikeAndPrenomELike(String nom , String prenom);









}