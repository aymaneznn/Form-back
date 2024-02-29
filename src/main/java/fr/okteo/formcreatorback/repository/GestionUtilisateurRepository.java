package fr.okteo.formcreatorback.repository;


import fr.okteo.formcreatorback.model.GestionUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GestionUtilisateurRepository extends JpaRepository<GestionUtilisateur,Integer> {

    @Query("SELECT q FROM GestionUtilisateur q WHERE q.formulaire.formulaireId = :id")
    List<GestionUtilisateur> findAllByFormulaireId(String id);
}
