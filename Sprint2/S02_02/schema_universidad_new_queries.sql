USE universidad;

SELECT apellido1, apellido2, nombre FROM persona WHERE tipo = 'alumno' ORDER BY apellido1, apellido2, nombre ASC;

SELECT apellido1, apellido2, nombre FROM persona WHERE tipo = 'alumno' AND telefono IS NULL ORDER BY apellido1, apellido2, nombre ASC;

SELECT apellido1, apellido2, nombre, fecha_nacimiento  FROM persona WHERE tipo = 'alumno' AND fecha_nacimiento LIKE '1999%' ORDER BY apellido1, apellido2, nombre ASC;

SELECT asignatura.nombre FROM asignatura WHERE asignatura.id_grado = 7 AND asignatura.curso = 3 AND asignatura.cuatrimestre = 1 ORDER BY asignatura.nombre ASC;

SELECT persona.apellido1, persona.apellido2, persona.nombre, departamento.nombre AS department FROM persona JOIN profesor ON persona.id = profesor.id_profesor JOIN departamento ON profesor.id_departamento = departamento.id WHERE persona.tipo = 'profesor' ORDER BY persona.apellido1, persona.apellido2, persona.nombre;

SELECT asignatura.nombre AS subject, curso_escolar.anyo_inicio AS start, curso_escolar.anyo_fin AS end FROM alumno_se_matricula_asignatura JOIN persona ON alumno_se_matricula_asignatura.id_alumno = persona.id JOIN asignatura ON alumno_se_matricula_asignatura.id_asignatura = asignatura.id JOIN curso_escolar ON alumno_se_matricula_asignatura.id_curso_escolar = curso_escolar.id WHERE persona.nif = '26902806M';

SELECT DISTINCT grado.nombre AS degree, departamento.nombre AS department FROM departamento JOIN profesor ON departamento.id = profesor.id_departamento JOIN asignatura ON profesor.id_profesor = asignatura.id_profesor JOIN grado ON asignatura.id_grado = grado.id WHERE grado.nombre = 'Grado en Ingeniería Informática (Plan 2015)';

SELECT grado.nombre AS degree, departamento.nombre AS department, asignatura.nombre AS subject, CONCAT(persona.nombre, ' ', persona.apellido1, ' ', persona.apellido2) AS instructor FROM departamento JOIN profesor ON departamento.id = profesor.id_departamento JOIN persona ON profesor.id_profesor = persona.id JOIN asignatura ON profesor.id_profesor = asignatura.id_profesor JOIN grado ON asignatura.id_grado = grado.id WHERE grado.nombre = 'Grado en Ingeniería Informática (Plan 2015)';

SELECT DISTINCT persona.id AS id, CONCAT(persona.nombre, ' ', persona.apellido1, ' ', persona.apellido2) AS student, persona.nif FROM persona JOIN alumno_se_matricula_asignatura ON persona.id = alumno_se_matricula_asignatura.id_alumno JOIN curso_escolar ON alumno_se_matricula_asignatura.id_curso_escolar = curso_escolar.id WHERE curso_escolar.anyo_inicio = 2018 AND curso_escolar.anyo_fin = 2019 AND persona.tipo = 'alumno';

SELECT departamento.nombre AS department , persona.apellido1 AS 'first surname', persona.apellido2 AS 'second surname', persona.nombre AS name FROM persona LEFT JOIN profesor ON persona.id = profesor.id_profesor LEFT JOIN departamento ON profesor.id_departamento = departamento.id WHERE persona.tipo = 'profesor'  OR profesor.id_profesor IS NULL ORDER BY departamento.nombre ASC, persona.apellido1 ASC, persona.apellido2 ASC, persona.nombre ASC;

SELECT departamento.nombre AS department , persona.apellido1 AS 'first surname', persona.apellido2 AS 'second surname', persona.nombre AS name FROM departamento RIGHT JOIN profesor ON departamento.id = profesor.id_departamento RIGHT JOIN persona ON profesor.id_profesor = persona.id WHERE persona.tipo = 'profesor'  OR profesor.id_profesor IS NULL ORDER BY departamento.nombre ASC, persona.apellido1 ASC, persona.apellido2 ASC, persona.nombre ASC;

SELECT departamento.nombre AS department, CONCAT(persona.nombre, ' ', persona.apellido1, ' ', persona.apellido2) AS instructor FROM persona LEFT JOIN profesor ON persona.id = profesor.id_profesor LEFT JOIN departamento ON profesor.id_departamento = departamento.id WHERE profesor.id_departamento IS NULL ORDER BY departamento.nombre ASC, persona.apellido1 ASC, persona.apellido2 ASC, persona.nombre ASC;

SELECT departamento.nombre AS department , persona.apellido1 AS 'first surname', persona.apellido2 AS 'second surname', persona.nombre AS name FROM departamento RIGHT JOIN profesor ON departamento.id = profesor.id_departamento RIGHT JOIN persona ON profesor.id_profesor = persona.id WHERE profesor.id_profesor IS NULL ORDER BY departamento.nombre ASC, persona.apellido1 ASC, persona.apellido2 ASC, persona.nombre ASC;

SELECT departamento.nombre AS department, profesor.id_departamento AS 'instructor' FROM departamento LEFT JOIN profesor ON departamento.id = profesor.id_departamento WHERE profesor.id_departamento IS NULL ORDER BY departamento.nombre ASC;

SELECT departamento.nombre AS department, profesor.id_departamento AS 'instructor' FROM profesor RIGHT JOIN departamento ON profesor.id_departamento = departamento.id WHERE profesor.id_departamento IS NULL ORDER BY departamento.nombre ASC;

SELECT persona.id, CONCAT(persona.nombre, ' ', persona.apellido1, ' ', persona.apellido2) AS instructor, asignatura.id_profesor AS subject FROM persona JOIN profesor ON persona.id = profesor.id_profesor LEFT JOIN asignatura ON profesor.id_profesor = asignatura.id_profesor WHERE asignatura.id_profesor IS NULL ORDER BY persona.nombre, persona.apellido1, persona.apellido2 ASC;

SELECT persona.id, CONCAT(persona.nombre, ' ', persona.apellido1, ' ', persona.apellido2) AS instructor, asignatura.id_profesor AS subject FROM asignatura RIGHT JOIN profesor ON asignatura.id_profesor = profesor.id_profesor RIGHT JOIN persona ON profesor.id_profesor = persona.id WHERE asignatura.id_profesor IS NULL AND persona.tipo = 'profesor' ORDER BY persona.nombre, persona.apellido1, persona.apellido2 ASC;

SELECT asignatura.id, asignatura.nombre AS subject, profesor.id_profesor AS 'instructor' FROM asignatura LEFT JOIN profesor ON asignatura.id_profesor = profesor.id_profesor WHERE asignatura.id_profesor IS NULL ORDER BY asignatura.nombre ASC;

SELECT asignatura.id, asignatura.nombre AS subject, asignatura.id_profesor AS 'instructor' FROM profesor RIGHT JOIN asignatura ON profesor.id_profesor = asignatura.id_profesor WHERE asignatura.id_profesor IS NULL ORDER BY asignatura.nombre ASC;

SELECT DISTINCT departamento.nombre AS department, asignatura.id AS subject, curso_escolar.anyo_inicio FROM departamento LEFT JOIN profesor ON departamento.id = profesor.id_departamento LEFT JOIN asignatura ON profesor.id_profesor = asignatura.id_profesor LEFT JOIN alumno_se_matricula_asignatura ON asignatura.id = alumno_se_matricula_asignatura.id_asignatura LEFT JOIN curso_escolar ON alumno_se_matricula_asignatura.id_curso_escolar = curso_escolar.id WHERE asignatura.id IS NULL ORDER BY departamento.nombre;

SELECT COUNT(*) AS 'students born in 1999' FROM persona WHERE tipo = 'alumno';

SELECT COUNT(*) AS 'students born in 1999' FROM persona WHERE tipo = 'alumno' AND YEAR(fecha_nacimiento) = 1999;

SELECT departamento.nombre AS department, COUNT(profesor.id_profesor) AS instructors FROM departamento JOIN profesor ON departamento.id = profesor.id_departamento GROUP BY departamento.nombre ORDER BY instructors DESC;

SELECT departamento.nombre AS department_name, COUNT(profesor.id_profesor) AS number_of_professors FROM departamento LEFT JOIN profesor ON departamento.id = profesor.id_departamento GROUP BY departamento.nombre ORDER BY number_of_professors DESC;

SELECT grado.nombre AS degree_name, COUNT(asignatura.id) AS number_of_subjects FROM grado LEFT JOIN asignatura ON grado.id = asignatura.id_grado GROUP BY grado.nombre ORDER BY number_of_subjects DESC;

SELECT grado.nombre AS degree_name, COUNT(asignatura.id) AS number_of_subjects FROM grado JOIN asignatura ON grado.id = asignatura.id_grado GROUP BY grado.nombre HAVING COUNT(asignatura.id) > 40 ORDER BY number_of_subjects DESC;

SELECT grado.nombre AS degree_name, asignatura.tipo AS subject_type, SUM(asignatura.creditos) AS total_credits FROM grado JOIN asignatura ON grado.id = asignatura.id_grado GROUP BY grado.nombre, asignatura.tipo ORDER BY degree_name, subject_type;

SELECT curso_escolar.anyo_inicio AS 'course start', COUNT(alumno_se_matricula_asignatura.id_alumno) AS 'enrolled students' FROM curso_escolar LEFT JOIN alumno_se_matricula_asignatura ON curso_escolar.id = alumno_se_matricula_asignatura.id_curso_escolar GROUP BY curso_escolar.anyo_inicio ORDER BY 'course start';

SELECT persona.id AS id, CONCAT(persona.nombre, ' ', persona.apellido1, ' ', persona.apellido2) AS instructor, COUNT(asignatura.id) AS number_of_subjects FROM persona LEFT JOIN profesor ON persona.id = profesor.id_profesor LEFT JOIN asignatura ON profesor.id_profesor = asignatura.id_profesor WHERE persona.tipo = 'profesor' GROUP BY persona.id, persona.nombre, persona.apellido1, persona.apellido2 ORDER BY number_of_subjects DESC;

SELECT * FROM persona WHERE id >= 1 AND nombre IS NOT NULL AND nombre != '' AND fecha_nacimiento = (SELECT MIN(fecha_nacimiento) FROM persona WHERE tipo = 'alumno') LIMIT 1; -- returns a NULL row I cannot filter.

SELECT profesor.id_profesor AS id, CONCAT(persona.nombre, ' ', persona.apellido1, ' ', persona.apellido2) AS instructor, departamento.nombre AS department, asignatura.id AS subject FROM persona JOIN profesor ON persona.id = profesor.id_profesor LEFT JOIN asignatura ON profesor.id_profesor = asignatura.id_profesor JOIN departamento ON profesor.id_departamento = departamento.id WHERE profesor.id_departamento IS NOT NULL AND asignatura.id IS NULL ORDER BY departamento.nombre;
