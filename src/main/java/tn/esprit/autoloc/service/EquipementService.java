package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.EquipementRepository;

import java.util.List;

public class EquipementService implements IEquipementService  {
    EquipementRepository cRepo;
    @Override
    public List<Equipement> retrieveAllEquipements() {
        return (List<Equipement>) cRepo.findAll();
    }

    @Override
    public Equipement addEquipement(Equipement c) {
        return cRepo.save(c);
    }

    @Override
    public Equipement updateEquipement(Equipement c) {
        return cRepo.save(c);
    }

    @Override
    public Equipement retrieveEquipement(Long idEquipement) {
        return cRepo.findById(idEquipement).orElse(null);
    }

    @Override
    public void removeEquipement(Long idEquipement) {
        cRepo.deleteById(idEquipement);
    }

    @Override
    public List<Equipement> addEquipements(List<Equipement> Equipements) {
        return (List<Equipement>) cRepo.saveAll(Equipements);
    }
}
