package tn.esprit.spring.DTO;

import tn.esprit.spring.entities.Voyage;

import javax.persistence.ManyToMany;
import java.util.List;

public class VoyageurDTO {

    String nomVoyageurDTO;


    public List<Voyage> getMesvoyages() {
        return mesvoyages;
    }

    public void setMesvoyages(List<Voyage> mesvoyages) {
        this.mesvoyages = mesvoyages;
    }
    public String getNomVoyageurDTO() {
        return nomVoyageurDTO;
    }

    public void setNomVoyageurDTO(String nomVoyageur) {
        this.nomVoyageurDTO = nomVoyageur;
    }


    @ManyToMany(mappedBy = "mesVoyageurs")
    public List<Voyage> mesvoyages;



}
