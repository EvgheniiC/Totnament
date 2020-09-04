package com.tournament.demo.repository;

import com.tournament.demo.domain.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    Tournament findById(int id);

    Tournament findByName(String name);

    List<Tournament> findAll();

    void deleteById(int id);

    boolean existsByName(String name);
}
