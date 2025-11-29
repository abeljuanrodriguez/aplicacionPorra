TRUNCATE TABLE
    public.equipo_grupo,
    public.grupo,
    public.partido,
    public.torneo,
    public.usuario,
    public.usuario_prediccion
    RESTART IDENTITY CASCADE;

ALTER SEQUENCE equipo_grupo_seq RESTART WITH 1;
ALTER SEQUENCE grupo_seq RESTART WITH 1;
ALTER SEQUENCE partido_seq RESTART WITH 1;
ALTER SEQUENCE torneo_seq RESTART WITH 1;
ALTER SEQUENCE usuario_prediccion_seq RESTART WITH 1;
ALTER SEQUENCE usuario_seq RESTART WITH 1;