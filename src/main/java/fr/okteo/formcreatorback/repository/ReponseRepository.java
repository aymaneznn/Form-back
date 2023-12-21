package fr.okteo.formcreatorback.repository;

import fr.okteo.formcreatorback.model.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReponseRepository extends JpaRepository<Reponse,Integer> {

    public List<Reponse> findAllByQuestionId(Integer id);
    public List<Reponse> findAllByFormulaireId(Integer id);
}
