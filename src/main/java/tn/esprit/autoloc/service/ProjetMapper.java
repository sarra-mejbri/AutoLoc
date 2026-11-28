package tn.esprit.autoloc.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.autoloc.domain.*;
import tn.esprit.autoloc.dto.*;

import java.util.List;

/**
 * Mapper MapStruct : convertit les entités JPA en DTO.
 * L'implémentation (ProjetMapperImpl) est générée automatiquement à la compilation.
 * componentModel = "spring" -> le mapper devient un bean injectable dans les contrôleurs.
 */
@Mapper(componentModel = "spring")
public interface ProjetMapper {

    // ----- Agence -----
    AgenceDTO toAgenceDto(Agence agence);
    List<AgenceDTO> toAgenceDtoList(List<Agence> agences);

    // ----- Client -----
    ClientDTO toClientDto(Client client);
    List<ClientDTO> toClientDtoList(List<Client> clients);

    // ----- Contrat -----
    ContratDTO toContratDto(Contrat contrat);
    List<ContratDTO> toContratDtoList(List<Contrat> contrats);

    // ----- Employe -----
    @Mapping(target = "nomAgence", source = "agence.nom")
    EmployeDTO toEmployeDto(Employe employe);
    List<EmployeDTO> toEmployeDtoList(List<Employe> employes);

    // ----- Equipement -----
    EquipementDTO toEquipementDto(Equipement equipement);
    List<EquipementDTO> toEquipementDtoList(List<Equipement> equipements);

    // ----- Maintenance -----
    @Mapping(target = "immatriculationVehicule", source = "vehicule.immatriculation")
    MaintenanceDTO toMaintenanceDto(Maintenance maintenance);
    List<MaintenanceDTO> toMaintenanceDtoList(List<Maintenance> maintenances);

    // ----- Paiement -----
    PaiementDTO toPaiementDto(Paiement paiement);
    List<PaiementDTO> toPaiementDtoList(List<Paiement> paiements);

    // ----- Reservation -----
    @Mapping(target = "nomClient", source = "client.nom")
    @Mapping(target = "immatriculationVehicule", source = "vehicule.immatriculation")
    ReservationDTO toReservationDto(Reservation reservation);
    List<ReservationDTO> toReservationDtoList(List<Reservation> reservations);

    // ----- Vehicule -----
    // equipements (Set<Equipement>) -> Set<EquipementDTO> : MapStruct réutilise toEquipementDto
    @Mapping(target = "nomAgence", source = "agence.nom")
    VehiculeDTO toVehiculeDto(Vehicule vehicule);
    List<VehiculeDTO> toVehiculeDtoList(List<Vehicule> vehicules);
}