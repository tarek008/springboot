package tn.esprit.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.Departement;
import tn.esprit.persistance.Universite;
import tn.esprit.persistance.repositories.DepartmentRepository;
import tn.esprit.persistance.repositories.UniversityRepository;
import tn.esprit.services.Interfaces.UniversiteService;
@Service
@Slf4j
public class UniversityServiceImplementation implements UniversiteService {
@Autowired
UniversityRepository univrep;
@Autowired 
DepartmentRepository deprep; 

@Override
public List<Universite> retrieveAllUniversites() {
	if(univrep.findAll()==null) {
	 log.error("error fetching universities " );
	}
	return univrep.findAll();
}

@Override
public Universite addUniversite(Universite u) {
u=univrep.save(u);
return u;
}

@Override
public Universite updateUniversite(Universite u) {
	   
	  log.info(""+u);
     //
     return  univrep.save(u);
}

@Override
public Universite retrieveUniversite(Integer idUniversite) {
	return univrep.findById(idUniversite).get();
}

@Override
public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
 Universite u =univrep.findById(idUniversite).get(); 
 Departement d=deprep.findById(idDepartement).get(); 
 
u.getDepartments().add(d);
log.info("adding department to university...");
univrep.save(u);
log.info("added succesfuly...");

}

@Override
public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
 	return univrep.retrieveDepartementsByUniversite(idUniversite);
}


@Override
public void removeUniv(int id) {
	// TODO Auto-generated method stub
	univrep.deleteById(id);
}

}
