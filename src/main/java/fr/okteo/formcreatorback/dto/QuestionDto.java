package fr.okteo.formcreatorback.dto;

import fr.okteo.formcreatorback.dto.FormulaireDto;
import fr.okteo.formcreatorback.dto.TypesQuestionDto;
import fr.okteo.formcreatorback.model.Question;
import lombok.Value;

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
    String optionsQuestion;
    Boolean obligatoire;
}