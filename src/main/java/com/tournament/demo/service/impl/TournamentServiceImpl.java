package com.tournament.demo.service.impl;


import com.tournament.demo.domain.Participant;
import com.tournament.demo.domain.Tournament;
import com.tournament.demo.repository.ParticipantRepository;
import com.tournament.demo.repository.TournamentRepository;
import com.tournament.demo.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    public TournamentServiceImpl() {
    }

    @Override
    public void save(Tournament tournament) {
        tournamentRepository.save(tournament);
    }

    public Tournament findById(int id) {
        return tournamentRepository.findById(id);
    }

    public List<Tournament> findAll() {
        return tournamentRepository.findAll();
    }

    public void deleteById(int id) {
        tournamentRepository.deleteById(id);
    }

    public Tournament findByName(String name) {
        return tournamentRepository.findByName(name);
    }

    @Override
    public void addPartipiciantToTournament(String tournamentName, String participantName) {
        final Tournament newTournament = tournamentRepository.findByName(tournamentName);
        final Participant participant = participantRepository.findByNickName(participantName);
        participant.setTournament(newTournament);
        newTournament.addParticipant(participant);
        tournamentRepository.save(newTournament);
    }

    @Override
    public void addPartipiciantToTournamentId(int tournamentId, int participantId) {
        final Tournament newTournament = tournamentRepository.findById(tournamentId);
        final Participant participant = participantRepository.findById(participantId);
        participant.setTournament(newTournament);
        newTournament.addParticipant(participant);
        tournamentRepository.save(newTournament);
    }

    @Override
    public void deletePartipiciantFromTournamentId(int tournamentId, int participantId) {
        final Tournament newTournament = tournamentRepository.findById(tournamentId);
        final Participant participant = participantRepository.findById(participantId);
        participant.setTournament(null);
        tournamentRepository.save(newTournament);
    }
}
