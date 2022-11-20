package tn.esprit.persistance.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.persistance.Contrat;
import tn.esprit.persistance.Etudiant;
@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer>{
   /* @Modifying
	@Query("update  Contrat c set c.etudiant.idEtudiant= :idetudiant where c.idContrat= :idcontrat")
	int affecterContratToEtudiant(@Param("idetudiant") int i, @Param("idcontrat") int j ); 
  */
    @Modifying
    @Query("delete  from Contrat c where c.dateFinContrat - c.dateDebutContrat =0  ")
	int dropcontratdunjour();
	
   /*  @Query("select sum(montantContrat) Beetween startDate= ?1 and endDate =?2 from Contrat c where c.archive =false")
	public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);*/
}
//
