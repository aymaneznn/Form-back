package fr.okteo.formcreatorback.controller;

import fr.okteo.formcreatorback.dto.ResponseModel;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.Callable;

public class ResponseController {

    private ResponseController() {
    }
    public static <T> ResponseEntity<ResponseModel> creerResponseEntity(Callable<T> fonction, Logger logger, List<Class<? extends Exception>> typesExceptionsMetier) {
        return creerResponseEntity(fonction, logger, typesExceptionsMetier, false);
    }
    public static <T> ResponseEntity<ResponseModel> creerResponseEntity(Callable<T> fonction, Logger logger, List<Class<? extends Exception>> typesExceptionsMetier, boolean pagination) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setSuccessful(false);

        try {
            if (pagination) {
                T resultat = fonction.call();
                responseModel.setBody(((Page) resultat).getContent());
            }else {
                responseModel.setBody(fonction.call());
            }
            responseModel.setSuccessful(true);
        } catch (Exception e) {
            if (typesExceptionsMetier.stream().anyMatch(t -> t.equals(e.getClass()))) {
                if (EntityNotFoundException.class.equals(e.getClass())) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
                responseModel.setMessage(e.getMessage());
            } else {
                logger.error("Erreur non gérée", e);
                responseModel.setMessage("Erreur non gérée");

            }
        }
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}
