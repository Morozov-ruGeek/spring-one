BEGIN;

DROP TABLE IF EXISTS students_info CASCADE;
CREATE TABLE students_info (id bigserial PRIMARY KEY, name VARCHAR(255), score int);
INSERT INTO students_info (name, score) VALUES
('Alex', 80),
('Bergen', 90),
('Damian', 75),
('Irvin', 70),
('Karl', 90),
('Jon', 100);

COMMIT;