package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;
import java.util.List;
import java.util.Optional;

public interface IEquipementService {

    Equipement addEquipement(Equipement equipement);

    Equipement updateEquipement(Equipement equipement);

    List<Equipement> getAllEquipements();

    Optional<Equipement> getEquipementById(Long idEquipement);

    void deleteEquipementById(Long idEquipement);

    void deleteAllEquipements();
}
