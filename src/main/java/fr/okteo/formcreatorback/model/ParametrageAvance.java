package fr.okteo.formcreatorback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "parametrage_avance")
public class ParametrageAvance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parametrage_statistiques_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formulaire_id")
    private Formulaire formulaire;

    @Column(name = "donnees")
    private String donnees;

}