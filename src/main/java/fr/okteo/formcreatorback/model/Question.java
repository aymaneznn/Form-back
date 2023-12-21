package fr.okteo.formcreatorback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formulaire_id")
    private Formulaire formulaire;

    @Column(name = "question")
    private String question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_question_id")
    private TypesQuestion typeQuestion;

}