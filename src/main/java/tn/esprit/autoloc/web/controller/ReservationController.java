package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.dto.ReservationDTO;
import tn.esprit.autoloc.service.IreservationService;
import tn.esprit.autoloc.service.ProjetMapper;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final IreservationService reserService;
    private final ProjetMapper mapper;

    @PostMapping("/addReservation")
    public ReservationDTO addReservation(@RequestBody Reservation p){
        return mapper.toReservationDto(reserService.addReservation(p));
    }

    @GetMapping("/getReservations")
    public List<ReservationDTO> getAllReservations(){
        return mapper.toReservationDtoList(reserService.retrieveAllReservations());
    }

    @GetMapping("/getReservationId/{idp}")
    public ReservationDTO getReservationById(@PathVariable long idp){
        return mapper.toReservationDto(reserService.retrieveReservation(idp));
    }

    @DeleteMapping("/deleteReservation/{idp}")
    public void deleteReservation(@PathVariable long idp){
        reserService.removeReservation(idp);
    }

    @PutMapping("/updateReservation")
    public ReservationDTO updateReservation(@RequestBody Reservation p){
        return mapper.toReservationDto(reserService.updateReservation(p));
    }

    // Q14
    @GetMapping("/getDateDebutApres/{date}")
    public List<ReservationDTO> getReservationsDateDebutApres(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        return mapper.toReservationDtoList(reserService.getReservationsDateDebutApres(date));
    }
}