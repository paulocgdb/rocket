create table candidatura
(
    id           serial primary key,
    data_criacao timestamp not null,
    status_id    bigint    not null,
    usuario_id   bigint    not null
);

ALTER TABLE candidatura
    ADD CONSTRAINT fk_status FOREIGN KEY (status_id) REFERENCES status (id);

ALTER TABLE candidatura
    ADD CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id);
