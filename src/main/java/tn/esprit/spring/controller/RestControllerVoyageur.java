package tn.esprit.spring.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import antlr.build.Tool;
import org.slf4j.event.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.DTO.TrainDTO;
import tn.esprit.spring.DTO.VoyageurDTO;
import tn.esprit.spring.DTO.voyageDTO;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Ville;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.TrainRepository;
import tn.esprit.spring.services.IVoyageurService;
import tn.esprit.spring.services.ITrainService;
import tn.esprit.spring.services.IVoyageService;

@RestController
public class RestControllerVoyageur {


    @Autowired
    IVoyageService ivoyageservice;

    @Autowired
    ITrainService itrainservice;

    @Autowired
    IVoyageurService iVoyageurservice;


    @PostMapping("/ajouterVoyage")
    @ResponseBody
    public void ajouterGare(@RequestBody voyageDTO voyage) {
        ivoyageservice.ajouterVoyage(voyage);
    }



    @PostMapping("/ajouterTrain")
    @ResponseBody
    public void ajouterTrain(@RequestBody TrainDTO train) {

        itrainservice.ajouterTrain(train);
    }

    @PostMapping("/ajouterVoyageur")
    @ResponseBody
    public void ajouterVoyageur(@RequestBody VoyageurDTO Voyageur) {
        iVoyageurservice.ajouterVoyageur(Voyageur);
    }


    @PutMapping(value = "/affecterTrainAVoyage/{idtr}/{idvyg}")

    public void affecterTrainAVoyage(@PathVariable("idtr") Long idTrain, @PathVariable("idvyg") Long idVoyage) {
        ivoyageservice.affecterTrainAVoyage(idTrain, idVoyage);
    }




    @PutMapping(value = "/affecterTrainAVoyageur/{idc}/{nomgdpt}/{nomgarr}/{heuredept}")
    public void affecterTainAVoyageur(@PathVariable("idc") Long idVoyageur, @PathVariable("nomgdpt") Ville nomGareDepart, @PathVariable("nomgarr") Ville nomGareArrivee, @PathVariable("heuredept") double heureDepart) {
        itrainservice.affecterTainAVoyageur(idVoyageur, nomGareDepart, nomGareArrivee, heureDepart);
    }


    @GetMapping(value = "/TrainPlacesLibres/{nomgdpt}")
    public int TrainPlacesLibres(@PathVariable("nomgdpt") Ville nomGareDepart) {
   // jsjsj
        Logger logger
                = Logger.getLogger(
                RestControllerVoyageur.class.getName());
            logger.log(Level.SEVERE, "in controller {0}.",nomGareDepart);

        return itrainservice.TrainPlacesLibres(nomGareDepart);
    }

    @RequestMapping(value = "/ListerTrainsIndirects/{nomgdpt}/{nomgarr}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TrainDTO> ListerTrainsIndirects(@PathVariable("nomgdpt") Ville nomGareDepart, @PathVariable("nomgarr") Ville nomGareArrivee) {
        return itrainservice.ListerTrainsIndirects(nomGareDepart, nomGareArrivee);
    }

    @PutMapping(value = "/DesaffecterVoyageursTrain/{nomgdpt}/{heuredept}")
    public void DesaffecterVoyageursTrain(@PathVariable("nomgdpt") Ville nomGareDepart, @PathVariable("nomgarr") Ville nomGareArrivee, @PathVariable("heuredept") double heureDepart) {
        itrainservice.DesaffecterVoyageursTrain(nomGareDepart, nomGareArrivee, heureDepart);
    }

}
