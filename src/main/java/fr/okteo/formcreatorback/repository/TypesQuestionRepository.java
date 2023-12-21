package fr.okteo.formcreatorback.repository;

import fr.okteo.formcreatorback.model.TypesQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypesQuestionRepository extends JpaRepository<TypesQuestion,Integer> {

    //public List<TypesQuestion> findAllByQuestionsId(Integer id);
}
