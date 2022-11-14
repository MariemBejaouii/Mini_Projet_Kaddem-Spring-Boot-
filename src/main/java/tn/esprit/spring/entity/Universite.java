package tn.esprit.spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
@Getter
@Setter
@Entity
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUniv")
    private Integer idUniv;

    private String nomUniv;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> departement;



}
