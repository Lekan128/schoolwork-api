CREATE TABLE IF NOT EXISTS faculty (
    id UUID NOT NULL PRIMARY KEY,
    name varchar(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS department (
    id UUID PRIMARY KEY,
    faculty varchar(64) REFERENCES faculty (name),
    name varchar(64)
);

CREATE TABLE IF NOT EXISTS level (
    id UUID NOT NULL,
    name varchar(64) NOT NULL UNIQUE,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS course (
    id UUID NOT NULL,
    title varchar(64),
    code varchar(64),
    material_links varchar(500) array,
    level varchar(64) REFERENCES level (name),
    semester VARCHAR(16),
    department_id UUID NOT NULL REFERENCES department,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS review (
    id UUID NOT NULL,
    lecturer varchar(64),
    course_id UUID REFERENCES course,
    review varchar(255),
    exam_tips varchar(255),
    test_tips varchar(255),
    primary key (id)
);