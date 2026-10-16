package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EquipementService implements IEquipementService {

    private final EquipementRepository equipementRepository;

    @Autowired
    public EquipementService(EquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    @Override
    public Equipement addEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement updateEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }

    @Override
    public Optional<Equipement> getEquipementById(Long idEquipement) {
        return equipementRepository.findById(idEquipement);
    }

    @Override
    public void deleteEquipementById(Long idEquipement) {
        equipementRepository.deleteById(idEquipement);
    }

    @Override
    public void deleteAllEquipements() {
        equipementRepository.deleteAll();
    }
}
