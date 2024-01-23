package fr.okteo.formcreatorback.service;

import fr.okteo.formcreatorback.dto.*;
import fr.okteo.formcreatorback.dto.mapper.*;
import fr.okteo.formcreatorback.model.*;
import fr.okteo.formcreatorback.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FormulaireService {

    private final FormulaireRepository formulaireRepository;
    private final QuestionRepository questionRepository;
    private final ReponseRepository reponseRepository;
    private final ParametreAvanceRepository parametreAvanceRepository;
    private final DonneesStatistiqueRepository donneesStatistiqueRepository;
    private final GestionUtilisateurRepository gestionUtilisateurRepository;
    private final TypeQuestionRepository typesQuestionRepository;

    private final FormulaireMapper formulaireMapper;
    private final QuestionMapper questionMapper;
    private final ReponseMapper reponseMapper;
    private final TypesQuestionMapper typesQuestionMapper;
    private final ParametrageAvanceMapper parametrageAvanceMapper;
    private final DonneesStatistiqueMapper donneesStatistiqueMapper;
    private final GestionUtilisateurMapper gestionUtilisateurMapper;
    private final UtilisateurRepository utilisateurRepository;

    public Object getAllFormulaires() {
        try {
            return formulaireMapper.entityToDTOList(formulaireRepository.findAll());
        } catch (Exception e) {
            String errorMessage = "Erreur lors de la récupération de tous les formulaires : " + e.getMessage();
            return String.valueOf(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage));
        }
    }

    public ResponseEntity<String> createFormulaire(FormulaireDto formulaireDto) {
        try {
            // Vérifier si l'utilisateur associé au formulaire existe
            Utilisateur existingUser = utilisateurRepository.findById(formulaireDto.getCreerPar().getId())
                    .orElseThrow(() -> new EntityNotFoundException("L'utilisateur associé au formulaire n'existe pas"));

            // Créer le formulaire
            Formulaire formulaire = formulaireMapper.dtoToEntity(formulaireDto);
            formulaire.setCreerPar(existingUser);
            formulaireRepository.save(formulaire);

            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            // Exception si l'utilisateur associé n'est pas trouvé
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // Autres exceptions imprévues
            String errorMessage = "Erreur lors de la création du formulaire : " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    public ResponseEntity<String> deleteFormulaireByID(Integer formulaireId) {
        try {
            formulaireRepository.deleteById(formulaireId);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Formulaire non trouvé pour l'ID : " + formulaireId);
        } catch (Exception e) {
            String errorMessage = "Erreur lors de la suppression du formulaire : " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
    public List<QuestionDto> getQuestionsByFormulaire(Integer id){
        return questionMapper.entityToDTOList(questionRepository.findAllByFormulaireId(id));
    }
    public TypesQuestionDto getTypeQuestionByQuestion(Integer id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found for ID: " + id));

        return typesQuestionMapper.entityToDTO(question.getTypeQuestion());
    }
    public ResponseEntity<String> createQuestion(QuestionDto questionDto) {
        try {
            // Vérifier si le formulaire associé à la question existe
            Formulaire existingFormulaire = formulaireRepository.findById(questionDto.getFormulaire().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Le formulaire associé à la question n'existe pas"));

            // Vérifier si le type de question existe
            TypesQuestion existingTypeQuestion = typesQuestionRepository.findById(questionDto.getTypeQuestion().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Le type de question n'existe pas"));

            // Créer la question
            Question question = questionMapper.dtoToEntity(questionDto);
            question.setFormulaire(existingFormulaire);
            question.setTypeQuestion(existingTypeQuestion);
            questionRepository.save(question);

            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            // Exception si une entité associée n'est pas trouvée
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // Autres exceptions imprévues
            String errorMessage = "Erreur lors de la création de la question : " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
    public ResponseEntity<Void> deleteQuestionByID(Integer questionId) {
        questionRepository.deleteById(questionId);
        return ResponseEntity.ok().build();
    }
    public List<ReponseDto> getReponsesByQuestion(Integer id){
        return reponseMapper.entityToDTOList(reponseRepository.findAllByQuestionId(id));
    }
    public List<ReponseDto> getReponsesByFormulaire(Integer id){
        return reponseMapper.entityToDTOList(reponseRepository.findAllByFormulaireId(id));
    }
    public ResponseEntity<Void> createReponse(ReponseDto reponseDto) {
        Reponse reponse = reponseMapper.dtoToEntity(reponseDto);
        reponseRepository.save(reponse);
        return ResponseEntity.ok().build();
    }
    public ResponseEntity<Void> deleteReponseByID(Integer reponseId) {
        reponseRepository.deleteById(reponseId);
        return ResponseEntity.ok().build();
    }
    public List<ParametrageAvanceDto> getParametreAvanceByFormulaire(Integer id){
        return parametrageAvanceMapper.entityToDTOList(parametreAvanceRepository.findAllByFormulaireId(id));
    }
    public List<DonneesStatistiqueDto> getDonneesStatistiquesByFormulaire(Integer id){
        return donneesStatistiqueMapper.entityToDTOList(donneesStatistiqueRepository.findAllByFormulaireId(id));
    }
    public List<GestionUtilisateurDto> getGestionUtilisateurByFormulaire(Integer id){
        return gestionUtilisateurMapper.entityToDTOList(gestionUtilisateurRepository.findAllByFormulaireId(id));
    }
}
