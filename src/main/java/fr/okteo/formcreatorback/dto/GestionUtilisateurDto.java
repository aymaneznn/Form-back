package fr.okteo.formcreatorback.dto;

import fr.okteo.formcreatorback.model.GestionUtilisateur;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link GestionUtilisateur}
 */
@Value
public class GestionUtilisateurDto implements Serializable {
    Integer id;
    FormulaireDto formulaire;
    Integer utilisateurId;
    String permission;
}