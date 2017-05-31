-- begin ONETOONE_CUSTOMER
create table ONETOONE_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    EMAIL varchar(255),
    DETAILS_ID varchar(36),
    --
    primary key (ID)
)^
-- end ONETOONE_CUSTOMER
-- begin ONETOONE_CUSTOMER_DETAILS
create table ONETOONE_CUSTOMER_DETAILS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NOTES varchar(255),
    COMMENTS longvarchar,
    --
    primary key (ID)
)^
-- end ONETOONE_CUSTOMER_DETAILS
