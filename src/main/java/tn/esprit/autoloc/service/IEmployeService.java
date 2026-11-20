package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.web.dto.EmployeDTO;
import java.util.List;
import java.util.Optional;

public interface IEmployeService {

    Employe addEmploye(Employe employe);

    Employe updateEmploye(Employe employe);

    List<Employe> getAllEmployes();

    Optional<Employe> getEmployeById(Long idEmploye);

    void deleteEmployeById(Long idEmploye);

    void deleteAllEmployes();
    Employe desaffecterEmploye(Long idEmploye);
    Employe affecterEmploye(Long idEmploye, Long idAgence);
    EmployeDTO getEmploye(Long id);
}
