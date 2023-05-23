package tn.esprit.spring.services;

import tn.esprit.spring.DTO.voyageDTO;
import tn.esprit.spring.entities.Voyage;

import java.util.List;

public interface IVoyageService {

	 void ajouterVoyage(voyageDTO v);
	 void modifierVoyage(Voyage v);
	 //public void affecterTrainAVoyage(Long idTrain, String gareDepart, String  gareArrivee);
	 void affecterTrainAVoyage(Long idTrain, Long idVoyage);
	 List<Voyage> recupererAll();
	 Voyage recupererVoyageParId(long idVoyage);
	 void supprimerVoyage(Voyage v);

	
}
