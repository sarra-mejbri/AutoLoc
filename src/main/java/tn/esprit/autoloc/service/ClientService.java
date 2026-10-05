package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.ClientRepository;

import java.util.List;

public class ClientService implements IClientService  {
    ClientRepository cRepo;
    @Override
    public List<Client> retrieveAllClients() {
        return (List<Client>) cRepo.findAll();
    }

    @Override
    public Client addClient(Client c) {
        return cRepo.save(c);
    }

    @Override
    public Client updateClient(Client c) {
        return cRepo.save(c);
    }

    @Override
    public Client retrieveClient(Long idClient) {
        return cRepo.findById(idClient).orElse(null);
    }

    @Override
    public void removeClient(Long idClient) {
        cRepo.deleteById(idClient);
    }

    @Override
    public List<Client> addClients(List<Client> clients) {
        return (List<Client>) cRepo.saveAll(clients);
    }
}
