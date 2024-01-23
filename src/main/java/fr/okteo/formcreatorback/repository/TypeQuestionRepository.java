package fr.okteo.formcreatorback.repository;


import fr.okteo.formcreatorback.model.TypesQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeQuestionRepository extends JpaRepository<TypesQuestion,Integer> {

}
