create table locations (
    id bigint not null,
    created_date timestamp(6),
    deleted_date timestamp(6),
    is_deleted boolean,
    modified_date timestamp(6),
    secure_id varchar(36),
    version integer,
    admin1 varchar(255),
    admin2 varchar(255),
    admin3 varchar(255),
    admin4 varchar(255),
    alt_name varchar(1000),
    ascii varchar(255),
    cc2 varchar(255),
    country varchar(255),
    dem bigint, elevation bigint,
    feat_class varchar(255),
    feat_code varchar(255),
    lat bigint,
    location_id bigint,
    long bigint,
    name varchar(255),
    population bigint,
    tz varchar(255),
    primary key (id)
);

alter table if exists locations
drop constraint if exists UK9547ykosuwevmit6mjp0f9q7f;

alter table if exists locations
add constraint UK9547ykosuwevmit6mjp0f9q7f unique (secure_id)