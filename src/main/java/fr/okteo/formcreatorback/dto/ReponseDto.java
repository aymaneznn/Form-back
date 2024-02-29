package fr.okteo.formcreatorback.dto;

import fr.okteo.formcreatorback.dto.FormulaireDto;
import fr.okteo.formcreatorback.dto.QuestionDto;
import fr.okteo.formcreatorback.dto.TypesQuestionDto;
import fr.okteo.formcreatorback.dto.UtilisateurDto;
import fr.okteo.formcreatorback.model.Reponse;
import lombok.Value;

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
    String idGroupReponse;
}