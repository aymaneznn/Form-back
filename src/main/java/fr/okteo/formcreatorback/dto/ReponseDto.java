package fr.okteo.formcreatorback.dto;

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
    String formulaireId;
    Integer questionId;
    Integer typeReponseId;
    Integer utilisateurId;
    LocalDate posterLe;
    Map<String, Object> donneesReponse;
    String idGroupReponse;
}