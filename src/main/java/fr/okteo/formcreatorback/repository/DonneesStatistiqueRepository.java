package fr.okteo.formcreatorback.repository;



import fr.okteo.formcreatorback.model.DonneesStatistique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonneesStatistiqueRepository extends JpaRepository<DonneesStatistique,Integer> {

    @Query("SELECT q FROM DonneesStatistique q WHERE q.formulaire.formulaireId = :id")
    List<DonneesStatistique> findAllByFormulaireId(String id);
}
