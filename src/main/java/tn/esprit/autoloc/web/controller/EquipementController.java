package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.web.dto.EquipementDTO;
import tn.esprit.autoloc.service.IequipementService;
import tn.esprit.autoloc.service.ProjetMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipement")
public class EquipementController {

    private final IequipementService equipementService;
    private final ProjetMapper mapper;

    @PostMapping("/addEquipement")
    public EquipementDTO addEquipement(@RequestBody Equipement c){
        return mapper.toEquipementDto(equipementService.addEquipement(c));
    }

    @GetMapping("/getEquipements")
    public List<EquipementDTO> getAllEquipements(){
        return mapper.toEquipementDtoList(equipementService.retrieveAllEquipements());
    }

    @GetMapping("/getEquipementId/{idc}")
    public EquipementDTO getEquipementById(@PathVariable long idc){
        return mapper.toEquipementDto(equipementService.retrieveEquipement(idc));
    }

    @DeleteMapping("/deleteEquipement/{idc}")
    public void deleteEquipement(@PathVariable long idc){
        equipementService.removeEquipement(idc);
    }

    @PutMapping("/updateEquipement")
    public EquipementDTO updateEquipement(@RequestBody Equipement c){
        return mapper.toEquipementDto(equipementService.updateEquipement(c));
    }
}