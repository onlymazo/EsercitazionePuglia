insert into docente values(docente_seq.nextval, 'Pierino', 'Rotolo', 'Materie umanistiche');
insert into docente values(docente_seq.nextval, 'Minimo', 'Indispensabile', 'Religione');
insert into docente values(docente_seq.nextval, 'Donato', 'Caval', 'Giurisprudenza');

insert into corsista values(corsista_seq.nextval, 'Antonio', 'Canovacciuolo', 1);
insert into corsista values(corsista_seq.nextval, 'Salvo', 'Errori', 0);
insert into corsista values(corsista_seq.nextval, 'Maria', 'Di Mario', 0);
insert into corsista values(corsista_seq.nextval, 'Chiara', 'Neri', 1);

insert into corso values(corso_seq.nextval, (select cod_docente from docente where cognome_docente = 'Rotolo'), 'Arte', to_date('10/05/22', 'dd/mm/yy'), to_date('22/07/22', 'dd/mm/yy'), 540, 'Corso su Botticelli', 23);
insert into corso values(corso_seq.nextval, (select cod_docente from docente where cognome_docente = 'Rotolo'), 'Storia', to_date('03/09/22', 'dd/mm/yy'), to_date('15/12/22', 'dd/mm/yy'), 360, 'Corso su Storia moderna', 13);
insert into corso values(corso_seq.nextval, (select cod_docente from docente where cognome_docente = 'Indispensabile'), 'Religione', to_date('11/06/22', 'dd/mm/yy'), to_date('12/06/22', 'dd/mm/yy'), 35, 'Corso su Padre Pio', 4);
insert into corso values(corso_seq.nextval, (select cod_docente from docente where cognome_docente = 'Caval'), 'Legge', to_date('20/10/22', 'dd/mm/yy'), to_date('20/12/22', 'dd/mm/yy'), 950, 'Non guardate in bocca al docente', 8);

insert into corso_corsista values((select cod_corso from corso where nome_corso = 'Arte'), (select cod_corsista from corsista where cognome_corsista = 'Canovacciuolo'));
insert into corso_corsista values((select cod_corso from corso where nome_corso = 'Arte'), (select cod_corsista from corsista where cognome_corsista = 'Neri'));
insert into corso_corsista values((select cod_corso from corso where nome_corso = 'Arte'), (select cod_corsista from corsista where cognome_corsista = 'Di Mario'));
insert into corso_corsista values((select cod_corso from corso where nome_corso = 'Storia'), (select cod_corsista from corsista where cognome_corsista = 'Errori'));
insert into corso_corsista values((select cod_corso from corso where nome_corso = 'Storia'), (select cod_corsista from corsista where cognome_corsista = 'Di Mario'));
insert into corso_corsista values((select cod_corso from corso where nome_corso = 'Religione'), (select cod_corsista from corsista where cognome_corsista = 'Errori'));
insert into corso_corsista values((select cod_corso from corso where nome_corso = 'Legge'), (select cod_corsista from corsista where cognome_corsista = 'Canovacciuolo'));
insert into corso_corsista values((select cod_corso from corso where nome_corso = 'Legge'), (select cod_corsista from corsista where cognome_corsista = 'Errori'));

commit
