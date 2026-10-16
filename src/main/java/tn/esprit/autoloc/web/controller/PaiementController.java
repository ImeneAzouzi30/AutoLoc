package tn.esprit.autoloc.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@CrossOrigin(origins = "*")
public class PaiementController {

    private final IPaiementService paiementService;

    public PaiementController(IPaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @PostMapping
    public ResponseEntity<Paiement> addPaiement(@RequestBody Paiement paiement) {
        Paiement createdPaiement = paiementService.addPaiement(paiement);
        return new ResponseEntity<>(createdPaiement, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Paiement>> getAllPaiements() {
        List<Paiement> paiements = paiementService.getAllPaiements();
        return ResponseEntity.ok(paiements);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paiement> getPaiementById(@PathVariable("id") Long id) {
        return paiementService.getPaiementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Paiement> updatePaiement(@RequestBody Paiement paiement) {
        Paiement updatedPaiement = paiementService.updatePaiement(paiement);
        return ResponseEntity.ok(updatedPaiement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paiement> updatePaiementById(@PathVariable("id") Long id, @RequestBody Paiement paiement) {
        paiement.setIdPaiement(id);
        Paiement updatedPaiement = paiementService.updatePaiement(paiement);
        return ResponseEntity.ok(updatedPaiement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaiementById(@PathVariable("id") Long id) {
        paiementService.deletePaiementById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllPaiements() {
        paiementService.deleteAllPaiements();
        return ResponseEntity.noContent().build();
    }
}
