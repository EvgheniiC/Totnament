package com.tournament.demo.service;

import com.tournament.demo.domain.Tournament;

import java.util.List;

public interface TournamentService  {

    void save(Tournament tournament);

    Tournament findById(int id);

    List<Tournament> findAll();

    void deleteById(int id);
}
