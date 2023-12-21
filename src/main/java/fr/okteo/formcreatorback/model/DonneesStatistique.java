package fr.okteo.formcreatorback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "donnees_statistiques")
public class DonneesStatistique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donnees_statistiques_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formulaire_id")
    private Formulaire formulaire;

    @Column(name = "intervalle_de_temps")
    private String intervalleDeTemps;

    @Column(name = "nom_donnee")
    private String nomDonnee;

    @Column(name = "donnees")
    private String donnees;

}