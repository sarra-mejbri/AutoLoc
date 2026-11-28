package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.dto.ClientDTO;
import tn.esprit.autoloc.service.IclientService;
import tn.esprit.autoloc.service.ProjetMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final IclientService clientService;
    private final ProjetMapper mapper;

    @PostMapping("/addClient")
    public ClientDTO addClient(@RequestBody Client c){
        return mapper.toClientDto(clientService.addClient(c));
    }

    @GetMapping("/getClients")
    public List<ClientDTO> getAllCLients(){
        return mapper.toClientDtoList(clientService.retrieveAllClients());
    }

    @GetMapping("/getClientId/{idc}")
    public ClientDTO getClientById(@PathVariable long idc){
        return mapper.toClientDto(clientService.retrieveClient(idc));
    }

    @DeleteMapping("/deleteClient/{idc}")
    public void deleteClient(@PathVariable long idc){
        clientService.removeClient(idc);
    }

    @PutMapping("/updateClient")
    public ClientDTO updateClient(@RequestBody Client c){
        return mapper.toClientDto(clientService.updateClient(c));
    }
}