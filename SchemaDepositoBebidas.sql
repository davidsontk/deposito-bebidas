CREATE DATABASE deposito_bebidas;

CREATE TABLE public.tipo_bebida
(
    id serial NOT NULL,
    tipo character varying(100)  NOT NULL,
    quantidade_litros integer NOT NULL,
    CONSTRAINT tipo_bebida_pkey PRIMARY KEY (id)
);


CREATE TABLE public.secao
(
    id serial NOT NULL,
    codigo integer NOT NULL,
    tipo_bebida_id integer,
    CONSTRAINT secao_pkey PRIMARY KEY (id),
    CONSTRAINT fk_tipo_bebida FOREIGN KEY (tipo_bebida_id)
        REFERENCES public.tipo_bebida (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.bebida
(
    id serial NOT NULL,
    quantidade_litros integer NOT NULL,
    tipo_bebida_id integer NOT NULL,
    secao_id integer NOT NULL,
    CONSTRAINT bebida_pkey PRIMARY KEY (id),
    CONSTRAINT fk_secao_id FOREIGN KEY (secao_id)
        REFERENCES public.secao (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_tipo_bebida FOREIGN KEY (tipo_bebida_id)
        REFERENCES public.tipo_bebida (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE public.historico
(
    id serial NOT NULL,
    data_hora timestamp without time zone NOT NULL,
    tipo_bebida_id integer NOT NULL,
    secao_id integer NOT NULL,
    responsavel character varying(200) NOT NULL,
    tipo character varying(20) NOT NULL,
    quantidade_litros integer NOT NULL,
    CONSTRAINT historico_pkey PRIMARY KEY (id),
    CONSTRAINT fk_secao_id FOREIGN KEY (secao_id)
        REFERENCES public.secao (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_tipo_bebida_id FOREIGN KEY (tipo_bebida_id)
        REFERENCES public.tipo_bebida (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);