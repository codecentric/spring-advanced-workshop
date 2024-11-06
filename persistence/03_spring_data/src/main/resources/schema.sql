drop table if exists FARMERS;

create table FARMERS (
    ID bigint not null,
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    primary key (ID)
);