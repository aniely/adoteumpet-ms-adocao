
 

CREATE TABLE IF NOT EXISTS tb_estado
(
    id bigint NOT NULL,
    nome varchar(255) NOT NULL,
    sigla varchar(2) NOT NULL,
	
    CONSTRAINT tb_estado_pkey PRIMARY KEY (id)

);

CREATE TABLE IF NOT EXISTS tb_cidade
(
    id bigint NOT NULL,
    nome varchar(255) NOT NULL,
    id_estado bigint NOT NULL,
	
    CONSTRAINT tb_cidade_pkey PRIMARY KEY (id),
    CONSTRAINT tb_cidade_tb_estado_fkey FOREIGN KEY (id_estado) REFERENCES tb_estado (id)


);
CREATE TABLE IF NOT EXISTS tb_especie
(
    id bigint NOT NULL,
    nome varchar(255) NOT NULL,
     
    CONSTRAINT tb_especie_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_raca
(
    id bigint NOT NULL,
    nome varchar(255) NOT NULL,
	id_especie bigint NOT NULL,
     
	 
    CONSTRAINT tb_raca_pkey PRIMARY KEY (id),
	CONSTRAINT tb_raca_tb_especie_fkey FOREIGN KEY (id_especie) REFERENCES tb_especie (id)
	
);

CREATE TABLE IF NOT EXISTS tb_usuario
(
    id bigint NOT NULL,
    nome varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    senha varchar(255) NOT NULL,
	
	
    CONSTRAINT tb_usuario_pkey PRIMARY KEY (id)
 
);

CREATE TABLE IF NOT EXISTS tb_animal
(
    id bigint NOT NULL,
    nome varchar(255) NOT NULL,
    data_inclusao timestamp without time zone,
    porte varchar(255) NOT NULL,
    genero varchar(1) NOT NULL,
    status varchar(255) NOT NULL,
    id_raca bigint NOT NULL,
    cor varchar(255) NOT NULL,
    descricao text NOT NULL,
    id_tutor bigint NOT NULL,
    id_adotado_por bigint,
    id_cidade bigint NOT NULL,
	
    CONSTRAINT tb_animal_pkey PRIMARY KEY (id),
	CONSTRAINT tb_animal_tb_raca_fkey FOREIGN KEY (id_raca) REFERENCES tb_raca (id),
	CONSTRAINT tb_animal_tb_usuario_fkey FOREIGN KEY (id_tutor) REFERENCES tb_usuario (id),
	CONSTRAINT tb_animal_tb_usuario_tb_usuario_fkey FOREIGN KEY (id_adotado_por) REFERENCES tb_usuario (id),
	CONSTRAINT tb_animal_tb_cidade_fkey FOREIGN KEY (id_cidade) REFERENCES tb_cidade (id)

);


 


CREATE SEQUENCE IF NOT EXISTS tb_especie INCREMENT 1 START 3 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; 
CREATE SEQUENCE IF NOT EXISTS tb_raca INCREMENT 1 START 3 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; 
CREATE SEQUENCE IF NOT EXISTS tb_animal INCREMENT 1 START 3 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; 
CREATE SEQUENCE IF NOT EXISTS tb_imagem INCREMENT 1 START 3 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; 
CREATE SEQUENCE IF NOT EXISTS tb_estado INCREMENT 1 START 3 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; 
CREATE SEQUENCE IF NOT EXISTS tb_cidade INCREMENT 1 START 3 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; 
CREATE SEQUENCE IF NOT EXISTS tb_usuario INCREMENT 1 START 3 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1; 


CREATE SEQUENCE IF NOT EXISTS hibernate_sequence INCREMENT 1  MINVALUE 1  MAXVALUE 9223372036854775807 START 1 CACHE 1;




INSERT INTO public.tb_especie values (1, 'Gato');
INSERT INTO public.tb_especie values (2, 'Cachorro');

INSERT INTO public.tb_raca values (1, 'Raça não definida', 1);
INSERT INTO public.tb_raca values (2, 'Siamês', 1);
INSERT INTO public.tb_raca values (3, 'Poodle', 2);
INSERT INTO public.tb_raca values (4, 'Yorkshire', 2);
INSERT INTO public.tb_raca values (5, 'Raça não definida', 2);


INSERT INTO public.tb_estado values (1, 'Rio de Janeiro', 'RJ');
INSERT INTO public.tb_estado values (2, 'São Paulo', 'SP');

INSERT INTO public.tb_cidade values (1, 'Campos dos Goytacazes', 1);
INSERT INTO public.tb_cidade values (2, 'São João da Barra', 1);
INSERT INTO public.tb_cidade values (3, 'Ubatuba', 2);
