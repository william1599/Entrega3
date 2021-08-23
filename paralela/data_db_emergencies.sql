\connect db_emergencias2;

CREATE EXTENSION postgis;
SELECT AddGeometryColumn('emergency','location','4326','POINT',2);
SELECT AddGeometryColumn('voluntary','location','4326','POINT',2);

INSERT INTO "institution" (name) VALUES ('OugrŽe'),('Bunbury'),('Birmingham'),('Chicago'),('Shikarpur'),('Roccamena'),('Wadgassen'),('Guirsch'),('Ramenskoye'),('Jhelum');

INSERT INTO "skill" (name) VALUES ('organizacion'),('informatico'),('manual'),('comunicador'),('orientador'),('liderazgo'),('gestion de problemas'),('gasfiteria'),('mecanica'),('construccion');


--Create User

CREATE USER dbusr_grupo2 WITH PASSWORD 'grupo2';

-- Grant connect to my data base

GRANT CONNECT ON DATABASE db_emergencias2 TO dbusr_grupo2;

-- Grant all table for SELECT, INSERT, UPDATE, DELETE

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO dbusr_grupo2;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO dbusr_grupo2;;
