package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Reservation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {

    // Q14
    List<Reservation> findByDateDebutAfter(LocalDate date);

    // ----- Atelier JPQL -----
    // Réservations effectuées par un client
    @Query("SELECT r FROM Reservation r WHERE r.client.idClient = :idClient")
    List<Reservation> getReservationsByClient(@Param("idClient") Long idClient);

    // Nombre de réservations effectuées par chaque client
    @Query("SELECT r.client.idClient, COUNT(r) FROM Reservation r GROUP BY r.client.idClient")
    List<Object[]> countReservationsByClient();
}
