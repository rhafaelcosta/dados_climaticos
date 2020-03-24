DROP TABLE IF EXISTS DADOS_CLIMATICOS;
DROP TABLE IF EXISTS CIDADE;
DROP TABLE IF EXISTS USUARIO;
  
CREATE TABLE USUARIO (
	id INT AUTO_INCREMENT PRIMARY KEY,
  	nome VARCHAR(250) NOT NULL,  
  	email VARCHAR(250) DEFAULT NULL
);

INSERT INTO USUARIO (nome, email) VALUES ('Admin', 'admin@lactec.org.br');
  
CREATE TABLE CIDADE (
  	id BIGINT PRIMARY KEY,
  	nome VARCHAR(250) NOT NULL,  
  	pais VARCHAR(250) NOT NULL, 
  	ativo BOOL NOT NULL
);

INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (6322752, 'Curitiba', 'BR', true);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3452925, 'Porto Alegre', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (6323121, 'Florianópolis', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3444924, 'Vitória', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3470127, 'Belo Horizonte', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3448439, 'São Paulo', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3451190, 'Rio de Janeiro', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3662574, 'Rio Branco', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3396016, 'Macapá', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3663517, 'Manaus', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3405870, 'Belém', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3662762, 'Porto Velho', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3664980, 'Boa Vista', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3474574, 'Palmas', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3395981, 'Maceió', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3450554, 'Salvador', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (6320062, 'Fortaleza', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3388368, 'São Luís', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3397277, 'João Pessoa', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3390760, 'Recife', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3386496, 'Teresina', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3394023, 'Natal', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3471872, 'Aracaju','BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3462377,'Goiânia', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3465038,'Cuiabá', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3467747,'Campo Grande', 'BR', false);
INSERT INTO CIDADE (id, nome, pais, ativo) VALUES (3469058,'Brasília', 'BR', false);

CREATE TABLE DADOS_CLIMATICOS (
  	id BIGINT AUTO_INCREMENT PRIMARY KEY,
  	cidade_id BIGINT NOT NULL,
	data TIMESTAMP NOT NULL,
	temperatura FLOAT NOT NULL,
	temperatura_maxima FLOAT NOT NULL,
	temperatura_minima FLOAT NOT NULL,
	umidade FLOAT NOT NULL,
	pressao FLOAT NOT NULL,
	CONSTRAINT fk_dados_climaticos_cidade FOREIGN KEY (cidade_id) REFERENCES CIDADE (id)
);

INSERT INTO DADOS_CLIMATICOS (ID, CIDADE_ID, DATA, TEMPERATURA, TEMPERATURA_MAXIMA, TEMPERATURA_MINIMA, UMIDADE, PRESSAO) VALUES (1, 6322752, '2020-01-01', 16.9, 27.9, 15.5, 75.0, 1023.0);
INSERT INTO DADOS_CLIMATICOS (ID, CIDADE_ID, DATA, TEMPERATURA, TEMPERATURA_MAXIMA, TEMPERATURA_MINIMA, UMIDADE, PRESSAO) VALUES (2, 6322752, '2020-01-01', 18.2, 21.6, 14.2, 85.0, 1023.0);
INSERT INTO DADOS_CLIMATICOS (ID, CIDADE_ID, DATA, TEMPERATURA, TEMPERATURA_MAXIMA, TEMPERATURA_MINIMA, UMIDADE, PRESSAO) VALUES (3, 6322752, '2020-02-01', 15.5, 25.5, 11.1, 88.0, 1023.0);
INSERT INTO DADOS_CLIMATICOS (ID, CIDADE_ID, DATA, TEMPERATURA, TEMPERATURA_MAXIMA, TEMPERATURA_MINIMA, UMIDADE, PRESSAO) VALUES (4, 6322752, '2020-02-01', 19.3, 24.3, 16.6, 90.0, 1023.0);