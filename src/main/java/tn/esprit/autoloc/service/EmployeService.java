package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;

public class EmployeService implements IEmployeService  {
    EmployeRepository cRepo;
    @Override
    public List<Employe> retrieveAllEmployes() {
        return (List<Employe>) cRepo.findAll();
    }

    @Override
    public Employe addEmploye(Employe c) {
        return cRepo.save(c);
    }

    @Override
    public Employe updateEmploye(Employe c) {
        return cRepo.save(c);
    }

    @Override
    public Employe retrieveEmploye(Long idEmploye) {
        return cRepo.findById(idEmploye).orElse(null);
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        cRepo.deleteById(idEmploye);
    }

    @Override
    public List<Employe> addEmployes(List<Employe> Employes) {
        return (List<Employe>) cRepo.saveAll(Employes);
    }
}
