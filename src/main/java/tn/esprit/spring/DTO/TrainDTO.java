package tn.esprit.spring.DTO;

import tn.esprit.spring.entities.etatTrain;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class TrainDTO {
    long idTrain;
    long codeTrain;

    public long getCodeTrain() {
        return codeTrain;
    }

    public void setCodeTrain(long codeTrain) {
        this.codeTrain = codeTrain;
    }

    @Enumerated(EnumType.STRING)
    private etatTrain etat;

    private int nbPlaceLibre;

    public long getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(long idTrain) {
        this.idTrain = idTrain;
    }

    public etatTrain getEtat() {
        return etat;
    }

    public void setEtat(etatTrain etat) {
        this.etat = etat;
    }

    public int getNbPlaceLibre() {
        return nbPlaceLibre;
    }

    public void setNbPlaceLibre(int nbPlaceLibre) {
        this.nbPlaceLibre = nbPlaceLibre;
    }

    public TrainDTO() {
        super();
    }

    public TrainDTO(long idTrain, etatTrain etat, int nbPlaceLibre) {
        super();
        this.idTrain = idTrain;
        this.etat = etat;
        this.nbPlaceLibre = nbPlaceLibre;
    }

}
