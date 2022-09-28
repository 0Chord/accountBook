drop table if exists account CASCADE;

create table account
(
    id       varchar(15),
    password varchar(15),
    nickname     varchar(255),
    item     varchar(255),
    price    bigint,
    export_sum bigint,
    import_sum bigint,
    sum      bigint,
    date     DATETIME not null default CURRENT_TIMESTAMP,
    primary key (id)
);