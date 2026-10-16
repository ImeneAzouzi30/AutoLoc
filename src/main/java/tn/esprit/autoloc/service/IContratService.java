package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;
import java.util.List;
import java.util.Optional;

public interface IContratService {

    Contrat addContrat(Contrat contrat);

    Contrat updateContrat(Contrat contrat);

    List<Contrat> getAllContrats();

    Optional<Contrat> getContratById(Long idContrat);

    void deleteContratById(Long idContrat);

    void deleteAllContrats();
}
