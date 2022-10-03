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
    date     DATETIME not null default CURRENT_TIMESTAMP
)

drop table if exists calculator CASCADE;

create table calculator
(
    id      varchar(15),
    exportSum bigint,
    importSum bigint,
    date     DATETIME not null default CURRENT_TIMESTAMP
)
