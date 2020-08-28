package com.tournament.demo.controller;

import com.tournament.demo.domain.Participant;
import com.tournament.demo.service.ParticipantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("participant")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping(value = "/participants")
    public void save(@RequestBody Participant participant) {
        participantService.save(participant);
    }
}
