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


    @ManyToMany
    private List<Voyageur> mesVoyageurs;


    public void setTrain(TrainDTO train) {
        this.train = train;
    }
}
