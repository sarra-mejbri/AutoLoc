package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.dto.EmployeDTO;
import tn.esprit.autoloc.service.IemployeService;
import tn.esprit.autoloc.service.ProjetMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employe")
public class EmployeController {

    private final IemployeService employeService;
    private final ProjetMapper mapper;

    @PostMapping("/addEmploye")
    public EmployeDTO addEmploye(@RequestBody Employe c){
        return mapper.toEmployeDto(employeService.addEmploye(c));
    }

    @GetMapping("/getEmployes")
    public List<EmployeDTO> getAllEmployes(){
        return mapper.toEmployeDtoList(employeService.retrieveAllEmployes());
    }

    @GetMapping("/getEmployeId/{idc}")
    public EmployeDTO getEmployeById(@PathVariable long idc){
        return mapper.toEmployeDto(employeService.retrieveEmploye(idc));
    }

    @DeleteMapping("/deleteEmploye/{idc}")
    public void deleteEmploye(@PathVariable long idc){
        employeService.removeEmploye(idc);
    }

    @PutMapping("/updateEmploye")
    public EmployeDTO updateEmploye(@RequestBody Employe c){
        return mapper.toEmployeDto(employeService.updateEmploye(c));
    }

    @PutMapping("/desaffecterEmploye/{idEmploye}")
    public EmployeDTO desaffecterEmploye(@PathVariable Long idEmploye){
        return mapper.toEmployeDto(employeService.desaffecterEmploye(idEmploye));
    }

    @PutMapping("/affecterEmploye/{idEmploye}/{idAgence}")
    public EmployeDTO affecterEmploye(@PathVariable Long idEmploye, @PathVariable Long idAgence){
        return mapper.toEmployeDto(employeService.affecterEmploye(idEmploye, idAgence));
    }
}