package com.tournament.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "mach")
public class TournamentMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mach_id")
    private int id;

    @Column(name = "start_time")
    private LocalDate startTime;

    @Column(name = "finisch_time")
    private LocalDate finischTime;

    private BigDecimal scores;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tournament_fk_id")
    private Tournament tournament;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_two_fk_id")
    private Participant participantTwo;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_one_fk_id")
    private Participant participantOne;

    public TournamentMatch() {
    }

    public TournamentMatch(LocalDate startTime, LocalDate finischTime, BigDecimal scores, Tournament tournament,
                           Participant participantTwo, Participant participantOne) {
        this.startTime = startTime;
        this.finischTime = finischTime;
        this.scores = scores;
        this.tournament = tournament;
        this.participantTwo = participantTwo;
        this.participantOne = participantOne;
    }

    public TournamentMatch(LocalDate startTime, LocalDate finischTime, Participant participantTwo,
                           Participant participantOne) {
        this.startTime = startTime;
        this.finischTime = finischTime;
        this.participantTwo = participantTwo;
        this.participantOne = participantOne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getFinischTime() {
        return finischTime;
    }

    public void setFinischTime(LocalDate finischTime) {
        this.finischTime = finischTime;
    }

    public BigDecimal getScores() {
        return scores;
    }

    public void setScores(BigDecimal scores) {
        this.scores = scores;
    }

    public Participant getParticipantOne() {
        return participantOne;
    }

    public void setParticipantOne(Participant participantOne) {
        this.participantOne = participantOne;
    }

    public Participant getParticipantTwo() {
        return participantTwo;
    }

    public void setParticipantTwo(Participant participantTwo) {
        this.participantTwo = participantTwo;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournamentMatch that = (TournamentMatch) o;
        return id == that.id &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(finischTime, that.finischTime) &&
                Objects.equals(scores, that.scores) &&
                Objects.equals(tournament, that.tournament) &&
                Objects.equals(participantTwo, that.participantTwo) &&
                Objects.equals(participantOne, that.participantOne);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, finischTime, scores, tournament, participantTwo, participantOne);
    }

    @Override
    public String toString() {
        return "TournamentMatch{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", finischTime=" + finischTime +
                ", scores=" + scores +
                ", tournament=" + tournament +
                ", participantTwo=" + participantTwo +
                ", participantOne=" + participantOne +
                '}';
    }
}
