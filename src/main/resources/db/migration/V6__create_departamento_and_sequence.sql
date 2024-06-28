-- Crear tabla Departamento como subclase de Propiedad
CREATE TABLE Departamento (
    id_propiedad BIGINT PRIMARY KEY,
    pisos INT,
    interior INT,
    ascensor BOOLEAN,
    areas_comunes BOOLEAN,
    areas_comunes_especificas TEXT,
    FOREIGN KEY (id_propiedad) REFERENCES Propiedad(id_propiedad)
);