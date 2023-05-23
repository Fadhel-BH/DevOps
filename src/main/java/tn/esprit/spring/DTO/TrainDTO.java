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


}
