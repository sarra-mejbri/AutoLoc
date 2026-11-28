 package tn.esprit.autoloc.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    // numPermis et datePermis masqués (données sensibles)
}
