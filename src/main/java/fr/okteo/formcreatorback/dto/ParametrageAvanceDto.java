package fr.okteo.formcreatorback.dto;

import fr.okteo.formcreatorback.model.ParametrageAvance;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ParametrageAvance}
 */
@Value
public class ParametrageAvanceDto implements Serializable {
    Integer id;
    FormulaireDto formulaire;
    String donnees;
}