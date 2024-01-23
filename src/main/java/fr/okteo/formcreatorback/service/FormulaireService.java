package fr.okteo.formcreatorback.service;

import fr.okteo.formcreatorback.dto.*;
import fr.okteo.formcreatorback.dto.mapper.*;
import fr.okteo.formcreatorback.model.*;
import fr.okteo.formcreatorback.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
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

    private final FormulaireMapper formulaireMapper;
    private final QuestionMapper questionMapper;
    private final ReponseMapper reponseMapper;
    private final TypesQuestionMapper typesQuestionMapper;
    private final ParametrageAvanceMapper parametrageAvanceMapper;
    private final DonneesStatistiqueMapper donneesStatistiqueMapper;
    private final GestionUtilisateurMapper gestionUtilisateurMapper;

    public List<FormulaireDto> getAllFormulaires(){
        return formulaireMapper.entityToDTOList(formulaireRepository.findAll());
    }
    public ResponseEntity<Void> createFormulaire(FormulaireDto formulaireDto) {
        Formulaire formulaire = formulaireMapper.dtoToEntity(formulaireDto);
        formulaireRepository.save(formulaire);
        return ResponseEntity.ok().build();
    }
    public ResponseEntity<Void> deleteFormulaireByID(Integer formulaireId) {
        formulaireRepository.deleteById(formulaireId);
        return ResponseEntity.ok().build();
    }
    public List<QuestionDto> getQuestionsByFormulaire(Integer id){
        return questionMapper.entityToDTOList(questionRepository.findAllByFormulaireId(id));
    }
    public TypesQuestionDto getTypeQuestionByQuestion(Integer id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found for ID: " + id));

        return typesQuestionMapper.entityToDTO(question.getTypeQuestion());
    }
    public ResponseEntity<Void> createQuestion(QuestionDto questionDto) {
        Question question = questionMapper.dtoToEntity(questionDto);
        questionRepository.save(question);
        return ResponseEntity.ok().build();
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
