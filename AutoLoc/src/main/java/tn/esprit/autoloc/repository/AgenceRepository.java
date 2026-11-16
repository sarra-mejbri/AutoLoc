package tn.esprit.autoloc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.domain.Agence;

import java.util.List;

@Repository
public interface AgenceRepository extends CrudRepository<Agence,Long> {

    // Q4 : agences situées dans une ville donnée
    // SELECT * FROM agence WHERE ville = :ville
    List<Agence> findByVille(String ville);
}
