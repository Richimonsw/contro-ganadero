INSERT INTO TBL_CUIDADOR(id, apellido, cedula, email, nombre, telefono) VALUES (1, 'Montufar', '1726953969', 'rmontufar@gmail.com', 'Ricardo', '0983272454');
INSERT INTO TBL_CUIDADOR(id, apellido, cedula, email, nombre, telefono) VALUES (2, 'Tapia', '1726953974', 'ftapia@gmail.com', 'Fabricio', '0983272445');
INSERT INTO TBL_CUIDADOR(id, apellido, cedula, email, nombre, telefono) VALUES (3, 'Parreño', '1726953958', 'kparreno@gmail.com', 'kelly', '0983272487');
INSERT INTO TBL_CUIDADOR(id, apellido, cedula, email, nombre, telefono) VALUES (4, 'Montufar', '1726953945', 'cmontufar@gmail.com', 'Cristina', '0983272474');
INSERT INTO TBL_CUIDADOR(id, apellido, cedula, email, nombre, telefono) VALUES (5, 'Cajamarce', '1726953957', 'mcajamarca@gmail.com', 'Mateo', '0983272465');


INSERT INTO TBL_ANIMALES(id, fecha_nacimiento, nombre, propocito, raza, cuidador_id) VALUES (1, '17/07/2022', 'Lolas', 'Produccion', 'Holsin', '1');
INSERT INTO TBL_ANIMALES(id, fecha_nacimiento, nombre, propocito, raza, cuidador_id) VALUES (2, '18/07/2022', 'Maxi', 'Produccion', 'Brahman', '2');
INSERT INTO TBL_ANIMALES(id, fecha_nacimiento, nombre, propocito, raza, cuidador_id) VALUES (3, '19/07/2022', 'pepe', 'Produccion', 'Beefmaster', '3');
INSERT INTO TBL_ANIMALES(id, fecha_nacimiento, nombre, propocito, raza, cuidador_id) VALUES (4, '20/07/2022', 'Lucera', 'Produccion', 'Charolais', '4');
INSERT INTO TBL_ANIMALES(id, fecha_nacimiento, nombre, propocito, raza, cuidador_id) VALUES (5, '21/07/2022', 'Romera', 'Produccion', 'Simmental', '5');

INSERT INTO TBL_CHEQUEO(id, fecha_chequeo, observaciones, animal_id) VALUES (1, '21/07/2022', 'Necesita Vacuna', '1');
INSERT INTO TBL_CHEQUEO(id, fecha_chequeo, observaciones, animal_id) VALUES (2, '22/07/2022', 'Ninguna', '2');
INSERT INTO TBL_CHEQUEO(id, fecha_chequeo, observaciones, animal_id) VALUES (3, '23/07/2022', 'Necesita Vacuna', '3');
INSERT INTO TBL_CHEQUEO(id, fecha_chequeo, observaciones, animal_id) VALUES (4, '24/07/2022', 'Ninguna', '4');
INSERT INTO TBL_CHEQUEO(id, fecha_chequeo, observaciones, animal_id) VALUES (5, '25/07/2022', 'Ninguna', '5');

INSERT INTO TBL_USERS(ID, NAMES, PASSWORDS, ENABLEDS) VALUES (1, 'Ricardo', '$2a$10$sBXalkjkcM84e.OoZoJoO.EUXO7WVr9oQQc.2cXExiiKoMFqq.YVW', 1);

INSERT INTO TBL_ROLES(ID, ROLES, USER_ID) VALUES (1, 'ROLE_ADMIN', 1); /*M_G-CUIDADOR*/
INSERT INTO TBL_ROLES(ID, ROLES, USER_ID) VALUES (2, 'ROLE_VISITANTE', 1);  

