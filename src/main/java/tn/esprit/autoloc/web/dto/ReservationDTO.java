package tn.esprit.autoloc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import tn.esprit.autoloc.domain.StatutReservation;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private Date dateDebut;
    private Date dateFin;
    private StatutReservation statut;
    private String nomClient;                 // client.nom
    private String immatriculationVehicule;   // vehicule.immatriculation
}
