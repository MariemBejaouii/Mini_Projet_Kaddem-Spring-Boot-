package tn.esprit.spring.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

import java.util.Set;

@Getter
@Setter
@Entity
@Table( name = "Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Integer idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option op;

    @ManyToOne
    Departement departement;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
    private Set<Contrat> Contrat;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Equipe> equipe;

    public void setDepartement(Departement departement) {

        this.departement=departement;
    }


}