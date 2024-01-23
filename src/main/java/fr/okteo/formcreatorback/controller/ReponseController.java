package fr.okteo.formcreatorback.controller;
import fr.okteo.formcreatorback.dto.ReponseDto;
import fr.okteo.formcreatorback.dto.ResponseModel;
import fr.okteo.formcreatorback.service.FormulaireService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.Callable;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reponse")
public class ReponseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReponseController.class);

    private final FormulaireService formulaireService;

    @GetMapping(value = {"/get-reponses-by-question/{idQuestion}"})
    public ResponseEntity<ResponseModel> getReponsesByQuestion(@PathVariable Integer idQuestion) {
        Callable<Object> f = () -> formulaireService.getReponsesByQuestion(idQuestion);
        return ResponseController.creerResponseEntity(f, LOGGER, new ArrayList<>());
    }

    @GetMapping(value = {"/get-reponses-by-formulaire/{idFormulaire}"})
    public ResponseEntity<ResponseModel> getReponsesByFormulaire(@PathVariable Integer idFormulaire) {
        Callable<Object> f = () -> formulaireService.getReponsesByFormulaire(idFormulaire);
        return ResponseController.creerResponseEntity(f, LOGGER, new ArrayList<>());
    }

    @PostMapping(value = {"/create-reponse"})
    public ResponseEntity<ResponseModel> saveReponse(@RequestBody ReponseDto reponseDto) {
        Callable<Object> f = () -> formulaireService.createReponse(reponseDto);
        return ResponseController.creerResponseEntity(f, LOGGER, new ArrayList<>());
    }

    @DeleteMapping(value = {"/delete-reponse/{idReponse}"})
    public ResponseEntity<ResponseModel> deleteReponse(@PathVariable Integer idReponse) {
        Callable<Object> f = () -> formulaireService.deleteReponseByID(idReponse);
        return ResponseController.creerResponseEntity(f, LOGGER, new ArrayList<>());
    }
}
