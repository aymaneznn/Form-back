package fr.okteo.formcreatorback.dto;


import lombok.Value;

import fr.okteo.formcreatorback.model.Reponse;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

/**
 * DTO for {@link Reponse}
 */
@Value
public class ReponseDto implements Serializable {
    Integer id;
    FormulaireDto formulaire;
    QuestionDto question;
    TypesQuestionDto typeReponse;
    UtilisateurDto utilisateur;
    LocalDate posterLe;
    Map<String, Object> donneesReponse;
}