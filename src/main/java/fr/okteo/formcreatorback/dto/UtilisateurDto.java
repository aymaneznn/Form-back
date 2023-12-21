package fr.okteo.formcreatorback.dto;

import fr.okteo.formcreatorback.model.Utilisateur;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Utilisateur}
 */
@Value
public class UtilisateurDto implements Serializable {
    Integer id;
    String nom;
    String prenom;
    String password;
}