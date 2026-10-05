/*Creando la base de datos de receta*/
CREATE DATABASE IF NOT EXISTS receta;
USE receta;

/*Tabla tiporeceta*/
CREATE TABLE IF NOT EXISTS tiporeceta (
    IdTipoReceta INT AUTO_INCREMENT PRIMARY KEY,
    Descripcion VARCHAR(45) NOT NULL
);

/*Tabla receta*/
CREATE TABLE IF NOT EXISTS receta (
    IdReceta INT AUTO_INCREMENT PRIMARY KEY,
    NombrePaciente VARCHAR(45) NOT NULL,
    NombreMedicamento VARCHAR(45) NOT NULL,
    Dosis VARCHAR(30) NOT NULL,
    Frecuencia VARCHAR(45) NOT NULL,
    Duracion INT NOT NULL,
    FechaEmision DATE NOT NULL,
    Indicaciones VARCHAR(100) NOT NULL,
    IdTipoReceta INT NOT NULL,

    CONSTRAINT fk_receta_tiporeceta
    FOREIGN KEY (IdTipoReceta)
    REFERENCES tiporeceta(IdTipoReceta)
);

/*Aqui estan los datos que tendra tipo receta*/
INSERT INTO tiporeceta (Descripcion) 
VALUES('Analgesico'),('Antibiotico'),('Antiinflamatorio'),('Antialergico'),('Vitaminas');

/*Aqui esta los ejemplos*/

INSERT INTO receta (NombrePaciente, NombreMedicamento, Dosis, Frecuencia, Duracion, FechaEmision, Indicaciones, IdTipoReceta)
VALUES
('Ana Gómez', 'Paracetamol', '500 mg', 'Cada 8 horas', 5, '2026-10-04', 'Tomar después de los alimentos', 1),
('Luis Martínez', 'Amoxicilina', '875 mg', 'Cada 12 horas', 7, '2026-10-04', 'Completar el tratamiento antibiótico sin interrupciones', 2),
('Sofía Ramírez', 'Ibuprofeno', '400 mg', 'Cada 8 horas', 3, '2026-10-04', 'Tomar en caso de dolor o fiebre persistente', 1);
