package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;
import java.util.List;
import java.util.Optional;

public interface IAgenceService {

    Agence addAgence(Agence agence);

    Agence updateAgence(Agence agence);

    List<Agence> getAllAgences();

    Optional<Agence> getAgenceById(Long idAgence);

    void deleteAgenceById(Long idAgence);

    void deleteAllAgences();
}
