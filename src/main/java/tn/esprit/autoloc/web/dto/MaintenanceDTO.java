package tn.esprit.autoloc.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceDTO {
    private Date dateDebut;
    private Date dateFin;
    private String description;
    private String immatriculationVehicule;   // vehicule.immatriculation
}
