ALTER TABLE public.grupo
    ADD COLUMN id_torneo BIGINT;

ALTER TABLE public.grupo
    ADD CONSTRAINT fk_grupo_torneo
        FOREIGN KEY (id_torneo)
            REFERENCES public.torneo(id);

ALTER TABLE public.usuario
    ADD COLUMN id_torneo BIGINT;

ALTER TABLE public.usuario
    ADD CONSTRAINT fk_usuario_torneo
        FOREIGN KEY (id_torneo)
            REFERENCES public.torneo(id);