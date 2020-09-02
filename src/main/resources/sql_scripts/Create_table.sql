create table if not exists Tournament
(
    tournament_id INT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(50)
);

create table if not exists Participant
(
    participant_id   INT AUTO_INCREMENT PRIMARY KEY,
    nickName         VARCHAR(25),
    tournament_fk_id INT
);


create table if not exists TournamentMatch
(
    mach_id               INT AUTO_INCREMENT PRIMARY KEY,
    startTime             DATE,
    finischTime           DATE,
    scores                DECIMAL,
    tournament_fk_id      INT,
    participant_two_fk_id INT,
    participant_one_fk_id INT,
    FOREIGN KEY (participant_two_fk_id) REFERENCES Participant (participant_id),
    FOREIGN KEY (participant_one_fk_id) REFERENCES Participant (participant_id)
);


ALTER TABLE TournamentMatch
    ADD FOREIGN KEY (tournament_fk_id) REFERENCES Tournament (tournament_id);

ALTER TABLE Participant
    ADD FOREIGN KEY (tournament_fk_id) REFERENCES Tournament (tournament_id);
 