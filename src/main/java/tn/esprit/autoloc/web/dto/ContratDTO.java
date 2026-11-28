package tn.esprit.autoloc.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratDTO {
    private Date dateSignature;
    private BigDecimal montantTotal;
    private boolean valide;
}
