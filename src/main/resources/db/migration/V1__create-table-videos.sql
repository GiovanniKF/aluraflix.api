create table videos (

    id serial primary key not null,
    titulo varchar(120) not null,
    descricao varchar(255)  not null,
    url varchar(255) not null unique

)