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

    public ResponseEntity<String> deleteFormulaireByID(String formulaireId) {
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
    public List<QuestionDto> getQuestionsByFormulaire(String id) {
        try {
            return questionMapper.entityToDTOList(questionRepository.findAllByFormulaireId(id));
        } catch (Exception e) {
            String errorMessage = "Erreur lors de la récupération des questions pour le formulaire avec l'ID " + id + ": " + e.getMessage();
            throw new RuntimeException(errorMessage, e);
        }
    }

    public TypesQuestionDto getTypeQuestionByQuestion(Integer id) {
        try {
            Question question = questionRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Question not found for ID: " + id));

            return typesQuestionMapper.entityToDTO(question.getTypeQuestion());
        } catch (EntityNotFoundException e) {
            String errorMessage = "Question non trouvée pour l'ID : " + id;
            throw new RuntimeException(errorMessage, e);
        } catch (Exception e) {
            String errorMessage = "Erreur lors de la récupération du type de question pour la question avec l'ID " + id + ": " + e.getMessage();
            throw new RuntimeException(errorMessage, e);
        }
    }
    public ResponseEntity<String> createQuestion(QuestionDto questionDto) {
        try {
            // Vérifier si le formulaire associé à la question existe
            List<Formulaire> existingFormulaire = formulaireRepository.findAllByFormulaireId(questionDto.getFormulaire().getId());

            // Vérifier si le type de question existe
            TypesQuestion existingTypeQuestion = typesQuestionRepository.findById(questionDto.getTypeQuestion().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Le type de question n'existe pas"));

            // Créer la question
            Question question = questionMapper.dtoToEntity(questionDto);
            question.setFormulaire(existingFormulaire.get(0));
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
    public List<ReponseDto> getReponsesByFormulaire(String id){
        return reponseMapper.entityToDTOList(reponseRepository.findAllByFormulaireId(id));
    }
    public ResponseEntity<String> createReponse(ReponseDto reponseDto) {
        try {
            // Your existing logic to convert DTO to Entity and save in the repository
            Reponse reponse = reponseMapper.dtoToEntity(reponseDto);
            reponseRepository.save(reponse);

            // Return success response with HTTP status 200
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            // Handle entity not found exception (HTTP status 400)
            String errorMessage = "Error creating response: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage + " : " + e.getMessage());
        } catch (Exception e) {
            // Handle other unexpected errors (HTTP status 500)
            String errorMessage = "Error creating response: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
    public ResponseEntity<Void> deleteReponseByID(Integer reponseId) {
        reponseRepository.deleteById(reponseId);
        return ResponseEntity.ok().build();
    }
    public List<ParametrageAvanceDto> getParametreAvanceByFormulaire(String id){
        return parametrageAvanceMapper.entityToDTOList(parametreAvanceRepository.findAllByFormulaireId(id));
    }
    public List<DonneesStatistiqueDto> getDonneesStatistiquesByFormulaire(String id){
        return donneesStatistiqueMapper.entityToDTOList(donneesStatistiqueRepository.findAllByFormulaireId(id));
    }
    public List<GestionUtilisateurDto> getGestionUtilisateurByFormulaire(String id){
        return gestionUtilisateurMapper.entityToDTOList(gestionUtilisateurRepository.findAllByFormulaireId(id));
    }
}
