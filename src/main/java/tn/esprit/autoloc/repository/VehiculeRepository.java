package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VehiculeRepository extends CrudRepository<Vehicule,Long> {

    // Q1
    List<Vehicule> findByMarque(String marque);

    // Q2
    List<Vehicule> findByCategorie(CategorieVehicule categorie);

    // Q3
    List<Vehicule> findByStatut(StatutVehicule statut);

    // Q5
    List<Vehicule> findByMarqueContaining(String marque);

    // Q8
    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);

    // Q11
    List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut);

    // ----- Atelier JPQL -----

    // Véhicules appartenant à une agence donnée
    @Query("SELECT v FROM Vehicule v WHERE v.agence.id = :idAgence")
    List<Vehicule> getVehiculesByAgence(@Param("idAgence") Long idAgence);

    // Nombre de véhicules de chaque agence (y compris les agences sans véhicule)
    @Query("SELECT a.id, a.nom, COUNT(v) FROM Agence a LEFT JOIN a.vehicules v GROUP BY a.id, a.nom")
    List<Object[]> countVehiculesByAgence();
}
