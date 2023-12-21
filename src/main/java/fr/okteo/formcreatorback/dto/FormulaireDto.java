package fr.okteo.formcreatorback.dto;

import fr.okteo.formcreatorback.model.Formulaire;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Formulaire}
 */
@Value
public class FormulaireDto implements Serializable {
    Integer id;
    String titre;
    String description;
    UtilisateurDto creerPar;
    LocalDate creerLe;
    LocalDate modifieLe;
}