package tn.esprit.spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


import java.util.Set;

@Entity
@Getter
@Setter

public class Equipe {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")

    private Integer idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau Niveau;

    @ManyToMany(mappedBy="equipe", cascade = CascadeType.ALL)
    private Set<Etudiant> etudiant;


    @OneToOne(cascade = CascadeType.ALL)
    private DetailEquipe detailEquipe;




}
