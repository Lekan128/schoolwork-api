CREATE TABLE IF NOT EXISTS temporary_user (
    id UUID NOT NULL PRIMARY KEY,
    name varchar(64) NOT NULL UNIQUE
);
