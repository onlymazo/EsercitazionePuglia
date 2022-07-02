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

--view di utility per report
create or replace view corsisti_iscritti as
select distinct nome_corsista
from corsista
left join corso_corsista
on (corsista.cod_corsista = corso_corsista.cod_corsista);

create or replace view corso_maxfreq as 
select a.cod_corso, count(a.cod_corsista) as totmax
from corso_corsista a
group by a.cod_corso
having count(a.cod_corsista)=
(select max(mc.totale)
from
(select count(cc.cod_corsista) as totale
from corso_corsista cc
group by cc.cod_corso) mc);

create or replace view rep_docenti as
select count(c.cod_corso) as corsi_docente, c.cod_docente
from corso c
group by c.cod_docente
having count(c.cod_corso)>1;

create or replace view posti_disponibili as
select cc.cod_corso, count(cc.cod_corsista) as n_corsisti
from corso_corsista cc
having count(cc.cod_corsista) <= 12
group by cc.cod_corso;