package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.DTO.VoyageurDTO;
import tn.esprit.spring.entities.Voyageur;


import tn.esprit.spring.repository.VoyageurRepository;


@Service
public class VoyageurServiceImpl implements IVoyageurService{

	@Autowired
	VoyageurRepository voyageurRepository;

	public void ajouterVoyageur(VoyageurDTO voyageur) {
		voyageurRepository.save(voyageur);
		
    }

	@Override
	public void modifierVoyageur(VoyageurDTO voyageur) {
		voyageurRepository.save(voyageur);
	}

	@Override
	public List<VoyageurDTO> recupererAll() {
		List<VoyageurDTO> list= (List<VoyageurDTO>) voyageurRepository.findAll();
		//Afficher la liste des voyageurs
		for (VoyageurDTO v: list) {
			System.err.print("Voyageur");
			System.out.print(v.toString()+"\n");
		}
		return list;
	}

	@Override
	public VoyageurDTO recupererVoyageParId(long idVoyageurDTO) {

		return null;
	}

	@Override
	public void supprimerVoyageur(VoyageurDTO v) {
		voyageurRepository.delete(v);
	}

}
