package com.tournament.demo.service.impl;


import com.tournament.demo.domain.Participant;
import com.tournament.demo.repository.ParticipantRepository;
import com.tournament.demo.service.ParticipantService;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;

    public ParticipantServiceImpl(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public void createParticipant(Participant participant){
        participantRepository.save(participant);
    }








}
