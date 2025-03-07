-- Crear una secuencia
CREATE SEQUENCE grupo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Crear la tabla con la secuencia aplicada al id
CREATE TABLE grupo (
    id INT8 DEFAULT nextval('grupo_seq') PRIMARY KEY, -- Usamos la secuencia para generar el id automáticamente
    nombre varchar NOT NULL);

-- Crear un índice explícito en el campo id
CREATE INDEX grupo_id_idx ON grupo(id);