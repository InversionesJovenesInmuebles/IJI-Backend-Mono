-- Crear tabla Casa como subclase de Propiedad
CREATE TABLE Casa (
    id_propiedad BIGINT PRIMARY KEY,
    cant_pisos INT,
    area_jardin INT,
    jardin BOOLEAN,
    atico BOOLEAN,
    sotano BOOLEAN,
    FOREIGN KEY (id_propiedad) REFERENCES Propiedad(id_propiedad)
);