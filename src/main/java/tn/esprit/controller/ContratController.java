package tn.esprit.controller;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.Contrat;
import tn.esprit.persistance.Etudiant;
import tn.esprit.services.Interfaces.ContratService;
import tn.esprit.services.Interfaces.EquipeService;
@RestController
@RequestMapping("ContartController")
@Slf4j
public class ContratController {

	@Autowired
	ContratService contserv; 
	
	@GetMapping("displayallcontrats")
	public List<Contrat> retrieveAllContrats() {
		return contserv.retrieveAllContrats();
	}

	@PutMapping("updateContrat")
	public Contrat updateContrat(@RequestBody Contrat ce) {
		return contserv.updateContrat(ce);
	}

	@PostMapping("newContrat")
	public Contrat newContrat( @RequestBody Contrat ce) {
		ce=contserv.addContrat(ce);
		return ce ;
	}

	@GetMapping("displayContratById/{id}")
	@ResponseBody
	public Contrat retrieveContrat(@PathVariable("id") int idContrat) {
		
		return contserv.retrieveContrat(idContrat);
	}

	@DeleteMapping("deleteContrat/{id}")
	public void removeContrat(@PathVariable("id") int  idContrat) {
       contserv.removeContrat(idContrat);		
	}
	

	
	@DeleteMapping("dropcontratdaujourdhui")
	public void dropcontratdaujourdhui() {
		 contserv.dropAllContratsEveryYear();
	}
	
	@DeleteMapping("deletecontratdujour")
	 public int DeleteLesContratDunjour() {
		 log.info("deleting ... ");
		 return contserv.dropcontratdunjour();
	 }
 
	@PutMapping("assignContratToEtudiantByID/{idcontrat}/{idetudiant}")
	public Etudiant assigncontratToEtudiant(@PathVariable("idcontrat") int idcontrat,@PathVariable("idetudiant") int idEtudiant) {
		return contserv.assigncontratToEtudiant(idcontrat, idEtudiant);
	}
}
