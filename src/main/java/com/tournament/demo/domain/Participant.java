package com.tournament.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id")
    private int id;

    @NotNull
    @Column(name = "nick_name")
    private String nickName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tournament_fk_id")
    private Tournament tournament;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
        Participant that = (Participant) o;
        return id == that.id &&
                Objects.equals(nickName, that.nickName) &&
                Objects.equals(tournament, that.tournament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickName, tournament);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", tournament=" + tournament +
                '}';
    }
}
