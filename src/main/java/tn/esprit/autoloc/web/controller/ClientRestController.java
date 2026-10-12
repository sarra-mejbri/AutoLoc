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
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@Tag(name = "Gestion Clients", description = "Opérations CRUD sur les clients")
@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientRestController {

    IClientService clientService;

    // GET http://localhost:8081/client
    @Operation(summary = "Lister", description = "Récupérer tous les clients de la base de données")
    @ApiResponse(responseCode = "200", description = "Liste retournée (éventuellement vide)",
            content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Client.class))))
    @GetMapping
    public List<Client> getClients() {
        return clientService.retrieveAllClients();
    }

    // GET http://localhost:8081/client/1
    @Operation(summary = "Consulter par id", description = "Récupérer un client par son identifiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client trouvé",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content)
    })
    @GetMapping("/{client-id}")
    public ResponseEntity<Client> retrieveClient(
            @Parameter(description = "Identifiant du client à rechercher", example = "1")
            @PathVariable("client-id") Long clientId) {
        Client result = clientService.retrieveClient(clientId);
        return result == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(result);
    }

    // POST http://localhost:8081/client
    @Operation(summary = "Ajouter", description = "Créer un client (l'identifiant est généré par la base)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client créé",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))),
            @ApiResponse(responseCode = "400", description = "Corps JSON invalide", content = @Content),
            @ApiResponse(responseCode = "409", description = "Violation de contrainte (email ou numéro de permis déjà utilisé…)", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client c) {
        c.setIdClient(null); // force la création
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.addClient(c));
    }

    // PUT http://localhost:8081/client
    @Operation(summary = "Modifier", description = "Mettre à jour un client existant (l'id doit être dans le corps)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client modifié",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))),
            @ApiResponse(responseCode = "400", description = "Identifiant absent ou corps invalide", content = @Content),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content),
            @ApiResponse(responseCode = "409", description = "Violation de contrainte", content = @Content)
    })
    @PutMapping
    public ResponseEntity<Client> modifyClient(@RequestBody Client c) {
        if (c.getIdClient() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (clientService.retrieveClient(c.getIdClient()) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientService.updateClient(c));
    }

    // DELETE http://localhost:8081/client/1
    @Operation(summary = "Supprimer", description = "Supprimer un client par son identifiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Client supprimé", content = @Content),
            @ApiResponse(responseCode = "404", description = "Client introuvable", content = @Content),
            @ApiResponse(responseCode = "409", description = "Suppression impossible : client référencé ailleurs", content = @Content)
    })
    @DeleteMapping("/{client-id}")
    public ResponseEntity<Void> removeClient(
            @Parameter(description = "Identifiant du client à supprimer", example = "1")
            @PathVariable("client-id") Long clientId) {
        if (clientService.retrieveClient(clientId) == null) {
            return ResponseEntity.notFound().build();
        }
        clientService.removeClient(clientId);
        return ResponseEntity.noContent().build();
    }
}