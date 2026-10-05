package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

public class VehiculeService implements IVehiculeService  {
    VehiculeRepository cRepo;
    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return (List<Vehicule>) cRepo.findAll();
    }

    @Override
    public Vehicule addVehicule(Vehicule c) {
        return cRepo.save(c);
    }

    @Override
    public Vehicule updateVehicule(Vehicule c) {
        return cRepo.save(c);
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {
        return cRepo.findById(idVehicule).orElse(null);
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        cRepo.deleteById(idVehicule);
    }

    @Override
    public List<Vehicule> addVehicules(List<Vehicule> Vehicules) {
        return (List<Vehicule>) cRepo.saveAll(Vehicules);
    }
}
