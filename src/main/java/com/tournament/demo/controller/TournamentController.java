package com.tournament.demo.controller;

import com.tournament.demo.domain.Tournament;
import com.tournament.demo.service.TournamentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
