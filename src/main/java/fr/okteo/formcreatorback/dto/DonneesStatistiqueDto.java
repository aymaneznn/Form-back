package fr.okteo.formcreatorback.dto;

import fr.okteo.formcreatorback.model.DonneesStatistique;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link DonneesStatistique}
 */
@Value
public class DonneesStatistiqueDto implements Serializable {
    Integer id;
    FormulaireDto formulaire;
    String intervalleDeTemps;
    String nomDonnee;
    String donnees;
}