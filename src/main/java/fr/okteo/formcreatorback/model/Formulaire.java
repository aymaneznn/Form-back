package fr.okteo.formcreatorback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "formulaire")
public class Formulaire {
    @Id
    @Column(name = "formulaire_id", nullable = false, length = Integer.MAX_VALUE)
    private String formulaireId;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creer_par")
    private Utilisateur creerPar;

    @Column(name = "creer_le")
    private LocalDate creerLe;

    @Column(name = "modifie_le")
    private LocalDate modifieLe;

    public void setId(String id) {
        this.formulaireId = id;
    }

    public String getId() {
        return this.formulaireId;
    }
}