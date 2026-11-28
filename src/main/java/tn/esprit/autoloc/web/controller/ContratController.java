package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.dto.ContratDTO;
import tn.esprit.autoloc.service.IcontratService;
import tn.esprit.autoloc.service.ProjetMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contrat")
public class ContratController {

    private final IcontratService contratService;
    private final ProjetMapper mapper;

    @PostMapping("/addContrat")
    public ContratDTO addContrat(@RequestBody Contrat c){
        return mapper.toContratDto(contratService.addContrat(c));
    }

    @GetMapping("/getContrats")
    public List<ContratDTO> getAllContrats(){
        return mapper.toContratDtoList(contratService.retrieveAllContrats());
    }

    @GetMapping("/getContratId/{idc}")
    public ContratDTO getContratById(@PathVariable long idc){
        return mapper.toContratDto(contratService.retrieveContrat(idc));
    }

    @DeleteMapping("/deleteContrat/{idc}")
    public void deleteContrat(@PathVariable long idc){
        contratService.removeContrat(idc);
    }

    @PutMapping("/updateContrat")
    public ContratDTO updateContrat(@RequestBody Contrat c){
        return mapper.toContratDto(contratService.updateContrat(c));
    }
}