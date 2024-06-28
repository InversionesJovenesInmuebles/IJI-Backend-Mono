-- Crear secuencia para la tabla Agente
CREATE SEQUENCE agente_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Crear tabla Agente
CREATE TABLE Agente (
    id BIGINT DEFAULT nextval('agente_sequence') PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    dni VARCHAR(8) NOT NULL,
    nombre_inmobiliaria VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL,
    id_inmobiliaria BIGINT,
    FOREIGN KEY (id_inmobiliaria) REFERENCES Inmobiliaria(id_inmobiliaria)
);
