package tn.esprit.spring.services;

import org.springframework.stereotype.Service;
import tn.esprit.spring.DTO.TrainDTO;
import tn.esprit.spring.DTO.VoyageurDTO;
import tn.esprit.spring.DTO.voyageDTO;
import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Ville;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.entities.etatTrain;
import tn.esprit.spring.repository.TrainRepository;
import tn.esprit.spring.repository.VoyageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.repository.VoyageurRepository;

import tn.esprit.spring.entities.Voyageur;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.spring.entities.Voyageur;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.scheduling.annotation.Scheduled;

@Service
public class TrainServiceImpl implements ITrainService {

    private static final String TAILLE = "taille";
    @Autowired
    VoyageurRepository VoyageurRepository;


    @Autowired
    TrainRepository trainRepository;

    @Autowired
    VoyageRepository voyageRepository;


    public void ajouterTrain(TrainDTO t) {

        trainRepository.save(t);
    }

    public int TrainPlacesLibres(Ville nomGareDepart) {
        int cpt = 0;
        int occ = 0;
        Logger logger
                = Logger.getLogger(
                TrainServiceImpl.class.getName());

            List<voyageDTO> listvoyage = (List<voyageDTO>) voyageRepository.findAll();
        logger.log(Level.SEVERE, "in controller {0}.",TAILLE+listvoyage.size());

            for (int i = 0; i < listvoyage.size(); i++) {
                logger.log(Level.SEVERE, "in controller {0}.","gare" + nomGareDepart + "value" + listvoyage.get(0).getGareDepartDTO());

                if (listvoyage.get(i).getGareDepartDTO() == nomGareDepart) {
                    cpt = cpt + listvoyage.get(i).getTrainDTO().get().getNbPlaceLibreDTO();
                    occ = occ + 1;
                    System.out.println("cpt " + cpt);
                }
                if (occ!=0) {
                    return cpt / occ;  }

            }

return cpt/1;

    }


    public List<TrainDTO> ListerTrainsIndirects(Ville nomGareDepart, Ville nomGareArrivee) {

        List<TrainDTO> lestrainsRes = new ArrayList<>();
        List<voyageDTO> lesvoyage = new ArrayList<>();
        lesvoyage = (List<voyageDTO>) voyageRepository.findAll();
        for (int i = 0; i < lesvoyage.size(); i++) {
            if (lesvoyage.get(i).getGareDepartDTO() == nomGareDepart) {
                for (int j = 0; j < lesvoyage.size(); j++) {
                    if (lesvoyage.get(i).getGareArriveeDTO() == lesvoyage.get(j).getGareDepartDTO() && lesvoyage.get(j).getGareArriveeDTO() == nomGareArrivee) {
                        lestrainsRes.add(lesvoyage.get(i).getTrainDTO().get());
                        lestrainsRes.add(lesvoyage.get(j).getTrainDTO().get());

                    } else {

                    }

                }
            }
        }


        return lestrainsRes;
        //
    }

    @Transactional
    public void affecterTainAVoyageur(Long idVoyageurDTO, Ville nomGareDepart, Ville nomGareArrivee, double heureDepart) {


        Optional<VoyageurDTO> value = VoyageurRepository.findById(idVoyageurDTO);
        if (value.isPresent()) {
            value.get();
        }
        System.out.println(TAILLE + "test");


            List<voyageDTO> lesvoyages = new ArrayList<>();
            lesvoyages = voyageRepository.RechercheVoyage(nomGareDepart, nomGareDepart, heureDepart);
            System.out.println(TAILLE + lesvoyages.size());
            for (int i = 0; i < lesvoyages.size(); i++) {
                if (lesvoyages.get(i).getTrainDTO().get().getNbPlaceLibreDTO() != 0) {
                    lesvoyages.get(i).getMesVoyageursDTO().add(value);
                    lesvoyages.get(i).getTrainDTO().get().setNbPlaceLibreDTO(lesvoyages.get(i).getTrainDTO().get().getNbPlaceLibreDTO() - 1);
                }
                else

                    System.out.print("Pas de place disponible pour ");
                voyageRepository.save(lesvoyages.get(i));
            }

    }

    @Override
    public void DesaffecterVoyageursTrain(Ville nomGareDepart, Ville nomGareArrivee, double heureDepart) {
        List<voyageDTO> lesvoyages = new ArrayList<>();
        lesvoyages = voyageRepository.RechercheVoyage(nomGareDepart, nomGareArrivee, heureDepart);
        System.out.println(TAILLE + lesvoyages.size());

        for (int i = 0; i < lesvoyages.size(); i++) {
            for (int j = 0; j < lesvoyages.get(i).getMesVoyageursDTO().size(); j++)
                lesvoyages.get(i).getMesVoyageursDTO().remove(j);
            lesvoyages.get(i).getTrainDTO().get().setNbPlaceLibreDTO(lesvoyages.get(i).getTrainDTO().get().getNbPlaceLibreDTO() + 1);
            lesvoyages.get(i).getTrainDTO().get().setEtat(etatTrain.PREVU);
            voyageRepository.save(lesvoyages.get(i));
            trainRepository.save(lesvoyages.get(i).getTrainDTO().get());
        }
    }

    @Scheduled(fixedRate = 2000)
    public void TrainsEnGare() {
        List<voyageDTO> lesvoyages = new ArrayList<>();
        lesvoyages = (List<voyageDTO>) voyageRepository.findAll();
        System.out.println(TAILLE + lesvoyages.size());

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("In Schedular After Try");
        for (int i = 0; i < lesvoyages.size(); i++) {
            if (lesvoyages.get(i).getDateArriveeDTO().before(date)) {
                System.out.println("les trains sont " + lesvoyages.get(i).getTrainDTO().get().getCodeTrain());
            }
            else{

            }
        }
    }


}

    
