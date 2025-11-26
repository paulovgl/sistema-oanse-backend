-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

-- Club Population
 INSERT INTO clube (name) VALUES ('URSINHOS');
 INSERT INTO clube (name) VALUES ('FAISCA');
 INSERT INTO clube (name) VALUES ('FLAMA');
 INSERT INTO clube (name) VALUES ('TOCHA');
 INSERT INTO clube (name) VALUES ('JV');
 INSERT INTO clube (name) VALUES ('VQ7');

-- MANUAIS
-- INSERT INTO manual (id, nome, clube_id) VALUES (1, 'Manual Ursinhos', 1);
-- INSERT INTO manual (id, nome, clube_id) VALUES (2, 'Manual Faísca', 2);
-- INSERT INTO manual (id, nome, clube_id) VALUES (3, 'Manual Flama', 3);

-- SEÇÕES
-- INSERT INTO secao (id, titulo, talentos, manual_id) VALUES
-- (1, 'Deus é Criador', 1, 1),
-- (2, 'Jesus é meu amigo', 1, 1),
-- (3, 'Oração é falar com Deus', 2, 2),
-- (4, 'História de Moisés', 3, 3);
