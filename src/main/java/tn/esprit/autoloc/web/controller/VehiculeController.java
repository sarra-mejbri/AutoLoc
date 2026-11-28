package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.web.dto.VehiculeDTO;
import tn.esprit.autoloc.service.IvehiculeService;
import tn.esprit.autoloc.service.ProjetMapper;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicule")
public class VehiculeController {

    private final IvehiculeService VehiculeService;
    private final ProjetMapper mapper;

    @PostMapping("/addVehicule")
    public VehiculeDTO addVehicule(@RequestBody Vehicule c){
        return mapper.toVehiculeDto(VehiculeService.addVehicule(c));
    }

    @GetMapping("/getVehicules")
    public List<VehiculeDTO> getAllVehicules(){
        return mapper.toVehiculeDtoList(VehiculeService.retrieveAllVehicules());
    }

    @GetMapping("/getVehiculeId/{idc}")
    public VehiculeDTO getVehiculeById(@PathVariable long idc){
        return mapper.toVehiculeDto(VehiculeService.retrieveVehicule(idc));
    }

    @DeleteMapping("/deleteVehicule/{idc}")
    public void deleteVehicule(@PathVariable long idc){
        VehiculeService.removeVehicule(idc);
    }

    @PutMapping("/updateVehicule")
    public VehiculeDTO updateVehicule(@RequestBody Vehicule c){
        return mapper.toVehiculeDto(VehiculeService.updateVehicule(c));
    }

    @PutMapping("/affecterVehicule/{idVehicule}/{idAgence}")
    public VehiculeDTO affecterVehicule(@PathVariable Long idVehicule, @PathVariable Long idAgence){
        return mapper.toVehiculeDto(VehiculeService.affecterVehicule(idVehicule, idAgence));
    }

    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public VehiculeDTO affecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement){
        return mapper.toVehiculeDto(VehiculeService.affecterEquipement(idVehicule, idEquipement));
    }

    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public VehiculeDTO desaffecterEquipement(@PathVariable Long idVehicule, @PathVariable Long idEquipement){
        return mapper.toVehiculeDto(VehiculeService.desaffecterEquipement(idVehicule, idEquipement));
    }

    // ----- Atelier Keywords -----

    // Q1
    @GetMapping("/getByMarque/{marque}")
    public List<VehiculeDTO> getVehiculesByMarque(@PathVariable String marque){
        return mapper.toVehiculeDtoList(VehiculeService.getVehiculesByMarque(marque));
    }

    // Q2
    @GetMapping("/getByCategorie/{categorie}")
    public List<VehiculeDTO> getVehiculesByCategorie(@PathVariable CategorieVehicule categorie){
        return mapper.toVehiculeDtoList(VehiculeService.getVehiculesByCategorie(categorie));
    }

    // Q3
    @GetMapping("/getDisponibles")
    public List<VehiculeDTO> getVehiculesDisponibles(){
        return mapper.toVehiculeDtoList(VehiculeService.getVehiculesDisponibles());
    }

    // Q5
    @GetMapping("/getByMarqueContenant/{marque}")
    public List<VehiculeDTO> getVehiculesByMarqueContenant(@PathVariable String marque){
        return mapper.toVehiculeDtoList(VehiculeService.getVehiculesByMarqueContenant(marque));
    }

    // Q8
    @GetMapping("/getTarifSuperieurA/{tarif}")
    public List<VehiculeDTO> getVehiculesTarifSuperieurA(@PathVariable BigDecimal tarif){
        return mapper.toVehiculeDtoList(VehiculeService.getVehiculesTarifSuperieurA(tarif));
    }

    // Q11
    @GetMapping("/getDisponiblesByMarque/{marque}")
    public List<VehiculeDTO> getVehiculesDisponiblesByMarque(@PathVariable String marque){
        return mapper.toVehiculeDtoList(VehiculeService.getVehiculesDisponiblesByMarque(marque));
    }
}