drop table if exists FARMERS;

create table FARMERS (
    FARMER_ID bigint not null,
    FARMER_FIRSTNAME varchar(255),
    FARMER_LASTNAME varchar(255),
    primary key (FARMER_ID)
);