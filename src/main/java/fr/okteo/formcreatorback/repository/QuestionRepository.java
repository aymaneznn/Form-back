package fr.okteo.formcreatorback.repository;

import fr.okteo.formcreatorback.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    List<Question>  findAllByFormulaireId(Integer id);
}
