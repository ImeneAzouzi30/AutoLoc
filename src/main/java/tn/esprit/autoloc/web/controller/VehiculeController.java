package tn.esprit.autoloc.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@CrossOrigin(origins = "*")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    public VehiculeController(IVehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @PostMapping
    public ResponseEntity<Vehicule> addVehicule(@RequestBody Vehicule vehicule) {
        Vehicule createdVehicule = vehiculeService.addVehicule(vehicule);
        return new ResponseEntity<>(createdVehicule, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Vehicule>> getAllVehicules() {
        List<Vehicule> vehicules = vehiculeService.getAllVehicules();
        return ResponseEntity.ok(vehicules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getVehiculeById(@PathVariable("id") Long id) {
        return vehiculeService.getVehiculeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Vehicule> updateVehicule(@RequestBody Vehicule vehicule) {
        Vehicule updatedVehicule = vehiculeService.updateVehicule(vehicule);
        return ResponseEntity.ok(updatedVehicule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> updateVehiculeById(@PathVariable("id") Long id, @RequestBody Vehicule vehicule) {
        vehicule.setIdVehicule(id);
        Vehicule updatedVehicule = vehiculeService.updateVehicule(vehicule);
        return ResponseEntity.ok(updatedVehicule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehiculeById(@PathVariable("id") Long id) {
        vehiculeService.deleteVehiculeById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllVehicules() {
        vehiculeService.deleteAllVehicules();
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{idVehicule}/agence/{idAgence}")
    public ResponseEntity<Vehicule> affecterVehicule(
            @PathVariable("idVehicule") Long idVehicule,
            @PathVariable("idAgence") Long idAgence) {
        Vehicule v = vehiculeService.affecterVehicule(idVehicule, idAgence);
        return ResponseEntity.ok(v);
    }
    @PutMapping("/{idVehicule}/equipements/{idEquipement}")
    public ResponseEntity<Vehicule> affecterEquipement(
            @PathVariable("idVehicule") Long idVehicule,
            @PathVariable("idEquipement") Long idEquipement) {
        Vehicule v = vehiculeService.affecterEquipement(idVehicule, idEquipement);
        return ResponseEntity.ok(v);
    }
    @DeleteMapping("/{idVehicule}/equipements/{idEquipement}")
    public ResponseEntity<Vehicule> desaffecterEquipement(
            @PathVariable("idVehicule") Long idVehicule,
            @PathVariable("idEquipement") Long idEquipement) {
        Vehicule v = vehiculeService.desaffecterEquipement(idVehicule, idEquipement);
        return ResponseEntity.ok(v);
    }
}
