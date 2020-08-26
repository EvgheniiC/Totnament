package com.tournament.demo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private int id;

    @OneToMany(mappedBy = "tournament", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE,
            CascadeType.MERGE})
    private Set<TournamentMatch> tournamentMatchSet = new HashSet<>();

    private String name;

    public Tournament() {
    }

    public Set<TournamentMatch> getTournamentMatchSet() {
        return tournamentMatchSet;
    }

    public void setTournamentMatchSet(Set<TournamentMatch> tournamentMatchSet) {
        this.tournamentMatchSet = tournamentMatchSet;
    }

    public Tournament(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String tuornamentName) {
        this.name = tuornamentName;
    }

    public void addMatch(TournamentMatch tournamentMatch){
        tournamentMatchSet.add(tournamentMatch);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament that = (Tournament) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
