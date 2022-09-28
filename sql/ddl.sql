drop table if exists member CASCADE;

create table member
(
    id       varchar(15),
    password varchar(15),
    nickname     varchar(255),
    primary key (id)
);

drop table if exists account CASCADE;

create table account
(
    id      varchar(15),
    item     varchar(255),
    price    bigint,
    export_sum bigint,
    import_sum bigint,
    sum      bigint,
    date     DATETIME not null default CURRENT_TIMESTAMP,
    primary key(id)
)
