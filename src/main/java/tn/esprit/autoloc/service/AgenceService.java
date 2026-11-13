package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AgenceService implements IAgenceService {

    private final AgenceRepository agenceRepository;

    @Autowired
    public AgenceService(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence updateAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Optional<Agence> getAgenceById(Long idAgence) {
        return agenceRepository.findById(idAgence);
    }

    @Override
    public void deleteAgenceById(Long idAgence) {
        agenceRepository.deleteById(idAgence);
    }

    @Override
    public void deleteAllAgences() {
        agenceRepository.deleteAll();
    }

}