package com.tournament.demo.controller;

import com.tournament.demo.domain.TournamentMatch;
import com.tournament.demo.service.TournamentMatchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tournament_match")
public class TournamentMatchController {

    private final TournamentMatchService tournamentMatchService;


    public TournamentMatchController(TournamentMatchService tournamentMatchService) {
        this.tournamentMatchService = tournamentMatchService;
    }

    @PostMapping(value = "/tournament_matchs")
    public void save(@RequestBody TournamentMatch tournamentMatch) {
        tournamentMatchService.save(tournamentMatch);
    }
}
