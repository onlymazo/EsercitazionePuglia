drop table corso cascade constraints;
drop table docente cascade constraints;
drop table corsista cascade constraints;
drop table corso_corsista cascade constraints;
drop table admin cascade constraints;

drop sequence corso_seq;
drop sequence corsista_seq;
drop sequence docente_seq;

drop view tot_corsisti;
drop view rep_docenti;
drop view posti_disponibili;