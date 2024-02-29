package fr.okteo.formcreatorback.repository;

import fr.okteo.formcreatorback.model.Formulaire;
import fr.okteo.formcreatorback.model.GestionUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormulaireRepository extends JpaRepository<Formulaire,String> {


    @Query("SELECT q FROM Formulaire q WHERE q.formulaireId = :id")
    List<Formulaire> findAllByFormulaireId(String id);

}
