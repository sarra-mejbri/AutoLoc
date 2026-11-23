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

    // Nombre de réservations de chaque client (y compris les clients sans réservation)
    @Query("SELECT c.idClient, c.nom, COUNT(r) FROM Client c LEFT JOIN c.reservations r GROUP BY c.idClient, c.nom")
    List<Object[]> countReservationsByClient();
}
