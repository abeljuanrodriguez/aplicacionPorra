-- Crear una secuencia
CREATE SEQUENCE equipos_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Crear la tabla con la secuencia aplicada al id
CREATE TABLE equipos (
    id INT8 DEFAULT nextval('equipos_seq') PRIMARY KEY, -- Usamos la secuencia para generar el id automáticamente
    nombre VARCHAR(255) NOT NULL,
    pais VARCHAR(255) NOT NULL,
    bandera_url VARCHAR(255) -- Enlace a la imagen de la bandera
);

-- Crear un índice explícito en el campo id
CREATE INDEX equipos_id_idx ON equipos (id);