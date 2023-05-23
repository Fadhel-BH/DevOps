package tn.esprit.spring.DTO;

import tn.esprit.spring.entities.Voyage;

import javax.persistence.ManyToMany;
import java.util.List;

public class VoyageurDTO {
    private Long idVoyageur;

    String nomVoyageur;


    public List<Voyage> getMesvoyages() {
        return mesvoyages;
    }

    public void setMesvoyages(List<Voyage> mesvoyages) {
        this.mesvoyages = mesvoyages;
    }

    @ManyToMany(mappedBy = "mesVoyageurs")
    public List<Voyage> mesvoyages;

    public Long getIdVoyageur() {
        return idVoyageur;
    }

    public void setIdVoyageur(Long idVoyageur) {
        this.idVoyageur = idVoyageur;
    }

    public String getNomVoyageur() {
        return nomVoyageur;
    }

    public void setNomVoyageur(String nomVoyageur) {
        this.nomVoyageur = nomVoyageur;
    }

    public VoyageurDTO() {
        super();
    }

}
