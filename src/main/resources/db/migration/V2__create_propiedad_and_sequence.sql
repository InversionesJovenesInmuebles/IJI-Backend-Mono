-- Crear secuencia para la tabla Propiedad
CREATE SEQUENCE propiedad_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Crear tabla Propiedad
CREATE TABLE Propiedad (
    id_propiedad BIGINT DEFAULT nextval('propiedad_sequence') PRIMARY KEY,
    latitud VARCHAR(255),
    longitud VARCHAR(255),
    pais VARCHAR(255),
    region VARCHAR(255),
    provincia VARCHAR(255),
    distrito VARCHAR(255),
    direccion VARCHAR(255),
    descripcion TEXT,
    otras_comodidades TEXT,
    tipo_propiedad VARCHAR(255),
    area_terreno DOUBLE PRECISION,
    costo_total DOUBLE PRECISION,
    costo_inicial DOUBLE PRECISION,
    cochera BOOLEAN,
    cant_banos INT,
    cant_dormitorios INT,
    cant_cochera INT
);