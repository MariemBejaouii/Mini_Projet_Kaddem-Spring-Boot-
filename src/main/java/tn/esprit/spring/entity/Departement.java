package tn.esprit.spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDepart")
    private Integer idDepart;

    private String nomDepart;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
    private Set<Etudiant> etudiant;
}
