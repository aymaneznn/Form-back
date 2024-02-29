package fr.okteo.formcreatorback.repository;

import fr.okteo.formcreatorback.model.ParametrageAvance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParametreAvanceRepository extends JpaRepository<ParametrageAvance,Integer> {

    @Query("SELECT q FROM ParametrageAvance q WHERE q.formulaire.formulaireId = :id")
    List<ParametrageAvance> findAllByFormulaireId(String id);
}
