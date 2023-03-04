create table usuario
(
    id              serial primary key,
    nome            varchar(255) not null,
    data_nascimento timestamp    not null,
    cpf             varchar(25)  not null,
    nome_da_mae     varchar(255) not null,
    email           varchar(255) not null,
    senha           varchar(255) not null,
    cidade_id       bigint       not null,
    perfil_id       bigint       not null
);

ALTER TABLE usuario
    ADD CONSTRAINT fk_cidade FOREIGN KEY (cidade_id) REFERENCES cidade (id);

ALTER TABLE usuario
    ADD CONSTRAINT fk_perfil FOREIGN KEY (perfil_id) REFERENCES perfil (id);
