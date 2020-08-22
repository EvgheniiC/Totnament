package com.tournament.demo.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "Mach")
public class TournamentMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mach_id")
    private int id;

    private LocalDate startTime;

    private LocalDate finischTime;

    private BigDecimal scores;

    @ManyToOne
    @JoinColumn(name = "tournament_fk_id")
    private Tournament tournament;

    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "participant_two_fk_id")
    private Participant participantTwo;

    @OneToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
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

}
