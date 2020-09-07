package com.tournament.demo.service.impl;

import com.tournament.demo.domain.Participant;
import com.tournament.demo.domain.Tournament;
import com.tournament.demo.service.ParticipantService;
import com.tournament.demo.service.TournamentService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = {"classpath:sql_scripts/Create_table.sql", "classpath:sql_scripts/Truncate_tables.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class TournamentServiceImplTest {

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private ParticipantService participantService;

    @BeforeEach
    public void init() {
        final Tournament tournament = new Tournament();
        tournament.setName("Ligue");
        tournamentService.save(tournament);
    }

    @Test
    void save() {
        if (tournamentService.count() == 1) {
            Assert.assertTrue(tournamentService.existsById(1));
        }
    }

    @Test
    void findById() {
        if (tournamentService.count() == 1) {
            Assert.assertTrue(tournamentService.existsById(1));
        }
    }

    @Test
    void findAll() {
        final Tournament tournament = new Tournament();
        tournament.setName("SiriaA");
        tournamentService.save(tournament);

        Assert.assertEquals(2, tournamentService.count());
    }

    @Test
    void deleteById() {
        tournamentService.deleteById(1);
        Assert.assertTrue(tournamentService.findById(1) == null);
    }

    @Test
    void findByName() {
        Assert.assertTrue(tournamentService.existsByName("Ligue"));
    }

    @Test
    void addPartipiciantToTournament() {
        Participant participant = new Participant();
        participant.setNickName("Valera");
        participant.setTournament(tournamentService.findByName("Ligue"));
        participantService.save(participant);
        tournamentService.addPartipiciantToTournament(tournamentService.findByName("Ligue").getName(),participantService.findByNickName("Valera").getNickName());

        Assert.assertEquals("Valera",participantService.findByNickName("Valera").getNickName());
    }

    @Test
    void addPartipiciantToTournamentId() {
        Participant participant = new Participant();
        participant.setNickName("Valera");
        participant.setTournament(tournamentService.findByName("Ligue"));
        participantService.save(participant);
        tournamentService.addPartipiciantToTournamentId(tournamentService.findByName("Ligue").getId(),participantService.findByNickName("Valera").getId());

        Assert.assertEquals("Valera",participantService.findByNickName("Valera").getNickName());
    }

   /* @Test
    void deletePartipiciantFromTournamentId() {

        Participant participant = new Participant();
        participant.setNickName("Valera");
        participant.setTournament(tournamentService.findByName("Ligue"));
        participantService.save(participant);
        tournamentService.deletePartipiciantFromTournamentId(tournamentService.findByName("Ligue").getId(),participantService.findByNickName("Valera").getId());

        Assert.assertNull(participantService.findByNickName("Valera").getTournament());
    }*/
}