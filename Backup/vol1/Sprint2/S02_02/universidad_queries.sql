USE universidad;

-- Retorna un llistat amb el primer cognom, segon cognom i el nom de tots els/les alumnes. 
-- El llistat haurà d'estar ordenat alfabèticament de menor a major pel primer cognom, segon cognom i nom.
SELECT apellido1, apellido2, nombre FROM persona WHERE tipo = 'alumno' ORDER BY apellido1, apellido2, nombre ASC;
-- Esbrina el nom i els dos cognoms dels alumnes que no han donat d'alta el seu número de telèfon en la base de dades.
SELECT apellido1, apellido2, nombre FROM persona WHERE tipo = 'alumno' AND telefono IS NULL ORDER BY apellido1, apellido2, nombre ASC;
-- Retorna el llistat dels alumnes que van néixer en 1999.
SELECT apellido1, apellido2, nombre, fecha_nacimiento  FROM persona WHERE tipo = 'alumno' AND fecha_nacimiento LIKE '1999%' ORDER BY apellido1, apellido2, nombre ASC;
-- Retorna el llistat de professors/es que no han donat d'alta el seu número de telèfon en la base de dades i a més el seu NIF acaba en K.
SELECT apellido1, apellido2, nombre, nif, telefono  FROM persona WHERE tipo = 'profesor' AND telefono IS NULL AND UPPER(RIGHT(nif, 1)) = 'K' ORDER BY apellido1, apellido2, nombre ASC;
-- Retorna el llistat de les assignatures que s'imparteixen en el primer quadrimestre, en el tercer curs del grau que té l'identificador 7.
SELECT asignatura.nombre FROM asignatura WHERE asignatura.id_grado = 7 AND asignatura.curso = 3 AND asignatura.cuatrimestre = 1 ORDER BY asignatura.nombre ASC;
-- Retorna un llistat dels professors/es juntament amb el nom del departament al qual estan vinculats. 
-- El llistat ha de retornar quatre columnes, primer cognom, segon cognom, nom i nom del departament. 
-- El resultat estarà ordenat alfabèticament de menor a major pels cognoms i el nom.
SELECT persona.apellido1, persona.apellido2, persona.nombre, departamento.nombre AS departamento FROM persona JOIN profesor ON persona.id = profesor.id_profesor JOIN departamento ON profesor.id_departamento = departamento.id WHERE persona.tipo = 'profesor' ORDER BY persona.apellido1, persona.apellido2, persona.nombre;
-- Retorna un llistat amb el nom de les assignatures, any d'inici i any de fi del curs escolar de l'alumne/a amb NIF 26902806M.
SELECT asignatura.nombre AS asignatura, curso_escolar.anyo_inicio AS inicio, curso_escolar.anyo_fin AS fin FROM alumno_se_matricula_asignatura JOIN persona ON alumno_se_matricula_asignatura.id_alumno = persona.id JOIN asignatura ON alumno_se_matricula_asignatura.id_asignatura = asignatura.id JOIN curso_escolar ON alumno_se_matricula_asignatura.id_curso_escolar = curso_escolar.id WHERE persona.nif = '26902806M';
-- Retorna un llistat amb el nom de tots els departaments que tenen professors/es que imparteixen alguna assignatura en el Grau en Enginyeria Informàtica (Pla 2015).
SELECT DISTINCT grado.nombre AS grado, departamento.nombre AS departamento FROM departamento JOIN profesor ON departamento.id = profesor.id_departamento JOIN asignatura ON profesor.id_profesor = asignatura.id_profesor JOIN grado ON asignatura.id_grado = grado.id WHERE grado.nombre = 'Grado en Ingeniería Informática (Plan 2015)';
-- Retorna un llistat amb el nom de tots els departaments que tenen professors/es que imparteixen alguna assignatura en el Grau en Enginyeria Informàtica (Pla 2015). Ampliat.
SELECT grado.nombre AS grado, departamento.nombre AS departamento, asignatura.nombre AS asignatura, CONCAT(persona.nombre, ' ', persona.apellido1, ' ', persona.apellido2) AS enseñante FROM departamento JOIN profesor ON departamento.id = profesor.id_departamento JOIN persona ON profesor.id_profesor = persona.id JOIN asignatura ON profesor.id_profesor = asignatura.id_profesor JOIN grado ON asignatura.id_grado = grado.id WHERE grado.nombre = 'Grado en Ingeniería Informática (Plan 2015)';
-- Retorna un llistat amb tots els alumnes que s'han matriculat en alguna assignatura durant el curs escolar 2018/2019.
SELECT DISTINCT persona.id AS id, CONCAT(persona.nombre, ' ', persona.apellido1, ' ', persona.apellido2) AS estudiante, persona.nif FROM persona JOIN alumno_se_matricula_asignatura ON persona.id = alumno_se_matricula_asignatura.id_alumno JOIN curso_escolar ON alumno_se_matricula_asignatura.id_curso_escolar = curso_escolar.id WHERE curso_escolar.anyo_inicio = 2018 AND curso_escolar.anyo_fin = 2019 AND persona.tipo = 'alumno';

-- Retorna un llistat amb els noms de tots els professors/es i els departaments que tenen vinculats. 
-- El llistat també ha de mostrar aquells professors/es que no tenen cap departament associat. 
-- El llistat ha de retornar quatre columnes, nom del departament, primer cognom, segon cognom i nom del professor/a. 
-- El resultat estarà ordenat alfabèticament de menor a major pel nom del departament, cognoms i el nom.
SELECT departamento.nombre AS departamento , persona.apellido1 AS 'primer apellido', persona.apellido2 AS 'segundo apellido', persona.nombre AS nombre FROM persona LEFT JOIN profesor ON persona.id = profesor.id_profesor LEFT JOIN departamento ON profesor.id_departamento = departamento.id WHERE persona.tipo = 'profesor'  OR profesor.id_profesor IS NULL ORDER BY departamento.nombre ASC, persona.apellido1 ASC, persona.apellido2 ASC, persona.nombre ASC;
SELECT departamento.nombre AS departamento , persona.apellido1 AS 'primer apellido', persona.apellido2 AS 'segundo apellido', persona.nombre AS nombre FROM departamento RIGHT JOIN profesor ON departamento.id = profesor.id_departamento RIGHT JOIN persona ON profesor.id_profesor = persona.id WHERE persona.tipo = 'profesor'  OR profesor.id_profesor IS NULL ORDER BY departamento.nombre ASC, persona.apellido1 ASC, persona.apellido2 ASC, persona.nombre ASC;
-- Retorna un llistat amb els professors/es que no estan associats a un departament.
SELECT departamento.nombre AS departamento, CONCAT(persona.nombre, ' ', persona.apellido1, ' ', persona.apellido2) AS enseñante FROM persona LEFT JOIN profesor ON persona.id = profesor.id_profesor LEFT JOIN departamento ON profesor.id_departamento = departamento.id WHERE profesor.id_departamento IS NULL ORDER BY departamento.nombre ASC, persona.apellido1 ASC, persona.apellido2 ASC, persona.nombre ASC;
SELECT departamento.nombre AS departamento , persona.apellido1 AS 'primer apellido', persona.apellido2 AS 'segundo apellido', persona.nombre AS nombre FROM departamento RIGHT JOIN profesor ON departamento.id = profesor.id_departamento RIGHT JOIN persona ON profesor.id_profesor = persona.id WHERE profesor.id_profesor IS NULL ORDER BY departamento.nombre ASC, persona.apellido1 ASC, persona.apellido2 ASC, persona.nombre ASC;
-- Retorna un llistat amb els departaments que no tenen professors/es associats.
SELECT departamento.nombre AS departamento, profesor.id_departamento AS 'enseñante' FROM departamento LEFT JOIN profesor ON departamento.id = profesor.id_departamento WHERE profesor.id_departamento IS NULL ORDER BY departamento.nombre ASC;
SELECT departamento.nombre AS departamento, profesor.id_departamento AS 'enseñante' FROM profesor RIGHT JOIN departamento ON profesor.id_departamento = departamento.id WHERE profesor.id_departamento IS NULL ORDER BY departamento.nombre ASC;
-- Retorna un llistat amb els professors/es que no imparteixen cap assignatura.
SELECT persona.id, CONCAT(persona.nombre, ' ', persona.apellido1, ' ', persona.apellido2) AS enseñante, asignatura.id_profesor AS asignatura FROM persona JOIN profesor ON persona.id = profesor.id_profesor LEFT JOIN asignatura ON profesor.id_profesor = asignatura.id_profesor WHERE asignatura.id_profesor IS NULL ORDER BY persona.nombre, persona.apellido1, persona.apellido2 ASC;
SELECT persona.id, CONCAT(persona.nombre, ' ', persona.apellido1, ' ', persona.apellido2) AS enseñante, asignatura.id_profesor AS asignatura FROM asignatura RIGHT JOIN profesor ON asignatura.id_profesor = profesor.id_profesor RIGHT JOIN persona ON profesor.id_profesor = persona.id WHERE asignatura.id_profesor IS NULL AND persona.tipo = 'profesor' ORDER BY persona.nombre, persona.apellido1, persona.apellido2 ASC;
-- Retorna un llistat amb les assignatures que no tenen un professor/a assignat.
SELECT asignatura.id, asignatura.nombre AS asignatura, profesor.id_profesor AS 'enseñante' FROM asignatura LEFT JOIN profesor ON asignatura.id_profesor = profesor.id_profesor WHERE asignatura.id_profesor IS NULL ORDER BY asignatura.nombre ASC;
SELECT asignatura.id, asignatura.nombre AS asignatura, asignatura.id_profesor AS 'enseñante' FROM profesor RIGHT JOIN asignatura ON profesor.id_profesor = asignatura.id_profesor WHERE asignatura.id_profesor IS NULL ORDER BY asignatura.nombre ASC;
-- Retorna un llistat amb tots els departaments que no han impartit assignatures en cap curs escolar.
SELECT DISTINCT departamento.nombre AS departamento, asignatura.id AS asignatura, curso_escolar.anyo_inicio FROM departamento LEFT JOIN profesor ON departamento.id = profesor.id_departamento LEFT JOIN asignatura ON profesor.id_profesor = asignatura.id_profesor LEFT JOIN alumno_se_matricula_asignatura ON asignatura.id = alumno_se_matricula_asignatura.id_asignatura LEFT JOIN curso_escolar ON alumno_se_matricula_asignatura.id_curso_escolar = curso_escolar.id WHERE asignatura.id IS NULL ORDER BY departamento.nombre;
SELECT DISTINCT departamento.nombre AS departamento, asignatura.nombre AS asignatura, curso_escolar.anyo_inicio FROM curso_escolar RIGHT JOIN alumno_se_matricula_asignatura ON curso_escolar.id = alumno_se_matricula_asignatura.id_curso_escolar RIGHT JOIN asignatura ON alumno_se_matricula_asignatura.id_asignatura = asignatura.id RIGHT JOIN profesor ON asignatura.id_profesor = profesor.id_profesor RIGHT JOIN departamento ON profesor.id_departamento = departamento.id WHERE asignatura.id IS NULL ORDER BY departamento.nombre;

-- Retorna el nombre total d'alumnes que hi ha.
SELECT COUNT(*) AS 'estudiantes nacidos en 1999' FROM persona WHERE tipo = 'alumno';
-- Calcula quants alumnes van néixer en 1999.
SELECT COUNT(*) AS 'estudiantes nacidos en 1999' FROM persona WHERE tipo = 'alumno' AND YEAR(fecha_nacimiento) = 1999;
-- Calcula quants professors/es hi ha en cada departament. 
-- El resultat només ha de mostrar dues columnes, una amb el nom del departament i una altra amb el nombre de professors/es que hi ha en aquest departament. 
-- El resultat només ha d'incloure els departaments que tenen professors/es associats i haurà d'estar ordenat de major a menor pel nombre de professors/es.
SELECT departamento.nombre AS departamento, COUNT(profesor.id_profesor) AS enseñantes FROM departamento JOIN profesor ON departamento.id = profesor.id_departamento GROUP BY departamento.nombre ORDER BY enseñantes DESC;
-- Retorna un llistat amb tots els departaments i el nombre de professors/es que hi ha en cadascun d'ells. 
-- Tingui en compte que poden existir departaments que no tenen professors/es associats. 
-- Aquests departaments també han d'aparèixer en el llistat. 
SELECT departamento.nombre AS nombre_departamento, COUNT(profesor.id_profesor) AS cantidad_profesores FROM departamento LEFT JOIN profesor ON departamento.id = profesor.id_departamento GROUP BY departamento.nombre ORDER BY cantidad_profesores DESC;
-- Retorna un llistat amb el nom de tots els graus existents en la base de dades i el nombre d'assignatures que té cadascun. 
-- Tingues en compte que poden existir graus que no tenen assignatures associades. 
-- Aquests graus també han d'aparèixer en el llistat. El resultat haurà d'estar ordenat de major a menor pel nombre d'assignatures.
SELECT grado.nombre AS nombre_grado, COUNT(asignatura.id) AS cantidad_asignaturas FROM grado LEFT JOIN asignatura ON grado.id = asignatura.id_grado GROUP BY grado.nombre ORDER BY cantidad_asignaturas DESC;
-- Retorna un llistat amb el nom de tots els graus existents en la base de dades i el nombre d'assignatures que té cadascun, dels graus que tinguin més de 40 assignatures associades.
SELECT grado.nombre AS nombre_grado, COUNT(asignatura.id) AS cantidad_asignaturas FROM grado JOIN asignatura ON grado.id = asignatura.id_grado GROUP BY grado.nombre HAVING COUNT(asignatura.id) > 40 ORDER BY cantidad_asignaturas DESC;
-- Retorna un llistat que mostri el nom dels graus i la suma del nombre total de crèdits que hi ha per a cada tipus d'assignatura. 
-- El resultat ha de tenir tres columnes: nom del grau, tipus d'assignatura i la suma dels crèdits de totes les assignatures que hi ha d'aquest tipus.
SELECT grado.nombre AS nombre_grado, asignatura.tipo AS tipo_asignatura, SUM(asignatura.creditos) AS suma_creditos FROM grado JOIN asignatura ON grado.id = asignatura.id_grado GROUP BY grado.nombre, asignatura.tipo ORDER BY nombre_grado, tipo_asignatura;
-- Retorna un llistat que mostri quants alumnes s'han matriculat d'alguna assignatura en cadascun dels cursos escolars. 
-- El resultat haurà de mostrar dues columnes, una columna amb l'any d'inici del curs escolar i una altra amb el nombre d'alumnes matriculats.
SELECT curso_escolar.anyo_inicio AS 'inicio curso', COUNT(alumno_se_matricula_asignatura.id_alumno) AS 'estudiantes matriculados' FROM curso_escolar LEFT JOIN alumno_se_matricula_asignatura ON curso_escolar.id = alumno_se_matricula_asignatura.id_curso_escolar GROUP BY curso_escolar.anyo_inicio ORDER BY 'inicio curso';
-- Retorna un llistat amb el nombre d'assignatures que imparteix cada professor/a. 
-- El llistat ha de tenir en compte aquells professors/es que no imparteixen cap assignatura. 
-- El resultat mostrarà cinc columnes: id, nom, primer cognom, segon cognom i nombre d'assignatures. 
-- El resultat estarà ordenat de major a menor pel nombre d'assignatures.
SELECT persona.id AS id, CONCAT(persona.nombre, ' ', persona.apellido1, ' ', persona.apellido2) AS enseñante, COUNT(asignatura.id) AS nombre_assignatures FROM persona LEFT JOIN profesor ON persona.id = profesor.id_profesor LEFT JOIN asignatura ON profesor.id_profesor = asignatura.id_profesor WHERE persona.tipo = 'profesor' GROUP BY persona.id, persona.nombre, persona.apellido1, persona.apellido2 ORDER BY nombre_assignatures DESC;
-- Retorna totes les dades de l'alumne/a més jove.
SELECT * FROM persona WHERE id >= 1 AND nombre IS NOT NULL AND nombre != '' AND fecha_nacimiento = (SELECT MIN(fecha_nacimiento) FROM persona WHERE tipo = 'alumno') LIMIT 1; -- sale una fila de NULL, que no logro filtrar.
-- Retorna un llistat amb els professors/es que tenen un departament associat i que no imparteixen cap assignatura.
SELECT profesor.id_profesor AS id, CONCAT(persona.nombre, ' ', persona.apellido1, ' ', persona.apellido2) AS enseñante, departamento.nombre AS departamento, asignatura.id AS asignatura FROM persona JOIN profesor ON persona.id = profesor.id_profesor LEFT JOIN asignatura ON profesor.id_profesor = asignatura.id_profesor JOIN departamento ON profesor.id_departamento = departamento.id WHERE profesor.id_departamento IS NOT NULL AND asignatura.id IS NULL ORDER BY departamento.nombre;