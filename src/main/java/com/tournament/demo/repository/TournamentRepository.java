package com.tournament.demo.repository;

import com.tournament.demo.domain.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    Tournament findById(int id);

    Tournament findByName(String name);

}
