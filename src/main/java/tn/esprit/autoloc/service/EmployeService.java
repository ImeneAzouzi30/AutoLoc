package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.web.dto.EmployeDTO;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.mapper.EmployeMapper;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService implements IEmployeService {

       private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;
    private final EmployeMapper mapper;

    @Autowired
    public EmployeService(EmployeRepository employeRepository, AgenceRepository agenceRepository,EmployeMapper mapper) {
        this.employeRepository = employeRepository;
        this.agenceRepository = agenceRepository;
        this.mapper = mapper;
    }

    @Override
    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe updateEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Optional<Employe> getEmployeById(Long idEmploye) {
        return employeRepository.findById(idEmploye);
    }

    @Override
    public void deleteEmployeById(Long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }

    @Override
    public void deleteAllEmployes() {
        employeRepository.deleteAll();
    }

    // Dans EmployeService.java
    @Override
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new EntityNotFoundException("Employe introuvable avec l'id : " + idEmploye));
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable avec l'id : " + idAgence));
        employe.setAgence(agence);
        return employeRepository.save(employe);
    }

    @Override
    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new EntityNotFoundException("Employe introuvable avec l'id : " + idEmploye));

        employe.setAgence(null);
        return employeRepository.save(employe);
    }

    @Override
    public EmployeDTO getEmploye(Long id) {
        Employe employe = employeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employé non trouvé"));
        return mapper.toDto(employe);
    }
}
