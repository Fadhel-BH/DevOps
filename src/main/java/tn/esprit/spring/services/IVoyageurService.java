package tn.esprit.spring.services;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.DTO.VoyageurDTO;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.entities.Voyageur;

import java.util.List;


public interface IVoyageurService {
    void ajouterVoyageur(VoyageurDTO Voyageur);
    //Modifier le voyageur
    void modifierVoyageur(VoyageurDTO voyageur);
    List<VoyageurDTO> recupererAll();
    VoyageurDTO recupererVoyageParId(long idVoyageurDTO);
    void supprimerVoyageur(VoyageurDTO v);
}
