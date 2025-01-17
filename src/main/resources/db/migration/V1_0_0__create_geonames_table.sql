CREATE TABLE geonames (
    id bigint NOT NULL,
    created_date TIMESTAMP(6),
    deleted_date TIMESTAMP(6),
    is_deleted BOOLEAN,
    modified_date TIMESTAMP(6),
    secure_id VARCHAR(36),
    version INTEGER,
    admin1 VARCHAR(255),
    admin2 VARCHAR(255),
    admin3 VARCHAR(255),
    admin4 VARCHAR(255),
    alt_name VARCHAR(1000),
    ascii VARCHAR(255),
    cc2 VARCHAR(255),
    country VARCHAR(255),
    dem BIGINT,
    elevation BIGINT,
    feat_class VARCHAR(255),
    feat_code VARCHAR(255),
    geoname_id BIGINT,
    lat FLOAT(53),
    long FLOAT(53),
    name VARCHAR(255),
    population BIGINT,
    tz VARCHAR(255),
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS geonames
DROP CONSTRAINT IF EXISTS UK1hpgr0op957yrm6r9mk8ojgep;

ALTER TABLE IF EXISTS geonames
ADD CONSTRAINT UK1hpgr0op957yrm6r9mk8ojgep UNIQUE (secure_id);

COMMENT ON TABLE geonames is '17/01/2025 by Kevin Christian';