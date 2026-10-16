package tn.esprit.autoloc.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@CrossOrigin(origins = "*")
public class ContratController {

    private final IContratService contratService;

    public ContratController(IContratService contratService) {
        this.contratService = contratService;
    }

    @PostMapping
    public ResponseEntity<Contrat> addContrat(@RequestBody Contrat contrat) {
        Contrat createdContrat = contratService.addContrat(contrat);
        return new ResponseEntity<>(createdContrat, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Contrat>> getAllContrats() {
        List<Contrat> contrats = contratService.getAllContrats();
        return ResponseEntity.ok(contrats);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> getContratById(@PathVariable("id") Long id) {
        return contratService.getContratById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Contrat> updateContrat(@RequestBody Contrat contrat) {
        Contrat updatedContrat = contratService.updateContrat(contrat);
        return ResponseEntity.ok(updatedContrat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrat> updateContratById(@PathVariable("id") Long id, @RequestBody Contrat contrat) {
        contrat.setIdContrat(id);
        Contrat updatedContrat = contratService.updateContrat(contrat);
        return ResponseEntity.ok(updatedContrat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContratById(@PathVariable("id") Long id) {
        contratService.deleteContratById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllContrats() {
        contratService.deleteAllContrats();
        return ResponseEntity.noContent().build();
    }
}
