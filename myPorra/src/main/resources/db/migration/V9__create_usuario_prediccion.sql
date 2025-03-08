-- Crear una secuencia
CREATE SEQUENCE usuario_prediccion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Crear la tabla con la secuencia aplicada al id
CREATE TABLE usuario_prediccion (
    id INT8 DEFAULT nextval('usuario_prediccion_seq') PRIMARY KEY, -- Usamos la secuencia para generar el id automáticamente
    id_usuario int8 NOT NULL,
    id_partido int8 NOT NULL,
    gfEquipo1 numeric NOT NULL,
    gfEquipo2 numeric NOT NULL,
    ganador varchar NOT NULL,
    CONSTRAINT fk_usuario_prediccion1 FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE,
    CONSTRAINT fk_usuario_prediccion2 FOREIGN KEY (id_partido) REFERENCES partido(id) ON DELETE CASCADE
    );

-- Crear un índice explícito en el campo id
CREATE INDEX usuario_prediccion_id_idx ON usuario_prediccion(id);