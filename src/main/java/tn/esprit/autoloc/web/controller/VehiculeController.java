package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IvehiculeService;


import java.util.List;
import tn.esprit.autoloc.domain.CategorieVehicule;
import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicule")
public class VehiculeController {
    private final IvehiculeService VehiculeService;
    @PostMapping("/addVehicule")
    public Vehicule addVehicule(@RequestBody Vehicule c){
        return VehiculeService.addVehicule(c);
    }
    @GetMapping("/getVehicules")
    public List<Vehicule> getAllVehicules(){
        return VehiculeService.retrieveAllVehicules();
    }
    @GetMapping("/getVehiculeId/{idc}")
    public Vehicule getVehiculeById(@PathVariable long idc){
        return VehiculeService.retrieveVehicule(idc);
    }
    @DeleteMapping("/deleteVehicule/{idc}")
    public void deleteVehicule(@PathVariable long idc){
        VehiculeService.removeVehicule(idc);
    }

    @PutMapping("/updateVehicule")
    public Vehicule updateVehicule(@RequestBody Vehicule c){
        return VehiculeService.updateVehicule(c);
    }

    @PutMapping("/affecterVehicule/{idVehicule}/{idAgence}")
    public Vehicule affecterVehicule(@PathVariable Long idVehicule, @PathVariable Long idAgence){
        return VehiculeService.affecterVehicule(idVehicule, idAgence);
    }

    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule affecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement){
        return VehiculeService.affecterEquipement(idVehicule, idEquipement);
    }

    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule desaffecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement){
        return VehiculeService.desaffecterEquipement(idVehicule, idEquipement);
    }

    // ----- Atelier Keywords -----

    // Q1
    @GetMapping("/getByMarque/{marque}")
    public List<Vehicule> getVehiculesByMarque(@PathVariable String marque){
        return VehiculeService.getVehiculesByMarque(marque);
    }

    // Q2
    @GetMapping("/getByCategorie/{categorie}")
    public List<Vehicule> getVehiculesByCategorie(@PathVariable CategorieVehicule categorie){
        return VehiculeService.getVehiculesByCategorie(categorie);
    }

    // Q3
    @GetMapping("/getDisponibles")
    public List<Vehicule> getVehiculesDisponibles(){
        return VehiculeService.getVehiculesDisponibles();
    }

    // Q5
    @GetMapping("/getByMarqueContenant/{marque}")
    public List<Vehicule> getVehiculesByMarqueContenant(@PathVariable String marque){
        return VehiculeService.getVehiculesByMarqueContenant(marque);
    }

    // Q8
    @GetMapping("/getTarifSuperieurA/{tarif}")
    public List<Vehicule> getVehiculesTarifSuperieurA(@PathVariable BigDecimal tarif){
        return VehiculeService.getVehiculesTarifSuperieurA(tarif);
    }

    // Q11
    @GetMapping("/getDisponiblesByMarque/{marque}")
    public List<Vehicule> getVehiculesDisponiblesByMarque(@PathVariable String marque){
        return VehiculeService.getVehiculesDisponiblesByMarque(marque);
    }
}
