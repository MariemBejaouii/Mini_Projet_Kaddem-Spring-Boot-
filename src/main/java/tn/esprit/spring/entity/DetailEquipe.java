package tn.esprit.spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class DetailEquipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDetailEquipe")
    private Integer idDetailEquipe;

    private Integer salle;

    private String thematique;

    @OneToOne(mappedBy="detailEquipe")
    private Equipe equipe;



}
