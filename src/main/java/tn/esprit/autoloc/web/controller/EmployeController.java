package tn.esprit.autoloc.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
@CrossOrigin(origins = "*")
public class EmployeController {

    private final IEmployeService employeService;

    public EmployeController(IEmployeService employeService) {
        this.employeService = employeService;
    }

    @PostMapping
    public ResponseEntity<Employe> addEmploye(@RequestBody Employe employe) {
        Employe createdEmploye = employeService.addEmploye(employe);
        return new ResponseEntity<>(createdEmploye, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employe>> getAllEmployes() {
        List<Employe> employes = employeService.getAllEmployes();
        return ResponseEntity.ok(employes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable("id") Long id) {
        return employeService.getEmployeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Employe> updateEmploye(@RequestBody Employe employe) {
        Employe updatedEmploye = employeService.updateEmploye(employe);
        return ResponseEntity.ok(updatedEmploye);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmployeById(@PathVariable("id") Long id, @RequestBody Employe employe) {
        employe.setIdEmploye(id);
        Employe updatedEmploye = employeService.updateEmploye(employe);
        return ResponseEntity.ok(updatedEmploye);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeById(@PathVariable("id") Long id) {
        employeService.deleteEmployeById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllEmployes() {
        employeService.deleteAllEmployes();
        return ResponseEntity.noContent().build();
    }
}
