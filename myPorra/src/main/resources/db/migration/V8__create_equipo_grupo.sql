-- Crear una secuencia
CREATE SEQUENCE equipo_grupo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Crear la tabla con la secuencia aplicada al id
CREATE TABLE equipo_grupo (
    id INT8 DEFAULT nextval('equipo_grupo_seq') PRIMARY KEY, -- Usamos la secuencia para generar el id automáticamente
    id_equipo int8 NOT NULL,
    id_grupo int8 NOT NULL,
    CONSTRAINT fk_equipogrupo1 FOREIGN KEY (id_equipo) REFERENCES equipos(id) ON DELETE CASCADE,
    CONSTRAINT fk_equipogrupo2 FOREIGN KEY (id_grupo) REFERENCES grupo(id) ON DELETE CASCADE
    );

-- Crear un índice explícito en el campo id
CREATE INDEX equipo_grupo_id_idx ON equipo_grupo(id);