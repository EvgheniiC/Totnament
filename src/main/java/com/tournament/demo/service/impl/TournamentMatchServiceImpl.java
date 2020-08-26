package com.tournament.demo.service.impl;

import com.tournament.demo.domain.TournamentMatch;
import com.tournament.demo.repository.TournamentMatchRepository;
import com.tournament.demo.service.TournamentMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentMatchServiceImpl implements TournamentMatchService {

    @Autowired
    private TournamentMatchRepository tournamentMatchRepository;

    public TournamentMatchServiceImpl() {
    }


    @Override
    public void save(TournamentMatch match) {
        tournamentMatchRepository.save(match);
    }
}
