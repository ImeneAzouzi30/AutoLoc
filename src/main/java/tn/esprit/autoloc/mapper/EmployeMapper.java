package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.web.dto.EmployeDTO;

@Mapper(componentModel = "spring")
public interface EmployeMapper {
    @Mapping(target = "nomEmploye", source = "nom")
    @Mapping(target = "prenomEmploye", source = "prenom")
    EmployeDTO toDto(Employe employe);
}
