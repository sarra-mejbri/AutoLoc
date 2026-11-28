package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.dto.AgenceDTO;
import tn.esprit.autoloc.service.IagenceService;
import tn.esprit.autoloc.service.ProjetMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agence")
public class AgenceController {

    private final IagenceService agenceService;
    private final ProjetMapper mapper;

    @PostMapping("/addAgence")
    public AgenceDTO addAgence(@RequestBody Agence a){
        return mapper.toAgenceDto(agenceService.addAgence(a));
    }

    @GetMapping("/getAgences")
    public List<AgenceDTO> getAllAgences(){
        return mapper.toAgenceDtoList(agenceService.retrieveAllAgences());
    }

    @GetMapping("/getClientId/{ida}")
    public AgenceDTO getAgenceById(@PathVariable long ida){
        return mapper.toAgenceDto(agenceService.retrieveAgence(ida));
    }

    @DeleteMapping("/deleteClient/{idc}")
    public void deleteClient(@PathVariable long idc){
        agenceService.removeAgence(idc);
    }

    @PutMapping("/updateAgence")
    public AgenceDTO updateAgence(@RequestBody Agence a){
        return mapper.toAgenceDto(agenceService.updateAgence(a));
    }

    // ----- Atelier Keywords -----

    // Q4 : GET /agence/getByVille/Tunis
    @GetMapping("/getByVille/{ville}")
    public List<AgenceDTO> getAgencesByVille(@PathVariable String ville){
        return mapper.toAgenceDtoList(agenceService.getAgencesByVille(ville));
    }
}