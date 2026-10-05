package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;

public class PaiementService implements IPaiementService  {
    PaiementRepository cRepo;
    @Override
    public List<Paiement> retrieveAllPaiements() {
        return (List<Paiement>) cRepo.findAll();
    }

    @Override
    public Paiement addPaiement(Paiement c) {
        return cRepo.save(c);
    }

    @Override
    public Paiement updatePaiement(Paiement c) {
        return cRepo.save(c);
    }

    @Override
    public Paiement retrievePaiement(Long idPaiement) {
        return cRepo.findById(idPaiement).orElse(null);
    }

    @Override
    public void removePaiement(Long idPaiement) {
        cRepo.deleteById(idPaiement);
    }

    @Override
    public List<Paiement> addPaiements(List<Paiement> Paiements) {
        return (List<Paiement>) cRepo.saveAll(Paiements);
    }
}
