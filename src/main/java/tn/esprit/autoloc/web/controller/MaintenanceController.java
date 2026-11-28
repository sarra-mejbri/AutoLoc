package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.dto.MaintenanceDTO;
import tn.esprit.autoloc.service.ImaintenanceService;
import tn.esprit.autoloc.service.ProjetMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceController {

    private final ImaintenanceService maintenanceService;
    private final ProjetMapper mapper;

    @PostMapping("/addMaintenance")
    public MaintenanceDTO addMaintenance(@RequestBody Maintenance c){
        return mapper.toMaintenanceDto(maintenanceService.addMaintenance(c));
    }

    @GetMapping("/getMaintenances")
    public List<MaintenanceDTO> getAllMaintenances(){
        return mapper.toMaintenanceDtoList(maintenanceService.retrieveAllMaintenances());
    }

    @GetMapping("/getMaintenanceId/{idc}")
    public MaintenanceDTO getMaintenanceById(@PathVariable long idc){
        return mapper.toMaintenanceDto(maintenanceService.retrieveMaintenance(idc));
    }

    @DeleteMapping("/deleteMaintenance/{idc}")
    public void deleteMaintenance(@PathVariable long idc){
        maintenanceService.removeMaintenance(idc);
    }

    @PutMapping("/updateMaintenance")
    public MaintenanceDTO updateMaintenance(@RequestBody Maintenance c){
        return mapper.toMaintenanceDto(maintenanceService.updateMaintenance(c));
    }
}