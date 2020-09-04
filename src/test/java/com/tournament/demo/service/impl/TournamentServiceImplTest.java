package com.tournament.demo.service.impl;

import com.tournament.demo.domain.Tournament;
import com.tournament.demo.repository.ParticipantRepository;
import com.tournament.demo.repository.TournamentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = {"classpath:sql_scripts/Create_table.sql", "classpath:sql_scripts/Truncate_tables.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class TournamentServiceImplTest {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @BeforeEach
    public void init() {
        final Tournament tournament = new Tournament();
        tournament.setName("Ligue");
        tournamentRepository.save(tournament);
    }

    @Test
    void save() {
        if (tournamentRepository.count() == 1) {
            Assert.assertTrue(tournamentRepository.existsById(1));
        }
    }

    @Test
    void findById() {
        if (tournamentRepository.count() == 1) {
            Assert.assertTrue(tournamentRepository.existsById(1));
        }
    }

    @Test
    void findAll() {
        final Tournament tournament = new Tournament();
        tournament.setName("SiriaA");
        tournamentRepository.save(tournament);

        Assert.assertEquals(2,tournamentRepository.count());
    }

    @Test
    void deleteById() {
        tournamentRepository.deleteById(1);
        Assert.assertTrue(tournamentRepository.findById(1) == null);
    }

    @Test
    void findByName() {
        Assert.assertTrue(tournamentRepository.existsByName("Ligue"));
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