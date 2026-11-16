package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VehiculeRepository extends CrudRepository<Vehicule,Long> {

    // Q1 : véhicules ayant une marque précise
    // SELECT * FROM vehicule WHERE marque = :marque
    List<Vehicule> findByMarque(String marque);

    // Q2 : véhicules d'une catégorie donnée
    // SELECT * FROM vehicule WHERE categorie = :categorie
    List<Vehicule> findByCategorie(CategorieVehicule categorie);

    // Q3 : véhicules ayant le statut DISPONIBLE (statut passé en paramètre)
    // SELECT * FROM vehicule WHERE statut = :statut
    List<Vehicule> findByStatut(StatutVehicule statut);

    // Q5 : véhicules dont la marque contient une chaîne saisie
    // SELECT * FROM vehicule WHERE marque LIKE '%:marque%'
    List<Vehicule> findByMarqueContaining(String marque);

    // Q8 : véhicules dont le tarif est supérieur à une valeur (100 DT)
    // SELECT * FROM vehicule WHERE tarif_journalier > :tarif
    List<Vehicule> findByTarifJournalierGreaterThan(BigDecimal tarif);

    // Q11 : véhicules d'une marque donnée ET ayant le statut DISPONIBLE
    // SELECT * FROM vehicule WHERE marque = :marque AND statut = :statut
    List<Vehicule> findByMarqueAndStatut(String marque, StatutVehicule statut);
}
