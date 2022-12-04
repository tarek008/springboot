package tn.esprit.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.Equipe;
import tn.esprit.persistance.Stade;
import tn.esprit.persistance.repositories.StadeRepository;
import tn.esprit.services.Interfaces.StadeService;
@Service
public class StadeServiceImplementation implements StadeService {
	@Autowired
	StadeRepository stadeRepository;
	@Override
	public List<Stade> retrieveAllStades() {
		return (List<Stade>) stadeRepository.findAll();
	}

	@Override
	public Stade addStade(Stade s) {
		s=stadeRepository.save(s);
		return s;
	}

	@Override
	public Stade updateStade(Stade s) {
		return stadeRepository.save(s);
	}

	@Override
	public void DeleteStade(Integer id) {
		stadeRepository.deleteById(id);
	}

}
