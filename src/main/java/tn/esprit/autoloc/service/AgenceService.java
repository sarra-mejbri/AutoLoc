package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;

public class AgenceService implements IAgenceService  {
    AgenceRepository cRepo;
    @Override
    public List<Agence> retrieveAllAgences() {
        return (List<Agence>) cRepo.findAll();
    }

    @Override
    public Agence addAgence(Agence c) {
        return cRepo.save(c);
    }

    @Override
    public Agence updateAgence(Agence c) {
        return cRepo.save(c);
    }

    @Override
    public Agence retrieveAgence(Long idAgence) {
        return cRepo.findById(idAgence).orElse(null);
    }

    @Override
    public void removeAgence(Long idAgence) {
        cRepo.deleteById(idAgence);
    }

    @Override
    public List<Agence> addAgences(List<Agence> Agences) {
        return (List<Agence>) cRepo.saveAll(Agences);
    }
}
