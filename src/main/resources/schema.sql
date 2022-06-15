BEGIN;

CREATE TABLE IF NOT EXISTS public.users
(
    id integer,
    first_name character varying(255),
    last_name character varying(255) ,
    email character varying(255)  NOT NULL,
    password character varying(255)  NOT NULL,

    PRIMARY KEY (id)
    );
CREATE TABLE IF NOT EXISTS public.expositions
(
    id integer,
    name character varying(255)  NOT NULL,
    description character varying(255) ,
    showroom character varying(255) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS public.tickets
(
    id integer,
    userid integer,
    expositionid integer,
    price integer NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (expositionid)
    REFERENCES public.expositions (id),
    FOREIGN KEY (userid)
    REFERENCES public.users (id) MATCH SIMPLE
    );





END;