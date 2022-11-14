package tn.esprit.spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
public class Contrat {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private Long idContrat; // Clé primaire

    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;

    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    private Boolean archive;

    private Integer montantContrat;

    @ManyToOne
    Etudiant etudiant;



}
