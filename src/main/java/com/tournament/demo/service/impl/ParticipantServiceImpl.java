package com.tournament.demo.service.impl;


import com.tournament.demo.domain.Participant;
import com.tournament.demo.repository.ParticipantRepository;
import com.tournament.demo.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public ParticipantServiceImpl() {

    }

    @Override
    public void save(Participant participant) {
        participantRepository.save(participant);
    }
}
