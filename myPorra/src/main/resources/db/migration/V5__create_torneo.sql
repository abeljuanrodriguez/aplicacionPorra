-- Crear una secuencia
CREATE SEQUENCE torneo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Crear la tabla con la secuencia aplicada al id
CREATE TABLE torneo (
    id INT8 DEFAULT nextval('torneo_seq') PRIMARY KEY, -- Usamos la secuencia para generar el id automáticamente
    nombre VARCHAR(255) NOT NULL);

-- Crear un índice explícito en el campo id
CREATE INDEX torneo_id_idx ON torneo (id);