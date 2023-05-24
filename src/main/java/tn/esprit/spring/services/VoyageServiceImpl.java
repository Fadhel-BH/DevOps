package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DTO.TrainDTO;
import tn.esprit.spring.DTO.voyageDTO;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.TrainRepository;
import tn.esprit.spring.repository.VoyageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VoyageServiceImpl implements IVoyageService {
    @Autowired
    VoyageRepository voyageRepository;
    @Autowired
    TrainRepository trainRepository;


    @Override
    public void ajouterVoyage(voyageDTO v) {
        voyageRepository.save(v);
    }

    @Override
    public void modifierVoyage(voyageDTO v) {
		voyageRepository.save(v);
    }


    public void affecterTrainAVoyage(Long idTrain, Long idVoyage) {

        Optional<TrainDTO> t = trainRepository.findById(idTrain);

        if (t.isPresent()) {
            t.get();
        }
        Optional<voyageDTO> v =voyageRepository.findById(idVoyage);
        if (v.isPresent()) {
            v.get();
        }
        v.get().setTrainDTO(t);
        voyageRepository.save(v.get());
    }

    @Override
    public List<voyageDTO> recupererAll() {
        return (List<voyageDTO>) voyageRepository.findAll();
    }

    @Override
    public voyageDTO recupererVoyageParId(long idVoyage) {
        return voyageRepository.findById(idVoyage).orElse(null);
    }

    @Override
    public void supprimerVoyage(Voyage v) {
        //TODO method
    }

}
