-- Tabela identificador de unidade
insert into UNIT_IDENTIFIER (name, range_max, range_min, separator_points, created_date) values (''   ,      1, 3, 1, now());
insert into UNIT_IDENTIFIER (name, range_max, range_min, separator_points, created_date) values ('mil',      4, 6, 2, now());
--Tabela de centenas
insert into HUNDRED (name, range_min, range_max, created_date) values ('cem',           100, 100.9, now());
insert into HUNDRED (name, range_min, range_max, created_date) values ('cento',	        101, 199.9, now());
insert into HUNDRED (name, range_min, range_max, created_date) values ('duzentos',      200, 299.9, now());
insert into HUNDRED (name, range_min, range_max, created_date) values ('trezentos',     300, 399.9, now());
insert into HUNDRED (name, range_min, range_max, created_date) values ('quatrocentos',  400, 499.9, now());
insert into HUNDRED (name, range_min, range_max, created_date) values ('quinhentos',    500, 599.9, now());
insert into HUNDRED (name, range_min, range_max, created_date) values ('seiscentos',    600, 699.9, now());
insert into HUNDRED (name, range_min, range_max, created_date) values ('setecentos',    700, 799.9, now());
insert into HUNDRED (name, range_min, range_max, created_date) values ('oitocentos',    800, 899.9, now());
insert into HUNDRED (name, range_min, range_max, created_date) values ('novecentos',    900, 999.9, now());
--Tabela de dezenas
insert into TEN (name, range_min, range_max, created_date) values ('vinte',	    20,	29.9, now());
insert into TEN (name, range_min, range_max, created_date) values ('trinta',	30,	39.9, now());
insert into TEN (name, range_min, range_max, created_date) values ('quarenta',	40,	49.9, now());
insert into TEN (name, range_min, range_max, created_date) values ('cinquenta',	50,	59.9, now());
insert into TEN (name, range_min, range_max, created_date) values ('sessenta',	60,	69.9, now());
insert into TEN (name, range_min, range_max, created_date) values ('setenta',	70,	79.9, now());
insert into TEN (name, range_min, range_max, created_date) values ('oitenta',	80,	89.9, now());
insert into TEN (name, range_min, range_max, created_date) values ('noventa',	90,	99.9, now());
--Tabela de unidades
insert into UNIT (name, range_min, range_max, created_date) values ('um',	    1   ,   1.9, now());
insert into UNIT (name, range_min, range_max, created_date) values ('dois',	    2   ,   2.9, now());
insert into UNIT (name, range_min, range_max, created_date) values ('três',	    3   ,   3.9, now());
insert into UNIT (name, range_min, range_max, created_date) values ('quatro',	4   ,	4.9, now());
insert into UNIT (name, range_min, range_max, created_date) values ('cinco',	5   ,	5.9, now());
insert into UNIT (name, range_min, range_max, created_date) values ('seis',	    6   ,	6.9, now());
insert into UNIT (name, range_min, range_max, created_date) values ('sete',	    7   ,	7.9, now());
insert into UNIT (name, range_min, range_max, created_date) values ('oito',	    8   ,	8.9, now());
insert into UNIT (name, range_min, range_max, created_date) values ('nove',	    9   ,	9.9, now());

insert into UNIT_TEN (name, range_min, range_max, created_date) values ('dez',	    10,	10.9, now());
insert into UNIT_TEN (name, range_min, range_max, created_date) values ('onze',	    11,	11.9, now());
insert into UNIT_TEN (name, range_min, range_max, created_date) values ('doze',	    12,	12.9, now());
insert into UNIT_TEN (name, range_min, range_max, created_date) values ('treze',	13,	13.9, now());
insert into UNIT_TEN (name, range_min, range_max, created_date) values ('quatorze',	14,	14.9, now());
insert into UNIT_TEN (name, range_min, range_max, created_date) values ('quinze',	15,	15.9, now());
insert into UNIT_TEN (name, range_min, range_max, created_date) values ('dezesseis',16,	16.9, now());
insert into UNIT_TEN (name, range_min, range_max, created_date) values ('dezessete',17,	17.9, now());
insert into UNIT_TEN (name, range_min, range_max, created_date) values ('dezoito',	18,	18.9, now());
insert into UNIT_TEN (name, range_min, range_max, created_date) values ('dezenove',	19,	19.9, now());

