package com.tournament.demo.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private int id;

    @OneToMany(mappedBy = "tournament", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<TournamentMatch> tournamentMatchSet = new HashSet<>();

    private String name;

    @OneToMany(mappedBy = "tournament", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Participant> participantList = new ArrayList<>();

    public Tournament() {
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
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

    public void addMatch(TournamentMatch tournamentMatch) {
        tournamentMatchSet.add(tournamentMatch);
    }

    public void addParticipant(Participant participant) {
        participantList.add(participant);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tournament that = (Tournament) o;
        return id == that.id &&
                Objects.equals(tournamentMatchSet, that.tournamentMatchSet) &&
                Objects.equals(name, that.name) &&
                Objects.equals(participantList, that.participantList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, participantList);
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", tournamentMatchSet=" + tournamentMatchSet +
                ", name='" + name + '\'' +
                ", participantList=" + participantList +
                '}';
    }
}
