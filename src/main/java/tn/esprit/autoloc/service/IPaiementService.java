package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;
import java.util.List;
import java.util.Optional;

public interface IPaiementService {

    Paiement addPaiement(Paiement paiement);

    Paiement updatePaiement(Paiement paiement);

    List<Paiement> getAllPaiements();

    Optional<Paiement> getPaiementById(Long idPaiement);

    void deletePaiementById(Long idPaiement);

    void deleteAllPaiements();
}
