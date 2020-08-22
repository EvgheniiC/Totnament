package com.tournament.demo.service.impl;

import com.tournament.demo.repository.TournamentMatchRepository;
import com.tournament.demo.service.MatchService;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    private final TournamentMatchRepository tournamentMatchRepository;

    public MatchServiceImpl(TournamentMatchRepository tournamentMatchRepository) {
        this.tournamentMatchRepository = tournamentMatchRepository;
    }


}
