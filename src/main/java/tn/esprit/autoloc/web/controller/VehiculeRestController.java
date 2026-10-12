package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@Tag(name = "Gestion Véhicules", description = "Opérations CRUD sur les véhicules")
@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
public class VehiculeRestController {

    IVehiculeService vehiculeService;

    // GET http://localhost:8081/vehicule
    @Operation(summary = "Lister", description = "Récupérer tous les véhicules de la base de données")
    @ApiResponse(responseCode = "200", description = "Liste retournée (éventuellement vide)",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Vehicule.class))))
    @GetMapping
    public List<Vehicule> getVehicules() {
        return vehiculeService.retrieveAllVehicules();
    }

    // GET http://localhost:8081/vehicule/1
    @Operation(summary = "Consulter par id", description = "Récupérer un véhicule par son identifiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Véhicule trouvé",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vehicule.class))),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content)
    })
    @GetMapping("/{vehicule-id}")
    public ResponseEntity<Vehicule> retrieveVehicule(
            @Parameter(description = "Identifiant du véhicule à rechercher", example = "1")
            @PathVariable("vehicule-id") Long vehiculeId) {
        Vehicule result = vehiculeService.retrieveVehicule(vehiculeId);
        return result == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(result);
    }

    // POST http://localhost:8081/vehicule
    @Operation(summary = "Ajouter", description = "Créer un véhicule rattaché à une agence existante (l'identifiant est généré par la base)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Véhicule créé",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vehicule.class))),
            @ApiResponse(responseCode = "400", description = "Corps JSON invalide (enum inconnue, type incorrect…)", content = @Content),
            @ApiResponse(responseCode = "409", description = "Violation de contrainte (immatriculation déjà utilisée, agence inexistante…)", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Vehicule> addVehicule(@RequestBody Vehicule v) {
        v.setIdVehicule(null); // force la création
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculeService.addVehicule(v));
    }

    // PUT http://localhost:8081/vehicule
    @Operation(summary = "Modifier", description = "Mettre à jour un véhicule existant (l'id doit être dans le corps)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Véhicule modifié",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vehicule.class))),
            @ApiResponse(responseCode = "400", description = "Identifiant absent ou corps invalide", content = @Content),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content),
            @ApiResponse(responseCode = "409", description = "Violation de contrainte", content = @Content)
    })
    @PutMapping
    public ResponseEntity<Vehicule> modifyVehicule(@RequestBody Vehicule v) {
        if (v.getIdVehicule() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (vehiculeService.retrieveVehicule(v.getIdVehicule()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehiculeService.updateVehicule(v));
    }

    // DELETE http://localhost:8081/vehicule/1
    @Operation(summary = "Supprimer", description = "Supprimer un véhicule par son identifiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Véhicule supprimé", content = @Content),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable", content = @Content),
            @ApiResponse(responseCode = "409", description = "Suppression impossible : véhicule référencé ailleurs (réservation…)", content = @Content)
    })
    @DeleteMapping("/{vehicule-id}")
    public ResponseEntity<Void> removeVehicule(
            @Parameter(description = "Identifiant du véhicule à supprimer", example = "1")
            @PathVariable("vehicule-id") Long vehiculeId) {
        if (vehiculeService.retrieveVehicule(vehiculeId) == null) {
            return ResponseEntity.notFound().build();
        }
        vehiculeService.removeVehicule(vehiculeId);
        return ResponseEntity.noContent().build();
    }
}