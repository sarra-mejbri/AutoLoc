package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.List;

public class ContratService implements IContratService  {
    ContratRepository cRepo;
    @Override
    public List<Contrat> retrieveAllContrats() {
        return (List<Contrat>) cRepo.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return cRepo.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return cRepo.save(c);
    }

    @Override
    public Contrat retrieveContrat(Long idContrat) {
        return cRepo.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Long idContrat) {
        cRepo.deleteById(idContrat);
    }

    @Override
    public List<Contrat> addContrats(List<Contrat> Contrats) {
        return (List<Contrat>) cRepo.saveAll(Contrats);
    }
}
