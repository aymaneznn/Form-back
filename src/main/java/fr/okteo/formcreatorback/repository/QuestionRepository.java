package fr.okteo.formcreatorback.repository;

import fr.okteo.formcreatorback.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    @Query("SELECT q FROM Question q WHERE q.formulaire.formulaireId = :id")
    List<Question> findAllByFormulaireId(String id);
}
