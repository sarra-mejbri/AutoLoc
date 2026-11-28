package tn.esprit.autoloc.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import tn.esprit.autoloc.domain.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeDTO {
    private String nom;
    private String prenom;
    private Role role;
    private String nomAgence;   // agence.nom (au lieu de l'objet Agence complet)
}
