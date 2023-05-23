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


    public long getCodeVoyage() {
        return codeVoyage;
    }


    public void setCodeVoyage(long codeVoyage) {
        this.codeVoyage = codeVoyage;
    }


    public Long getIdVoyage() {
        return idVoyage;
    }


    public void setIdVoyage(Long idVoyage) {
        this.idVoyage = idVoyage;
    }


    public Ville getGareDepart() {
        return gareDepart;
    }


    public void setGareDepart(Ville gareDepart) {
        this.gareDepart = gareDepart;
    }


    public Ville getGareArrivee() {
        return gareArrivee;
    }


    public void setGareArrivee(Ville gareArrivee) {
        this.gareArrivee = gareArrivee;
    }


    public Date getDateDepart() {
        return dateDepart;
    }


    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }


    public Date getDateArrivee() {
        return dateArrivee;
    }


    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }


    public double getHeureDepart() {
        return heureDepart;
    }


    public void setHeureDepart(double heureDepart) {
        this.heureDepart = heureDepart;
    }


    public double getHeureArrivee() {
        return heureArrivee;
    }


    public void setHeureArrivee(double heureArrivee) {
        this.heureArrivee = heureArrivee;
    }


    public Train getTrain() {
        return train;
    }


    public void setTrain(Train train) {
        this.train = train;
    }


    public List<Voyageur> getMesVoyageurs() {
        return mesVoyageurs;
    }


    public void setMesVoyageurs(List<Voyageur> mesVoyageurs) {
        this.mesVoyageurs = mesVoyageurs;
    }

    public voyageDTO(Long idVoyage, long codeVoyage, Ville gareDepart, Ville gareArrivee, Date dateDepart, Date dateArrivee, double heureDepart, double heureArrivee, Train train, List<Voyageur> mesVoyageurs) {
        this.idVoyage = idVoyage;
        this.codeVoyage = codeVoyage;
        this.gareDepart = gareDepart;
        this.gareArrivee = gareArrivee;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.train = train;
        this.mesVoyageurs = mesVoyageurs;
    }
}
