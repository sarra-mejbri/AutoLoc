package tn.esprit.autoloc.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import tn.esprit.autoloc.domain.ModePaiement;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaiementDTO {
    private BigDecimal montant;
    private Date datePaiement;
    private ModePaiement modePaiement;
}
