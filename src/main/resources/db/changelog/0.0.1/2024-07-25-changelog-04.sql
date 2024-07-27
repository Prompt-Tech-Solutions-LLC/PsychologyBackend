CREATE TABLE IF NOT EXISTS auth.users (
    id          SERIAL                  PRIMARY KEY,
    username    CHARACTER VARYING       NOT NULL    UNIQUE,
    password    CHARACTER VARYING       NOT NULL,
    email       CHARACTER VARYING,
    name        CHARACTER VARYING,
    surname     CHARACTER VARYING,
    role        CHARACTER VARYING
)