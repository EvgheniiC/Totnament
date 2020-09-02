package com.tournament.demo.service.impl;

import com.tournament.demo.config.ConfigTest;
import com.tournament.demo.domain.Participant;
import com.tournament.demo.domain.Tournament;
import com.tournament.demo.repository.ParticipantRepository;
import com.tournament.demo.repository.TournamentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(ConfigTest.class)
@Sql(scripts = {"classpath:sql_scripts/Create_table.sql", "classpath:sql_scripts/Truncate_tables.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class TournamentServiceImplTest {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Before
    public void init() {

        final Tournament tournament = new Tournament();
        tournament.setName("Ligue");
        tournamentRepository.save(tournament);

    }

    @Test
    void save() {
        if (tournamentRepository.count() == 1){
            Assert.assertTrue(tournamentRepository.existsById(1));
        }


    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void addPartipiciantToTournament() {
    }

    @Test
    void addPartipiciantToTournamentId() {
    }

    @Test
    void deletePartipiciantFromTournamentId() {
    }
}