
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
    ingreso_estudiante INT not null,
    ingreso_visita INT not null,
	FOREIGN KEY(ingreso_estudiante) REFERENCES estudiantes_inscritos(id_estudiante),
	FOREIGN KEY(ingreso_visita) REFERENCES visitas_guiadas(id_visitante)
);