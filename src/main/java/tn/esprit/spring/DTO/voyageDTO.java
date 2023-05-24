package tn.esprit.spring.DTO;

import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Ville;
import tn.esprit.spring.entities.Voyageur;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class voyageDTO {



    long codeVoyage;

    @Enumerated(EnumType.STRING)
    private Ville gareDepart;


    @Enumerated(EnumType.STRING)
    private Ville gareArrivee;


    @Temporal(TemporalType.DATE)
    private Date dateDepart;
    @Temporal(TemporalType.DATE)
    private Date dateArrivee;


    @ManyToOne
    TrainDTO train;
    private List<VoyageurDTO> mesVoyageurs;
    
    public Ville getGareDepartDTO() {
        return gareDepart;
    }
    public Ville getGareArriveeDTO() {
        return gareArrivee;
    }
    public void setTrainDTO(TrainDTO train) {
        this.train = train;
    }

    public Date getDateDepartDTO() {
        return dateDepart;
    }


    public void setDateDepartDTO(Date dateDepart) {
        this.dateDepart = dateDepart;
    }


    public Date getDateArriveeDTO() {
        return dateArrivee;
    }


    public void setDateArriveeDTO(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }



    public List<VoyageurDTO> getMesVoyageursDTO() {
        return mesVoyageurs;
    }


    public void setMesVoyageursDTO(List<VoyageurDTO> mesVoyageurs) {
        this.mesVoyageurs = mesVoyageurs;
    }


    public TrainDTO getTrainDTO() {
        return train;
    }
}
