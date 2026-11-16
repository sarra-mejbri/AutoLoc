package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;
import tn.esprit.autoloc.domain.CategorieVehicule;
import java.math.BigDecimal;

public interface IvehiculeService {
    List<Vehicule> retrieveAllVehicules();
    Vehicule addVehicule( Vehicule c);
    Vehicule updateVehicule( Vehicule c);
    Vehicule retrieveVehicule(Long idVehicule);
    void removeVehicule(Long idVehicule);
    List< Vehicule> addVehicules (List< Vehicule>  Vehicules);
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence);
    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);

    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);

    // ----- Atelier Keywords -----
    List<Vehicule> getVehiculesByMarque(String marque);                      // Q1
    List<Vehicule> getVehiculesByCategorie(CategorieVehicule categorie);     // Q2
    List<Vehicule> getVehiculesDisponibles();                                // Q3
    List<Vehicule> getVehiculesByMarqueContenant(String marque);             // Q5
    List<Vehicule> getVehiculesTarifSuperieurA(BigDecimal tarif);            // Q8
    List<Vehicule> getVehiculesDisponiblesByMarque(String marque);           // Q11
}
