-- Crear una secuencia
CREATE SEQUENCE partido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Crear la tabla con la secuencia aplicada al id
CREATE TABLE partido (
    id INT8 DEFAULT nextval('partido_seq') PRIMARY KEY, -- Usamos la secuencia para generar el id automáticamente
    id_equipo1 int8 NOT NULL,
    id_equipo2 int8 NOT NULL,
    fecha date NULL,
    gf_equipo1 int NULL,
    gf_equipo2 int NULL,
    CONSTRAINT fk_equipo1 FOREIGN KEY (id_equipo1) REFERENCES equipos(id) ON DELETE CASCADE,
    CONSTRAINT fk_equipo2 FOREIGN KEY (id_equipo2) REFERENCES equipos(id) ON DELETE CASCADE);
    

-- Crear un índice explícito en el campo id
CREATE INDEX partido_id_idx ON partido(id);