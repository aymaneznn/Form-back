package fr.okteo.formcreatorback.dto;

import lombok.Value;

import fr.okteo.formcreatorback.model.Question;
import java.io.Serializable;

/**
 * DTO for {@link Question}
 */
@Value
public class QuestionDto implements Serializable {
    Integer id;
    FormulaireDto formulaire;
    String question;
    TypesQuestionDto typeQuestion;
}