package com.tournament.demo.controller;

import com.tournament.demo.domain.Participant;
import com.tournament.demo.domain.Tournament;
import com.tournament.demo.service.TournamentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tournament")
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping(value = "/tournaments")
    public void save(@RequestBody Tournament tournament) {
        tournamentService.save(tournament);
    }

    @GetMapping(value = "/{tournamentId}")
    public Tournament findTournamentById(@PathVariable("tournamentId") int id) {
        return tournamentService.findById(id);
    }

    @GetMapping(value = "/tournaments")
    public List<Tournament> findAllTournament() {
        return tournamentService.findAll();
    }

    @DeleteMapping(value = "/{tournamentId}")
    public void deleteTournamentById(@PathVariable("tournamentId") int id) {
        tournamentService.deleteById(id);
    }

    @PostMapping(value = "/tournament/participants/{tournamentName}/{participiantName}")
    public void addParticipiantToTournament(@PathVariable("tournamentName")  String tournamentName, @PathVariable("participiantName") String participiantName) {
        tournamentService.addPartipiciantToTournament(tournamentName,participiantName);
    }

    @PostMapping(value = "/tournament/participant/{tournamentId}/{participiantId}")
    public void addParticipiantToTournamentId(@PathVariable("tournamentId")  int tournamentId, @PathVariable("participiantId") int participiantId) {
        tournamentService.addPartipiciantToTournamentId(tournamentId,participiantId);

    }

}
