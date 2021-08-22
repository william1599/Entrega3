CREATE DATABASE db_emergencias2;

\connect db_emergencias2;

CREATE TABLE institution (
    id_institution integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name text
);

CREATE TABLE skill (
    id_skill integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name text
);


CREATE TABLE emergency0 (
    id_emergency integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    cod_emergency integer,
    name text,
    estado boolean,
    tableName text,
    id_institution integer REFERENCES institution
);
CREATE TABLE emergency1 (
    id_emergency integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    cod_emergency integer,
    name text,
    estado boolean,
    tableName text,
    id_institution integer REFERENCES institution
);
CREATE TABLE emergency2 (
    id_emergency integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    cod_emergency integer,
    name text,
    estado boolean,
    tableName text,
    id_institution integer REFERENCES institution
);


CREATE TABLE eme_skill0 (
    id_eme_skill integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    
    id_skill integer REFERENCES skill
);
--id_emergency integer REFERENCES emergency,
CREATE TABLE eme_skill1 (
    id_eme_skill integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    
    id_skill integer REFERENCES skill
);
--id_emergency integer REFERENCES emergency,
CREATE TABLE eme_skill2 (
    id_eme_skill integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    
    id_skill integer REFERENCES skill
);
