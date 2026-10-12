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
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@Tag(name = "Gestion Agences", description = "Opérations CRUD sur les agences")
@RestController
@AllArgsConstructor
@RequestMapping("/agence")
public class AgenceRestController {

    IAgenceService agenceService;

    // GET http://localhost:8081/agence
    @Operation(summary = "Lister", description = "Récupérer toutes les agences de la base de données")
    @ApiResponse(responseCode = "200", description = "Liste retournée (éventuellement vide)",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Agence.class))))
    @GetMapping
    public List<Agence> getAgences() {
        return agenceService.retrieveAllAgences();
    }

    // GET http://localhost:8081/agence/1
    @Operation(summary = "Consulter par id", description = "Récupérer une agence par son identifiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agence trouvée",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Agence.class))),
            @ApiResponse(responseCode = "404", description = "Agence introuvable", content = @Content)
    })
    @GetMapping("/{agence-id}")
    public ResponseEntity<Agence> retrieveAgence(
            @Parameter(description = "Identifiant de l'agence à rechercher", example = "1")
            @PathVariable("agence-id") Long agenceId) {
        Agence result = agenceService.retrieveAgence(agenceId);
        return result == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(result);
    }

    // POST http://localhost:8081/agence
    @Operation(summary = "Ajouter", description = "Créer une agence (l'identifiant est généré par la base)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Agence créée",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Agence.class))),
            @ApiResponse(responseCode = "400", description = "Corps JSON invalide", content = @Content),
            @ApiResponse(responseCode = "409", description = "Violation de contrainte (champ obligatoire manquant…)", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Agence> addAgence(@RequestBody Agence a) {
        a.setIdAgence(null); // force la création
        return ResponseEntity.status(HttpStatus.CREATED).body(agenceService.addAgence(a));
    }

    // PUT http://localhost:8081/agence
    @Operation(summary = "Modifier", description = "Mettre à jour une agence existante (l'id doit être dans le corps)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Agence modifiée",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Agence.class))),
            @ApiResponse(responseCode = "400", description = "Identifiant absent ou corps invalide", content = @Content),
            @ApiResponse(responseCode = "404", description = "Agence introuvable", content = @Content),
            @ApiResponse(responseCode = "409", description = "Violation de contrainte", content = @Content)
    })
    @PutMapping
    public ResponseEntity<Agence> modifyAgence(@RequestBody Agence a) {
        if (a.getIdAgence() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (agenceService.retrieveAgence(a.getIdAgence()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agenceService.updateAgence(a));
    }

    // DELETE http://localhost:8081/agence/1
    @Operation(summary = "Supprimer", description = "Supprimer une agence par son identifiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Agence supprimée", content = @Content),
            @ApiResponse(responseCode = "404", description = "Agence introuvable", content = @Content),
            @ApiResponse(responseCode = "409", description = "Suppression impossible : agence référencée ailleurs", content = @Content)
    })
    @DeleteMapping("/{agence-id}")
    public ResponseEntity<Void> removeAgence(
            @Parameter(description = "Identifiant de l'agence à supprimer", example = "1")
            @PathVariable("agence-id") Long agenceId) {
        if (agenceService.retrieveAgence(agenceId) == null) {
            return ResponseEntity.notFound().build();
        }
        agenceService.removeAgence(agenceId);
        return ResponseEntity.noContent().build();
    }
}