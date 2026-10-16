package tn.esprit.autoloc.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
@CrossOrigin(origins = "*")
public class EquipementController {

    private final IEquipementService equipementService;

    public EquipementController(IEquipementService equipementService) {
        this.equipementService = equipementService;
    }

    @PostMapping
    public ResponseEntity<Equipement> addEquipement(@RequestBody Equipement equipement) {
        Equipement createdEquipement = equipementService.addEquipement(equipement);
        return new ResponseEntity<>(createdEquipement, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Equipement>> getAllEquipements() {
        List<Equipement> equipements = equipementService.getAllEquipements();
        return ResponseEntity.ok(equipements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable("id") Long id) {
        return equipementService.getEquipementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Equipement> updateEquipement(@RequestBody Equipement equipement) {
        Equipement updatedEquipement = equipementService.updateEquipement(equipement);
        return ResponseEntity.ok(updatedEquipement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipement> updateEquipementById(@PathVariable("id") Long id, @RequestBody Equipement equipement) {
        equipement.setIdEquipement(id);
        Equipement updatedEquipement = equipementService.updateEquipement(equipement);
        return ResponseEntity.ok(updatedEquipement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipementById(@PathVariable("id") Long id) {
        equipementService.deleteEquipementById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllEquipements() {
        equipementService.deleteAllEquipements();
        return ResponseEntity.noContent().build();
    }
}
