package fr.okteo.formcreatorback.controller;
import fr.okteo.formcreatorback.dto.QuestionDto;
import fr.okteo.formcreatorback.dto.ResponseModel;
import fr.okteo.formcreatorback.service.FormulaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.Callable;


@RestController
@RequestMapping("/question")
public class QuestionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);

    private final FormulaireService formulaireService;

    public QuestionController(FormulaireService formulaireService) {
        this.formulaireService = formulaireService;
    }

    @GetMapping(value = {"/get-questions-by-formulaire/{idFormulaire}"})
    public ResponseEntity<ResponseModel> getQuestionsByFormulaire(@PathVariable Integer idFormulaire) {
        Callable<Object> f = () -> formulaireService.getQuestionsByFormulaire(idFormulaire);
        return ResponseController.creerResponseEntity(f, LOGGER, new ArrayList<>());
    }

    @GetMapping(value = {"/get-types-questions-by-question/{idQuestion}"})
    public ResponseEntity<ResponseModel> getTypesQuestionsByQuestion(@PathVariable Integer idQuestion) {
        Callable<Object> f = () -> formulaireService.getTypeQuestionByQuestion(idQuestion);
        return ResponseController.creerResponseEntity(f, LOGGER, new ArrayList<>());
    }

    @GetMapping(value = {"/create-question"})
    public ResponseEntity<ResponseModel> saveQuestion(@RequestBody QuestionDto questionDto) {
        Callable<Object> f = () -> formulaireService.createQuestion(questionDto);
        return ResponseController.creerResponseEntity(f, LOGGER, new ArrayList<>());
    }

    @GetMapping(value = {"/delete-question/{idQuestion}"})
    public ResponseEntity<ResponseModel> deleteQuestion(@PathVariable Integer idQuestion) {
        Callable<Object> f = () -> formulaireService.deleteQuestionByID(idQuestion);
        return ResponseController.creerResponseEntity(f, LOGGER, new ArrayList<>());
    }
}
