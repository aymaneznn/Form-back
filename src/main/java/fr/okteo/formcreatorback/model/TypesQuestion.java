package fr.okteo.formcreatorback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "types_question")
public class TypesQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "types_question", nullable = false)
    private Integer id;

    @Column(name = "type")
    private String type;

}