package tn.esprit.persistance;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.type.BlobType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Entity
@Table(name="Etudiant")
public class Etudiant implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEtudiant")
	private int idEtudiant; // Clé primaire
	private String prenomE;
	private String nomE;
	private String picture ; 
	@Temporal(TemporalType.DATE)
	private  Date date_naissance; 
	@Enumerated(EnumType.STRING) 
	private Option option ;
	@OneToMany(mappedBy = "etudiant")
	private Set<Contrat> contrat; 
	@ManyToOne
	private Departement departement ; 
	@ManyToMany(mappedBy = "etudiants")
     private Set<Equipe> equipe; 
	// @Enumerated(EnumType.STRING)
	//private Option op;
	// Constructeur et accesseurs (getters) et mutateurs (setters)
	
	

	public Integer getIdEtudiant() {
		return idEtudiant;
	}
	
	public String getPrenomE() {
		return prenomE;
	}
	public void setPrenomE(String prenomE) {
		this.prenomE = prenomE;
	}
	public String getNomE() {
		return nomE;
	}
	public void setNomE(String nomE) {
		this.nomE = nomE;
	}


	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}


	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}


	public Option getOption() {
		return option;
	}


	public void setOption(Option option) {
		this.option = option;
	}


	public Set<Contrat> getContrat() {
		return contrat;
	}


	public void setContrat(Set<Contrat> contrat) {
		this.contrat = contrat;
	}


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}


	public Set<Equipe> getEquipe() {
		return equipe;
	}


	public void setEquipe(Set<Equipe> equipe) {
		this.equipe = equipe;
	}
	
	
	
	public Etudiant( ) {
}

	public Etudiant(int idEtudiant, String prenomE, String nomE,String picture, Date date_naissance, Option option,
			Set<Contrat> contrat, Departement departement, Set<Equipe> equipe) {
		this.idEtudiant = idEtudiant;
		this.prenomE = prenomE;
		this.nomE = nomE;
		this.picture=picture;
		this.date_naissance = date_naissance;
		this.option = option;
		this.contrat = contrat;
		this.departement = departement;
		this.equipe = equipe;
	 //
	}
	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", prenomE=" + prenomE + ", nomE=" + nomE + ", date_naissance="
				+ date_naissance + ", option=" + option + ", departement=" + departement + "]";
	}
	
	



}
