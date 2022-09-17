
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

CREATE TABLE ingreso(
	id_ingreso int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    fecha DATETIME,
    ingreso_estudiante INT(30) NOT NULL,
	FOREIGN KEY(ingreso_estudiante) REFERENCES estudiantes_inscritos(id_estudiante),
    ingreso_visita INT(30) NOT NULL,
	FOREIGN KEY(ingreso_visita) REFERENCES visitas_guiadas(id_visitante)
);