package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.DetailEquipe;

public interface DetailEquipeRepository extends JpaRepository<DetailEquipe, Integer> {
}