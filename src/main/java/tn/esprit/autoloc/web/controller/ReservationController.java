package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IreservationService;

import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    private final IreservationService reserService;
    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation p){
        return reserService.addReservation(p);
    }
    @GetMapping("/getReservations")
    public List<Reservation> getAllReservations(){
        return reserService.retrieveAllReservations();
    }
    @GetMapping("/getReservationId/{idp}")
    public Reservation getReservationById(@PathVariable long idp){
        return reserService.retrieveReservation(idp);
    }
    @DeleteMapping("/deleteReservation/{idp}")
    public void deleteReservation(@PathVariable long idp){
        reserService.removeReservation(idp);
    }

    @PutMapping("/updateReservation")
    public Reservation updateReservation(@RequestBody Reservation p){
        return reserService.updateReservation(p);
    }



    // Q14
    @GetMapping("/getDateDebutApres/{date}")
    public List<Reservation> getReservationsDateDebutApres(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return reserService.getReservationsDateDebutApres(date);
    }
}
