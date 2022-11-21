package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.entity.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
/*
    @("select count(c) from Contrat c where 0 "
public Integer nbContratsValides(@Param("sDate") Date startDate , @Param("eDate") Date endDate);
*/

}