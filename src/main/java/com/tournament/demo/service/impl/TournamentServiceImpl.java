package com.tournament.demo.service.impl;


import com.tournament.demo.domain.Tournament;
import com.tournament.demo.repository.TournamentRepository;
import com.tournament.demo.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    public TournamentServiceImpl() {
    }

    @Override
    public void save(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    public void createTournament(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    public Tournament findById(int id) {
        return tournamentRepository.findById(id);
    }

    public List<Tournament> findAll() {
        return tournamentRepository.findAll();
    }

    public void deleteTournament(Tournament tournament) {
        tournamentRepository.delete(tournament);
    }

    public Tournament findByName(String name) {
        return tournamentRepository.findByName(name);
    }


}
