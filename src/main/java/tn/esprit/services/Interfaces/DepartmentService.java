package tn.esprit.services.Interfaces;

import java.util.List;

import tn.esprit.persistance.Departement;
import tn.esprit.persistance.Etudiant;

public interface DepartmentService {
	List<Departement> retrieveAllDepartements();

	Departement addDepartement (Departement d);

	Departement updateDepartement (Departement d);

	Departement retrieveDepartement (Integer idDepart);
	List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);

}
