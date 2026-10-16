package tn.esprit.autoloc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService implements IEmployeService {

    private final EmployeRepository employeRepository;

    @Autowired
    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
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
}
