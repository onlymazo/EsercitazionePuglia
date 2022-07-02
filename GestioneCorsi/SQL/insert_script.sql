insert into docente values(docente_seq.nextval, 'Pierino', 'Rotolo', 'Materie umanistiche');
insert into docente values(docente_seq.nextval, 'Minimo', 'Indispensabile', 'Religione');
insert into docente values(docente_seq.nextval, 'Donato', 'Caval', 'Giurisprudenza');

insert into corsista values(corsista_seq.nextval, 'Antonio', 'Canovacciuolo', 1);
insert into corsista values(corsista_seq.nextval, 'Salvo', 'Errori', 0);
insert into corsista values(corsista_seq.nextval, 'Maria', 'Di Mario', 0);
insert into corsista values(corsista_seq.nextval, 'Chiara', 'Neri', 1);
insert into corsista values(corsista_seq.nextval, 'Alberto', 'Lupo', 0);
insert into corsista values(corsista_seq.nextval, 'Clark', 'Batman', 1);


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

insert into admin values(123, 'Betacom', 'Apulia',
'aeG$hU%Ak?m@T&80*d2V#Wd5G$hU%Ak?m@T&80*d2V#W46G$hU%Ak?m@T&80*d2V#Wa5G$hU%Ak?m@T&80*d2V#W8bG$hU%Ak?m@T&80*d2V#W4dG$hU%Ak?m@T&80*d2V#WdcG$hU%Ak?m@T&80*d2V#W28G$hU%Ak?m@T&80*d2V#WfbG$hU%Ak?m@T&80*d2V#WffG$hU%Ak?m@T&80*d2V#W34G$hU%Ak?m@T&80*d2V#Wa7G$hU%Ak?m@T&80*d2V#W98G$hU%Ak?m@T&80*d2V#Wd3G$hU%Ak?m@T&80*d2V#Wc4G$hU%Ak?m@T&80*d2V#W29G$hU%Ak?m@T&80*d2V#W');

commit