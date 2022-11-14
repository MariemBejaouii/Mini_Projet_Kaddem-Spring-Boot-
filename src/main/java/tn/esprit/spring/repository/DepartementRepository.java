package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}