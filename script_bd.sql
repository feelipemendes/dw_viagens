-- PRIMEIRO TEM QUE CRIAR O BANCO dw_viagens, usuario e senha root

create table PASSAGEM
(
	ID INTEGER not null primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
	AEROPORTO_IDA VARCHAR(20) not null,
	AEROPORTO_VOLTA VARCHAR(20) not null,
	DATA_IDA DATE,
	DATA_VOLTA DATE,
	ASSENTOS INTEGER,
	TIPO_VIAGEM CHAR(10),
	COD_AERO_IDA VARCHAR(3),
	COD_AERO_VOLTA VARCHAR(3)
);


INSERT INTO ROOT.PASSAGEM (AEROPORTO_IDA, AEROPORTO_VOLTA, DATA_IDA, DATA_VOLTA, ASSENTOS, TIPO_VIAGEM, COD_AERO_IDA, COD_AERO_VOLTA) 
	VALUES ( 'Congonhas', 'Porto', '2016-12-12', '2016-12-31', 20, 'IdaVolta  ', 'CON', 'POR');


INSERT INTO ROOT.PASSAGEM ( AEROPORTO_IDA, AEROPORTO_VOLTA, DATA_IDA, DATA_VOLTA, ASSENTOS, TIPO_VIAGEM, COD_AERO_IDA, COD_AERO_VOLTA) 
	VALUES ( 'Galeão', 'Texas', '2016-12-01', '2016-12-30', 10, 'idaVolta  ', 'GAL', 'TEX');
-- USUARIOS --

CREATE TABLE USUARIOS (
	email VARCHAR(30),
	senha VARCHAR(8),
	nome VARCHAR(30)
)

INSERT INTO USUARIOS VALUES ('be@123','123','Bernardo');
INSERT INTO USUARIOS VALUES ('lu@123','123','Luiz');
INSERT INTO USUARIOS VALUES ('ri@123','123','Henrique');