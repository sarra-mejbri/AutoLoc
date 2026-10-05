package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.util.List;

public class ReservationService implements IReservationService  {
    ReservationRepository cRepo;
    @Override
    public List<Reservation> retrieveAllReservations() {
        return (List<Reservation>) cRepo.findAll();
    }

    @Override
    public Reservation addReservation(Reservation c) {
        return cRepo.save(c);
    }

    @Override
    public Reservation updateReservation(Reservation c) {
        return cRepo.save(c);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return cRepo.findById(idReservation).orElse(null);
    }

    @Override
    public void removeReservation(Long idReservation) {
        cRepo.deleteById(idReservation);
    }

    @Override
    public List<Reservation> addReservations(List<Reservation> Reservations) {
        return (List<Reservation>) cRepo.saveAll(Reservations);
    }
}
