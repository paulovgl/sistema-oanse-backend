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

-- Saturdays Population
 INSERT INTO SabadoReuniao (data, letivo, realizado) VALUES
('2025-01-04', true, false),
('2025-01-11', true, false),
('2025-01-18', true, false),
('2025-01-25', true, false),

('2025-02-01', true, false),
('2025-02-08', true, false),
('2025-02-15', true, false),
('2025-02-22', true, false),

('2025-03-01', true, false),
('2025-03-08', true, false),
('2025-03-15', true, false),
('2025-03-22', true, false),
('2025-03-29', true, false),

('2025-04-05', true, false),
('2025-04-12', true, false),
('2025-04-19', true, false),
('2025-04-26', true, false),

('2025-05-03', true, false),
('2025-05-10', true, false),
('2025-05-17', true, false),
('2025-05-24', true, false),
('2025-05-31', true, false),

('2025-06-07', true, false),
('2025-06-14', true, false),
('2025-06-21', true, false),
('2025-06-28', true, false),

('2025-07-05', true, false),
('2025-07-12', true, false),
('2025-07-19', true, false),
('2025-07-26', true, false),

('2025-08-02', true, false),
('2025-08-09', true, false),
('2025-08-16', true, false),
('2025-08-23', true, false),
('2025-08-30', true, false),

('2025-09-06', true, false),
('2025-09-13', true, false),
('2025-09-20', true, false),
('2025-09-27', true, false),

('2025-10-04', true, false),
('2025-10-11', true, false),
('2025-10-18', true, false),
('2025-10-25', true, false),

('2025-11-01', true, false),
('2025-11-08', true, false),
('2025-11-15', true, false),
('2025-11-22', true, false),
('2025-11-29', true, false),

('2025-12-06', true, false),
('2025-12-13', true, false),
('2025-12-20', true, false),
('2025-12-27', true, false);

INSERT INTO oansista (name, responsavel, dataNasc, contato, observacao)
VALUES ('Paulo Victor', 'Liduina', '2001-09-14', '85986713994', 'Nada');

INSERT INTO oansista (name, responsavel, dataNasc, contato, observacao)
VALUES ('Luis Dede', 'O pai', '2005-08-16', '85986713994', 'Nada');
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
