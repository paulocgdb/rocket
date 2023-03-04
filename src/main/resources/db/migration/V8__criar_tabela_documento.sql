create table documento
(
    id                serial primary key,
    nome              varchar(255) not null,
    data_criacao      timestamp    not null,
    conteudo          bytea        not null,
    usuario_id        bigint       not null,
    tipo_documento_id bigint       not null
);

ALTER TABLE documento
    ADD CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id);

ALTER TABLE documento
    ADD CONSTRAINT fk_tipo_documento FOREIGN KEY (tipo_documento_id) REFERENCES tipo_documento (id);
