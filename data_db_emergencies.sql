\connect db_emergencias;

CREATE EXTENSION postgis;
SELECT AddGeometryColumn('emergency','location','4326','POINT',2);
SELECT AddGeometryColumn('voluntary','location','4326','POINT',2);

INSERT INTO "institution" (name) VALUES ('OugrŽe'),('Bunbury'),('Birmingham'),('Chicago'),('Shikarpur'),('Roccamena'),('Wadgassen'),('Guirsch'),('Ramenskoye'),('Jhelum');

INSERT INTO "skill" (name) VALUES ('organizacion'),('informatico'),('manual'),('comunicador'),('orientador'),('liderazgo'),('gestion de problemas'),('gasfiteria'),('mecanica'),('construccion');

INSERT INTO "emergency" (name,estado,id_institution,location) VALUES ('fuego','true',5,ST_GeomFromText('POINT(-70.381343 -23.352326)', 4326)),('tierra','false',10,ST_GeomFromText('POINT(-70.180262 -23.458515)', 4326)),('hambruna','true',2,ST_GeomFromText('POINT(-70.238165 -23.669187)', 4326)),('hambruna','false',4,ST_GeomFromText('POINT(-69.934143 -27.055696)', 4326)),('sequia','true',4,ST_GeomFromText('POINT(-71.069879 -29.988968)', 4326)),('accidente','true',5,ST_GeomFromText('POINT(-71.262084 -29.967057)', 4326)),('hambruna','false',7,ST_GeomFromText('POINT(-71.338382 -29.943026)', 4326)),('accidente','false',7,ST_GeomFromText('POINT(-71.384551 -32.910716)', 4326)),('accidente','false',5,ST_GeomFromText('POINT(-71.584285 -33.108686)', 4326)),('apagon','false',3,ST_GeomFromText('POINT(-71.293812 -32.945300)', 4326));
INSERT INTO "emergency" (name,estado,id_institution,location) VALUES ('accidente','true',7,ST_GeomFromText('POINT(-71.542333 -33.007453 )', 4326)),('fuego','true',9,ST_GeomFromText('POINT(-71.668571 -33.107569)', 4326)),('sequia','false',10,ST_GeomFromText('POINT(-70.706513 -33.459178)', 4326)),('asalto','true',6,ST_GeomFromText('POINT(-70.654899 -33.461845)', 4326)),('sequia','false',5,ST_GeomFromText('POINT(-70.592791 -33.417223)', 4326)),('apagon','true',6,ST_GeomFromText('POINT(-73.057520 -36.796341)', 4326)),('accidente','true',6,ST_GeomFromText('POINT(-72.481970 -36.747518)', 4326)),('asalto','false',5,ST_GeomFromText('POINT(-72.085232 -36.624896)', 4326)),('apagon','false',9,ST_GeomFromText('POINT(-73.140437 -40.582930)', 4326)),('tierra','false',1,ST_GeomFromText('POINT(-73.158517 -40.920832)', 4326));


INSERT INTO "voluntary" (name,disponibilidad,location,id_emergency) VALUES ('Thomás','true',ST_GeomFromText('POINT(-70.393197 -23.644550)', 4326),1),('Mia','false',ST_GeomFromText('POINT(-70.389790 -23.548849)', 4326),2),('Juanita','true',ST_GeomFromText('POINT(-70.306838 -23.768959)', 4326),3),('Antonieta','false',ST_GeomFromText('POINT(-70.267263 -27.415983)', 4326),1),('Salomé','true',ST_GeomFromText('POINT(-70.351222 -27.347839)', 4326),1),('Naiara','false',ST_GeomFromText('POINT(-71.246734 -29.916263)', 4326),2),('Jacobo','false',ST_GeomFromText('POINT(-70.997531 -29.990169)', 4326),3),('Jhon','true',ST_GeomFromText('POINT(-71.607359 -33.053205)', 4326),4),('Eduar','false',ST_GeomFromText('POINT(-71.362525 -33.049486)', 4326),5),('Mia','true',ST_GeomFromText('POINT(-71.518932 -32.926138)', 4326),6);
INSERT INTO "voluntary" (name,disponibilidad,location,id_emergency) VALUES ('Lilian','true',ST_GeomFromText('POINT(-71.542333 -33.007453)', 4326),4),('Agustina','false',ST_GeomFromText('POINT(-71.668571 -33.107569)', 4326),5),('Giselle','false',ST_GeomFromText('POINT(-70.706513 -33.459178)', 4326),6),('Jordan','true',ST_GeomFromText('POINT(-70.654899 -33.461845)', 4326),7),('Faloon','false',ST_GeomFromText('POINT(-70.592791 -33.417223)', 4326),8),('Aleli','false',ST_GeomFromText('POINT(-73.057520 -36.796341)', 4326),9),('Jeremías','true',ST_GeomFromText('POINT(-72.481970 -36.747518)', 4326),8),('Yostin','true',ST_GeomFromText('POINT(-72.085232 -36.624896)', 4326),10),('Branko','false',ST_GeomFromText('POINT(-73.140437 -40.582930)', 4326),11),('Agustin','true',ST_GeomFromText('POINT(-73.158517 -40.920832)', 4326),12);
INSERT INTO "voluntary" (name,disponibilidad,location,id_emergency) VALUES ('Yenifer','true',ST_GeomFromText('POINT(-73.227529 -40.640226)', 4326),11),('Macarena','true',ST_GeomFromText('POINT(-72.945190 -40.466447)', 4326),13),('Yohans','true',ST_GeomFromText('POINT(-73.147289 -40.491670)', 4326),14),('Cristian','false',ST_GeomFromText('POINT(-73.466805 -40.599455 )', 4326),15),('Dailyn','true',ST_GeomFromText('POINT(-70.863156 -33.611753 )', 4326),16),('Byron','true',ST_GeomFromText('POINT(-70.686388 -33.569167)', 4326),17),('Deivid','true',ST_GeomFromText('POINT(-70.583133 -33.544329)', 4326),18),('Cristóbal','true',ST_GeomFromText('POINT(-70.574796 -33.488574)', 4326),19),('Milan','false',ST_GeomFromText('POINT(-70.890942 -32.786998)', 4326),20),('Valentino','false',ST_GeomFromText('POINT(-71.126448 -29.935662)', 4326),20);

INSERT INTO "status_task" (status) VALUES ('true'), ('false');

INSERT INTO "ranking" (numRanking,id_voluntary) VALUES (82,1),(83,2),(52,3),(35,4),(81,5),(55,6),(45,7),(25,8),(42,9),(49,10);
INSERT INTO "ranking" (numRanking,id_voluntary) VALUES (67,11),(99,12),(35,13),(59,14),(80,15),(8,16),(46,17),(79,18),(23,19),(55,20);
INSERT INTO "ranking" (numRanking,id_voluntary) VALUES (21,21),(11,22),(88,23),(66,24),(37,25),(96,26),(83,27),(97,28),(38,29),(51,30);

INSERT INTO "task" (name,id_status_task,id_emergency) VALUES ('magnis dis parturient',1,3),('enim. Curabitur massa.',2,3),('rutrum urna, nec',2,19),('turpis. Nulla aliquet.',2,16),('placerat. Cras dictum',2,3),('arcu eu odio',2,2),('a neque. Nullam',1,19),('Sed pharetra, felis',2,4),('dignissim tempor arcu.',2,11),('augue. Sed molestie.',1,14);
INSERT INTO "task" (name,id_status_task,id_emergency) VALUES ('Nunc mauris sapien,',2,3),('dolor dapibus gravida.',2,13),('nunc nulla vulputate',2,8),('vulputate mauris sagittis',1,5),('tincidunt aliquam arcu.',1,10),('Aliquam nec enim.',1,9),('Nullam suscipit, est',1,19),('Curae; Phasellus ornare.',1,13),('Cum sociis natoque',2,11),('urna. Nullam lobortis',2,12);
INSERT INTO "task" (name,id_status_task,id_emergency) VALUES ('Sed nunc est,',1,3),('enim consequat purus.',2,14),('placerat, augue. Sed',2,17),('libero lacus, varius',2,9),('Praesent interdum ligula',2,20),('et pede. Nunc',2,8),('ad litora torquent',2,3),('diam vel arcu.',2,13),('Pellentesque ut ipsum',2,8),('mauris, rhoncus id,',1,19);
INSERT INTO "task" (name,id_status_task,id_emergency) VALUES ('Donec non justo.',1,10),('fringilla mi lacinia',1,18),('nec metus facilisis',2,10),('Suspendisse commodo tincidunt',2,17),('morbi tristique senectus',2,6),('Fusce mi lorem,',1,9),('Duis cursus, diam',2,4),('molestie. Sed id',1,9),('Duis risus odio,',1,2),('Integer aliquam adipiscing',2,5);

INSERT INTO "eme_skill" (id_emergency,id_skill) VALUES (1,1),(2,2),(4,6),(5,10),(14,4),(6,8),(18,1),(6,3),(11,4),(10,7);
INSERT INTO "eme_skill" (id_emergency,id_skill) VALUES (1,2),(2,4),(4,7),(17,1),(12,5),(8,9),(19,1),(7,3),(11,5),(10,8);
INSERT INTO "eme_skill" (id_emergency,id_skill) VALUES (1,3),(3,4),(13,8),(17,2),(12,6),(8,10),(6,2),(15,4),(9,5),(6,9);
INSERT INTO "eme_skill" (id_emergency,id_skill) VALUES (1,4),(3,5),(13,9),(17,3),(12,7),(8,1),(8,3),(15,4),(9,6),(7,10);


INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (1,1),(2,3),(3,19),(4,14),(6,12),(7,10),(8,6),(9,15),(10,19),(11,14);
INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (1,11),(2,4),(3,14),(4,15),(7,31),(7,20),(8,5),(9,16),(11,11),(11,15);
INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (1,21),(2,5),(4,12),(5,11),(7,32),(7,3),(8,4),(9,17),(11,12),(12,16);
INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (2,2),(3,20),(4,13),(5,4),(7,33),(7,1),(8,18),(10,18),(11,13),(12,20);

INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (13,21),(14,33),(15,2),(16,14),(18,12),(18,16),(20,6),(23,15),(23,40),(25,4);
INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (13,22),(14,34),(15,3),(17,9),(18,13),(18,18),(20,5),(23,16),(23,5),(25,6);
INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (14,31),(14,35),(15,4),(17,11),(18,14),(18,40),(21,4),(23,18),(24,8),(25,7);
INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (14,32),(15,1),(15,5),(17,4),(18,5),(19,1),(22,18),(23,14),(24,13),(25,2);

INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (26,1),(26,5),(27,11),(28,21),(29,29),(31,12),(32,6),(33,15),(34,6),(35,33);
INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (26,2),(26,10),(27,14),(28,22),(29,20),(32,9),(33,5),(33,3),(34,30),(35,34);
INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (26,3),(26,30),(27,12),(28,23),(30,5),(32,8),(33,4),(34,18),(35,31),(35,35);
INSERT INTO "task_skill" (id_task,id_eme_skill) VALUES (26,4),(26,21),(27,13),(28,24),(31,8),(32,1),(33,18),(34,14),(35,32),(35,36);

INSERT INTO "vol_skill" (id_voluntary,id_skill) VALUES (1,1),(1,5),(2,5),(4,1),(4,7),(5,7),(5,1),(8,4),(9,3),(10,10);
INSERT INTO "vol_skill" (id_voluntary,id_skill) VALUES (1,2),(1,6),(2,6),(4,2),(4,8),(5,8),(5,2),(8,3),(10,6),(10,1);
INSERT INTO "vol_skill" (id_voluntary,id_skill) VALUES (1,3),(2,1),(3,7),(4,3),(5,5),(5,9),(6,3),(8,2),(10,7),(10,2);
INSERT INTO "vol_skill" (id_voluntary,id_skill) VALUES (1,4),(2,2),(3,8),(4,4),(5,6),(5,10),(7,4),(9,2),(10,8),(10,3);

INSERT INTO "vol_skill" (id_voluntary,id_skill) VALUES (11,1),(13,6),(14,1),(16,1),(17,7),(19,1),(19,6),(21,4),(23,3),(25,2);
INSERT INTO "vol_skill" (id_voluntary,id_skill) VALUES (12,2),(13,7),(14,2),(16,4),(17,8),(19,2),(20,7),(22,3),(23,5),(25,4);
INSERT INTO "vol_skill" (id_voluntary,id_skill) VALUES (12,3),(13,8),(15,3),(16,5),(18,1),(19,3),(20,9),(23,1),(24,4),(25,6);
INSERT INTO "vol_skill" (id_voluntary,id_skill) VALUES (13,4),(13,9),(15,4),(16,6),(18,2),(19,5),(20,10),(23,2),(24,1),(25,8);

INSERT INTO "vol_skill" (id_voluntary,id_skill) VALUES (26,4),(26,1),(26,2),(26,5),(26,6),(26,7),(26,9),(26,10),(27,1),(27,3);
INSERT INTO "vol_skill" (id_voluntary,id_skill) VALUES (28,4),(28,1),(29,5),(29,3),(29,6),(30,3),(30,1),(30,2),(30,9),(30,7);

--Create User

CREATE USER dbusr_grupo2 WITH PASSWORD 'grupo2';

-- Grant connect to my data base

GRANT CONNECT ON DATABASE db_emergencias TO dbusr_grupo2;

-- Grant all table for SELECT, INSERT, UPDATE, DELETE

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO dbusr_grupo2;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO dbusr_grupo2;;
