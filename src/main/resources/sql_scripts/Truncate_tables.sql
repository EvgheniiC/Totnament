SET @@foreign_key_checks = 0;

TRUNCATE TABLE Participant;
TRUNCATE TABLE Tournament;
TRUNCATE TABLE TournamentMatch;

SET @@foreign_key_checks = 1;