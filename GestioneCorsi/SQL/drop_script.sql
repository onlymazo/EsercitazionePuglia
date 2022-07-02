drop table corso cascade constraints;
drop table docente cascade constraints;
drop table corsista cascade constraints;
drop table corso_corsista cascade constraints;
drop table admin cascade constraints;

drop sequence corso_seq;
drop sequence corsista_seq;
drop sequence docente_seq;

drop view corsisti_iscritti;
drop view corso_maxfreq;
drop view rep_docenti;
drop view posti_disponibili;