-- Crear una secuencia
CREATE SEQUENCE usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Crear la tabla con la secuencia aplicada al id
CREATE TABLE usuario (
    id INT8 DEFAULT nextval('usuario_seq') PRIMARY KEY, -- Usamos la secuencia para generar el id automáticamente
    nombre VARCHAR(255) NOT NULL,
    alias VARCHAR(255) NOT NULL,
    puntuacion numeric,
    correo VARCHAR(150) NOT NULL
);

-- Crear un índice explícito en el campo id
CREATE INDEX usuario_id_idx ON usuario (id);