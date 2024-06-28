-- Crear secuencia
CREATE SEQUENCE inmobiliaria_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Crear tabla
CREATE TABLE Inmobiliaria (
    id_inmobiliaria BIGINT DEFAULT nextval('inmobiliaria_sequence') PRIMARY KEY,
    nombre_inmobiliaria VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono_contacto VARCHAR(20) NOT NULL,
    ruc VARCHAR(11) NOT NULL,
    role VARCHAR(20) NOT NULL
);
