package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.dto.PaiementDTO;
import tn.esprit.autoloc.service.IpaiementService;
import tn.esprit.autoloc.service.ProjetMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paiement")
public class PaiementController {

    private final IpaiementService paiementService;
    private final ProjetMapper mapper;

    @PostMapping("/addPaiement")
    public PaiementDTO addPaiement(@RequestBody Paiement c){
        return mapper.toPaiementDto(paiementService.addPaiement(c));
    }

    @GetMapping("/getPaiements")
    public List<PaiementDTO> getAllPaiements(){
        return mapper.toPaiementDtoList(paiementService.retrieveAllPaiements());
    }

    @GetMapping("/getPaiementId/{idp}")
    public PaiementDTO getPaiementById(@PathVariable long idp){
        return mapper.toPaiementDto(paiementService.retrievePaiement(idp));
    }

    @DeleteMapping("/deletePaiement/{idp}")
    public void deletePaiement(@PathVariable long idp){
        paiementService.removePaiement(idp);
    }

    @PutMapping("/updatePaiement")
    public PaiementDTO updatePaiement(@RequestBody Paiement c){
        return mapper.toPaiementDto(paiementService.updatePaiement(c));
    }
}