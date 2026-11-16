package tn.esprit.autoloc.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = false, length = 20)
    private String nom;
    @Column(nullable = false, length = 50)
    private String ville;
    @Column(nullable = false, length = 50)
    private String adresse;
    @Column(nullable = false, length = 12)
    private String telephone;
    @JsonIgnore
    @OneToMany(mappedBy = "agence")
    Set<Employe> employes;
    @JsonIgnore
    @OneToMany(mappedBy = "agence")
    Set<Vehicule> vehicules;

}
