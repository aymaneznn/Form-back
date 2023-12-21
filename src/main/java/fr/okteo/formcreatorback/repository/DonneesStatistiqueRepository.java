package fr.okteo.formcreatorback.repository;



import fr.okteo.formcreatorback.model.DonneesStatistique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonneesStatistiqueRepository extends JpaRepository<DonneesStatistique,Integer> {

    public List<DonneesStatistique> findAllByFormulaireId(Integer id);
}
