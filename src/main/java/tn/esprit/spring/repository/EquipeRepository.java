package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Integer> {
}