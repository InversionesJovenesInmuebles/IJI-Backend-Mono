-- Crear secuencia para la tabla Cliente
CREATE SEQUENCE cliente_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Crear tabla Cliente
CREATE TABLE Cliente (
    id BIGINT DEFAULT nextval('cliente_sequence') PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    dni VARCHAR(8) NOT NULL,
    role VARCHAR(20) NOT NULL
);