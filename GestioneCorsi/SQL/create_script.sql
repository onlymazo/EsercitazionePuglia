-- Client
create table docente(
cod_docente int,
nome_docente varchar2(30) not null,
cognome_docente varchar2(30) not null,
cv_docente varchar2(50) not null,
constraint p_coddocente primary key (cod_docente)
);

create table corsista(
cod_corsista int,
nome_corsista varchar2(30) not null,
cognome_corsista varchar2(30) not null,
precedenti_formativi int not null,
constraint p_codcorsista primary key (cod_corsista)
);

create table corso(
cod_corso int,
cod_docente int,
nome_corso varchar2(30) not null,
data_inizio date not null,
data_fine date not null,
costo_corso number(6,2) not null,
commenti varchar2(100),
aula_corso int not null,
constraint p_codcorso primary key (cod_corso),
constraint f_coddocente foreign key (cod_docente) references docente(cod_docente)
);

create table corso_corsista(
cod_corso int,
cod_corsista int,
constraint f_codcorso foreign key (cod_corso) references corso(cod_corso) on delete cascade,
constraint f_codcorsista foreign key (cod_corsista) references corsista(cod_corsista) on delete cascade
);



----sequenze per corso, corsista, docente
create sequence corso_seq;
create sequence corsista_seq;
create sequence docente_seq;

-- Admin
create table admin(
cod_admin int,
nome_admin varchar2(30) not null,
cognome_admin varchar2(30) not null,
password varchar2(2000) not null,
constraint p_codadmin primary key (cod_admin)
);

create view report as
select count(cod_corsista), max(select count(cod_corsista) from corsista c, corso group by), avg
