package tn.esprit.spring.DTO;

import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Ville;
import tn.esprit.spring.entities.Voyageur;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class voyageDTO {
    private Long idVoyage;


    long codeVoyage;

    @Enumerated(EnumType.STRING)
    private Ville gareDepart;


    @Enumerated(EnumType.STRING)
    private Ville gareArrivee;


    @Temporal(TemporalType.DATE)
    private Date dateDepart;
    @Temporal(TemporalType.DATE)
    private Date dateArrivee;

    private double heureDepart;

    private double heureArrivee;

    @ManyToOne
    Train train;


    @ManyToMany
    private List<Voyageur> mesVoyageurs;


}
