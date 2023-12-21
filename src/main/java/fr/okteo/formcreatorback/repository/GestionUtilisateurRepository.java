package fr.okteo.formcreatorback.repository;


import fr.okteo.formcreatorback.model.GestionUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GestionUtilisateurRepository extends JpaRepository<GestionUtilisateur,Integer> {

    public List<GestionUtilisateur> findAllByFormulaireId(Integer id);
}
