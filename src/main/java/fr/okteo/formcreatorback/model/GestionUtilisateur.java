package fr.okteo.formcreatorback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gestion_utilisateur")
public class GestionUtilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gestion_utilisateur_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formulaire_id")
    private Formulaire formulaire;

    @Column(name = "utilisateur_id")
    private Integer utilisateurId;

    @Column(name = "permission")
    private String permission;

}