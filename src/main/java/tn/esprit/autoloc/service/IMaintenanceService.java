package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;
import java.util.List;
import java.util.Optional;

public interface IMaintenanceService {

    Maintenance addMaintenance(Maintenance maintenance);

    Maintenance updateMaintenance(Maintenance maintenance);

    List<Maintenance> getAllMaintenances();

    Optional<Maintenance> getMaintenanceById(Long idMaintenance);

    void deleteMaintenanceById(Long idMaintenance);

    void deleteAllMaintenances();
}
