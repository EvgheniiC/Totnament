package com.tournament.demo.repository;


import com.tournament.demo.domain.TournamentMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentMatchRepository extends JpaRepository<TournamentMatch, Integer> {


}
