package fr.okteo.formcreatorback.service;

import fr.okteo.formcreatorback.dto.FormulaireDto;
import fr.okteo.formcreatorback.model.*;
import fr.okteo.formcreatorback.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FormulaireService {
    private final FormulaireRepository formulaireRepository;
    private final QuestionRepository questionRepository;
    private final ReponseRepository reponseRepository;
    private final TypesQuestionRepository typesQuestionRepository;
    private final ParametreAvanceRepository parametreAvanceRepository;
    private final DonneesStatistiqueRepository donneesStatistiqueRepository;
    private final GestionUtilisateurRepository gestionUtilisateurRepository;

    //private final FormulaireMapper formulaireMapper;

    public FormulaireService(FormulaireRepository formulaireRepository, QuestionRepository questionRepository, ReponseRepository reponseRepository, TypesQuestionRepository typesQuestionRepository, ParametreAvanceRepository parametreAvanceRepository, DonneesStatistiqueRepository donneesStatistiqueRepository, GestionUtilisateurRepository gestionUtilisateurRepository/*FormulaireMapper formulaireMapper*/) {
        this.formulaireRepository = formulaireRepository;
        this.questionRepository = questionRepository;
        this.reponseRepository = reponseRepository;
        this.typesQuestionRepository = typesQuestionRepository;
        this.parametreAvanceRepository = parametreAvanceRepository;
        this.donneesStatistiqueRepository = donneesStatistiqueRepository;
        this.gestionUtilisateurRepository = gestionUtilisateurRepository;
        //this.formulaireMapper = formulaireMapper;
    }

    public List<FormulaireDto> getAllFormulaires(){
        //formulaireMapper.entityToDTOList(formulaireRepository.findAll());
        return null;
    }
    public List<Question> getQuestionsByFormulaire(Integer id){
        return questionRepository.findAllByFormulaireId(id);
    }
    public List<Reponse> getReponsesByQuestion(Integer id){
        return reponseRepository.findAllByQuestionId(id);
    }
    /*public List<TypesQuestion> getTypeQuestionByQuestion(Integer id){
        return typesQuestionRepository.findAllByQuestionsId(id);
    }*/
    public List<ParametrageAvance> getParametreAvanceByFormulaire(Integer id){
        return parametreAvanceRepository.findAllByFormulaireId(id);
    }
    public List<DonneesStatistique> getDonneesStatistiquesByFormulaire(Integer id){
        return donneesStatistiqueRepository.findAllByFormulaireId(id);
    }
    public List<GestionUtilisateur> getGestionUtilisateurByFormulaire(Integer id){
        return gestionUtilisateurRepository.findAllByFormulaireId(id);
    }
    public List<Reponse> getReponsesByFormulaire(Integer id){
        return reponseRepository.findAllByFormulaireId(id);
    }

    public ResponseEntity<Void> createFormulaire(FormulaireDto formulaire) {
        /*Formulaire formulaire1 = formulaireMapper.dtoToEntity(formulaire);
        formulaireRepository.save(formulaire1);*/
        return null;
    }

    public ResponseEntity<Void> createQuestion(Question question) {
        questionRepository.save(question);
        return null;
    }

    public ResponseEntity<Void> createReponse(Reponse reponse) {
        reponseRepository.save(reponse);
        return null;
    }

    public ResponseEntity<Void> deleteFormulaireByID(Integer formulaireId) {
        formulaireRepository.deleteById(formulaireId);
        return null;
    }

    public ResponseEntity<Void> deleteQuestionByID(Integer questionId) {
        questionRepository.deleteById(questionId);
        return null;
    }

    public ResponseEntity<Void> deleteReponseByID(Integer reponseId) {
        reponseRepository.deleteById(reponseId);
        return null;
    }
}
