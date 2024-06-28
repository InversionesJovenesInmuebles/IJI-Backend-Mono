-- Crear secuencia para la tabla Foto
CREATE SEQUENCE foto_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Crear tabla Foto
CREATE TABLE Foto (
    id_foto BIGINT DEFAULT nextval('foto_sequence') PRIMARY KEY,
    nombre_foto VARCHAR(255),
    idPropiedad BIGINT NOT NULL,
    FOREIGN KEY (idPropiedad) REFERENCES Propiedad(id_propiedad)
);