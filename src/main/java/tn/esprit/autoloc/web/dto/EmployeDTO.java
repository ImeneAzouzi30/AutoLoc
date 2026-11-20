package tn.esprit.autoloc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.autoloc.domain.RoleEmploye;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDTO {
    private String nomEmploye;
    private String prenomEmploye;
    private RoleEmploye role;
}