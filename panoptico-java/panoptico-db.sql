
-- LA BASE DE DATOS YA HA SIDO HOSTEADA EN LA NUBE
-- PRUEBAS REALIZADAS EN POSTMAN CON LOCALHOST:8080

--MYSQL_ADDON_HOST=blamyq32slzamzmbtsev-mysql.services.clever-cloud.com
--MYSQL_ADDON_DB=blamyq32slzamzmbtsev
--MYSQL_ADDON_USER=uu6nxlbqcka5x1jo
--MYSQL_ADDON_PORT=3306
--MYSQL_ADDON_PASSWORD=vVUtHVKuIATlQ0NABdm2
--MYSQL_ADDON_URI=mysql://uu6nxlbqcka5x1jo:vVUtHVKuIATlQ0NABdm2@blamyq32slzamzmbtsev-mysql.services.clever-cloud.com:3306/blamyq32slzamzmbtsev

CREATE TABLE estudiantes_inscritos(
	id_estudiante int PRIMARY KEY AUTO_INCREMENT NOT NULL, 
	cedula VARCHAR(30) NOT NULL,
    nombre VARCHAR(30) NOT NULL, 
	telefono VARCHAR(60) NOT NULL, 
	email VARCHAR(100) NOT NULL
);

CREATE TABLE visitas_guiadas(
	id_visitante int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    cedula VARCHAR(30) NOT NULL,
    nombre VARCHAR(30) NOT NULL, 
	telefono VARCHAR(60) NOT NULL, 
	email VARCHAR(100) NOT NULL
);

CREATE UNIQUE INDEX estudiantes_inscritos_cedula_uniq ON estudiantes_inscritos(cedula);
CREATE UNIQUE INDEX visitas_guiadas_cedula_uniq ON visitas_guiadas(cedula);

CREATE TABLE ingreso(
	id_ingreso int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    fecha Varchar(100),
    ingreso_estudiante varchar(30) default null,
    ingreso_visita varchar(30) default null,
	FOREIGN KEY(ingreso_estudiante) REFERENCES estudiantes_inscritos(cedula),
	FOREIGN KEY(ingreso_visita) REFERENCES visitas_guiadas(cedula)
);
