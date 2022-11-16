drop table if exists member CASCADE;

create table member
(
    id varchar(255),
    password varchar(255),
    nickname     varchar(255),
    name varchar(255),
    phone varchar(255)
);

drop table if exists account CASCADE;

create table account
(
    division_id bigint generated by default as identity,
    username      varchar(255),
    item     varchar(255),
    type    varchar(255),
    price    bigint,
    date     DATETIME not null default CURRENT_TIMESTAMP
)

drop table if exists calculator CASCADE;

create table calculator
(
    division_id bigint generated by default as identity,
    username    varchar(255),
    export_sum bigint,
    import_sum bigint,
    date     DATETIME not null default CURRENT_TIMESTAMP
)

drop table if exists board CASCADE;

create table board
(
    order_id       bigint generated by default as identity,
    nickname     varchar(255),
    title    varchar(255),
    content  varchar(1000),
    password varchar(1000),
    checked  boolean,
    count_visit bigint,
    date     DATETIME not null default CURRENT_TIMESTAMP
);

drop table if exists comment CASCADE;

create table comment
(
    comment_key     bigint generated by default as identity,
    order_id bigint,
    nickname varchar(255),
    board_comment varchar(255),
    comment_password varchar(255),
    checked boolean,
    date     DATETIME not null default CURRENT_TIMESTAMP
)

drop table if exists mbti_form CASCADE;

create table mbti_form
(
    division_id bigint generated by default as identity,
    username      varchar(255),
    result         varchar(10)
)

drop table if exists location CASCADE;

create table location
(
    id     bigint generated by default as identity,
    place_name varchar(30),
    place_url varchar(255),
    road_address_name varchar(255),
    x varchar(255),
    y varchar(255),
    date     DATETIME not null default CURRENT_TIMESTAMP
)
