package fr.okteo.formcreatorback;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.okteo.formcreatorback.controller.FormulaireController;
import fr.okteo.formcreatorback.dto.FormulaireDto;
import fr.okteo.formcreatorback.dto.ResponseModel;
import fr.okteo.formcreatorback.dto.UtilisateurDto;
import fr.okteo.formcreatorback.service.FormulaireService;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class FormulaireControllerTest {

	private final FormulaireService formulaireService = Mockito.mock(FormulaireService.class);
	private final FormulaireController formulaireController = new FormulaireController(formulaireService);

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Test
    public void testGetAllFormulaires() throws Exception {
		when(formulaireService.getAllFormulaires()).thenReturn(new ArrayList<>());

		ResponseEntity<ResponseModel> response = formulaireController.getAllFormulaires();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
	}

	@Test
	public void testSaveFormulaire() throws Exception {
		UtilisateurDto utilisateurDto = new UtilisateurDto(1, "NomUtilisateur", "PrenomUtilisateur", "utilisateur@example.com");
		FormulaireDto formulaireDto = new FormulaireDto(1, "Formulaire de Test", "Description du formulaire de test", utilisateurDto, LocalDate.now(), LocalDate.now());

		when(formulaireService.createFormulaire(formulaireDto)).thenReturn(ResponseEntity.ok().build());

		ResponseEntity<ResponseModel> response = formulaireController.saveFormulaire(formulaireDto);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();

	}


	@Test
	public void testDeleteFormulaire() throws Exception {
		Integer idFormulaire = 1;

		when(formulaireService.deleteFormulaireByID(idFormulaire)).thenReturn(ResponseEntity.ok().build());

		ResponseEntity<ResponseModel> response = formulaireController.deleteFormulaire(idFormulaire);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
	}

	@Test
	public void testGetParametrageAvanceByFormulaire() throws Exception {
		Integer idFormulaire = 1;

		when(formulaireService.getParametreAvanceByFormulaire(idFormulaire)).thenReturn(new ArrayList<>());

		ResponseEntity<ResponseModel> response = formulaireController.getParametrageAvanceByFormulaire(idFormulaire);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
	}

	@Test
	public void testGetDonneesStatistiqueByFormulaire() throws Exception {
		Integer idFormulaire = 1;

		when(formulaireService.getDonneesStatistiquesByFormulaire(idFormulaire)).thenReturn(new ArrayList<>());

		ResponseEntity<ResponseModel> response = formulaireController.getDonneesStatistiqueByFormulaire(idFormulaire);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
	}

	@Test
	public void testGetGestionUtilisateurByFormulaire() throws Exception {
		Integer idFormulaire = 1;

		when(formulaireService.getGestionUtilisateurByFormulaire(idFormulaire)).thenReturn(new ArrayList<>());

		ResponseEntity<ResponseModel> response = formulaireController.getGestionUtilisateurByFormulaire(idFormulaire);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isNotNull();
	}

}
