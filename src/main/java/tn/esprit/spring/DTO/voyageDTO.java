package tn.esprit.spring.DTO;

import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Ville;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    Optional<TrainDTO> train;
    private List<Optional<VoyageurDTO>> mesVoyageurs;

    public Ville getGareDepartDTO() {
        return gareDepart;
    }
    public Ville getGareArriveeDTO() {
        return gareArrivee;
    }
    public void setTrainDTO(Optional<TrainDTO> train) {
        this.train = train;
    }
    public Optional<TrainDTO> getTrainDTO() {
        return train;
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



    public List<Optional<VoyageurDTO>> getMesVoyageursDTO() {
        return mesVoyageurs;
    }


    public void setMesVoyageursDTO(List<Optional<VoyageurDTO>> mesVoyageurs) {
        this.mesVoyageurs = mesVoyageurs;
    }


}
