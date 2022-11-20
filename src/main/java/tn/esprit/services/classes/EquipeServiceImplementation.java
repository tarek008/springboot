package tn.esprit.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.DetailEquipe;
import tn.esprit.persistance.Equipe;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.repositories.DetailEquipeRepository;
import tn.esprit.persistance.repositories.EquipeRepository;
import tn.esprit.persistance.repositories.EtudiantRepository;
import tn.esprit.services.Interfaces.EquipeService;
@Service
public class EquipeServiceImplementation implements EquipeService {
@Autowired
EquipeRepository equiperep;
@Autowired
DetailEquipeRepository detailequiperep;
@Autowired
EtudiantRepository etudrep;

@Override
public List<Equipe> retrieveAllEquipes() {
	return (List<Equipe>) equiperep.findAll();
}

@Override
public Equipe addEquipe(Equipe e) {
	e=equiperep.save(e);
	return e;
}

@Override
public Equipe updateEquipe(Equipe e) {
	return equiperep.save(e);
}

@Override
public Equipe retrieveEquipe(Integer idEquipe) {
	return  equiperep.findById(idEquipe).get();

}
//
@Override
public void DeleteEquipe(Integer idEquipe) {
	equiperep.deleteById(idEquipe);
	
}

@Override
public Equipe affecterDetailsToEquipe(int IdEquipe,int IdDetailEquipe) {
	Equipe e= equiperep.findById(IdEquipe).get();
	DetailEquipe de=detailequiperep.findById(IdDetailEquipe).get();
	e.setDetail_equipe(de);
	return equiperep.save(e);
}

@Override
public Etudiant assignEquipeToEtudiant(int idEquipe, int idEtudiant) {
     Etudiant e=etudrep.findById(idEtudiant).get();
     Equipe eq=equiperep.findById(idEquipe).get();
     eq.getEtudiants().add(e);
     equiperep.save(eq);
	return e;
}




}
