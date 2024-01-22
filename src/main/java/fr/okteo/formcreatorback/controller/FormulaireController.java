package fr.okteo.formcreatorback.controller;

import fr.okteo.formcreatorback.dto.FormulaireDto;

import fr.okteo.formcreatorback.dto.ResponseModel;
import fr.okteo.formcreatorback.service.FormulaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.Callable;


@RestController
@RequestMapping("/formulaire")
public class FormulaireController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormulaireController.class);

    private final FormulaireService formulaireService;

    public FormulaireController(FormulaireService formulaireService) {
        this.formulaireService = formulaireService;
    }

    @GetMapping(value = {"/all"})
    public ResponseEntity<ResponseModel> getAllFormulaires() {
        Callable<Object> f = formulaireService::getAllFormulaires;
        return ResponseController.creerResponseEntity(f, LOGGER, new ArrayList<>());
    }

    @GetMapping(value = {"/create-formulaire"})
    public ResponseEntity<ResponseModel> saveFormulaire(@RequestBody FormulaireDto formulaireDto) {
        Callable<Object> f = () -> formulaireService.createFormulaire(formulaireDto);
        return ResponseController.creerResponseEntity(f, LOGGER, new ArrayList<>());
    }

    @GetMapping(value = {"/delete-formulaire/{idFormulaire}"})
    public ResponseEntity<ResponseModel> deleteFormulaire(@PathVariable Integer idFormulaire) {
        Callable<Object> f = () -> formulaireService.deleteFormulaireByID(idFormulaire);
        return ResponseController.creerResponseEntity(f, LOGGER, new ArrayList<>());
    }

    @GetMapping(value = {"/get-parametre-avance-by-formulaire/{idFormulaire}"})
    public ResponseEntity<ResponseModel> getParametrageAvanceByFormulaire(@PathVariable Integer idFormulaire) {
        Callable<Object> f = () -> formulaireService.getParametreAvanceByFormulaire(idFormulaire);
        return ResponseController.creerResponseEntity(f, LOGGER, new ArrayList<>());
    }

    @GetMapping(value = {"/get-donnees-statistique-by-formulaire/{idFormulaire}"})
    public ResponseEntity<ResponseModel> getDonneesStatistiqueByFormulaire(@PathVariable Integer idFormulaire) {
        Callable<Object> f = () -> formulaireService.getDonneesStatistiquesByFormulaire(idFormulaire);
        return ResponseController.creerResponseEntity(f, LOGGER, new ArrayList<>());
    }

    @GetMapping(value = {"/get-gestion-utilisateur-by-formulaire/{idFormulaire}"})
    public ResponseEntity<ResponseModel> getGestionUtilisateurByFormulaire(@PathVariable Integer idFormulaire) {
        Callable<Object> f = () -> formulaireService.getGestionUtilisateurByFormulaire(idFormulaire);
        return ResponseController.creerResponseEntity(f, LOGGER, new ArrayList<>());
    }
}
