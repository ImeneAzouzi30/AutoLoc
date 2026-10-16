package tn.esprit.autoloc.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@CrossOrigin(origins = "*")
public class AgenceController {

    private final IAgenceService agenceService;

    public AgenceController(IAgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @PostMapping
    public ResponseEntity<Agence> addAgence(@RequestBody Agence agence) {
        Agence createdAgence = agenceService.addAgence(agence);
        return new ResponseEntity<>(createdAgence, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Agence>> getAllAgences() {
        List<Agence> agences = agenceService.getAllAgences();
        return ResponseEntity.ok(agences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> getAgenceById(@PathVariable("id") Long id) {
        return agenceService.getAgenceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Agence> updateAgence(@RequestBody Agence agence) {
        Agence updatedAgence = agenceService.updateAgence(agence);
        return ResponseEntity.ok(updatedAgence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agence> updateAgenceById(@PathVariable("id") Long id, @RequestBody Agence agence) {
        agence.setIdAgence(id);
        Agence updatedAgence = agenceService.updateAgence(agence);
        return ResponseEntity.ok(updatedAgence);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgenceById(@PathVariable("id") Long id) {
        agenceService.deleteAgenceById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllAgences() {
        agenceService.deleteAllAgences();
        return ResponseEntity.noContent().build();
    }
}
