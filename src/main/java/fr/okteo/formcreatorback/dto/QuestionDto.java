package fr.okteo.formcreatorback.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link fr.okteo.formcreatorback.model.Question}
 */
@Value
public class QuestionDto implements Serializable {
    Integer id;
    FormulaireDto formulaire;
    String question;
    TypesQuestionDto typeQuestion;
    String optionsQuestion;
}