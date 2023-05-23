package tn.esprit.spring.DTO;

import tn.esprit.spring.entities.Voyage;

import javax.persistence.ManyToMany;
import java.util.List;

public class VoyageurDTO {

    String nomVoyageur;


    public List<Voyage> getMesvoyages() {
        return mesvoyages;
    }

    public void setMesvoyages(List<Voyage> mesvoyages) {
        this.mesvoyages = mesvoyages;
    }

    @ManyToMany(mappedBy = "mesVoyageurs")
    public List<Voyage> mesvoyages;



}
