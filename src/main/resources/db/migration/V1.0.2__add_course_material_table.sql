CREATE TABLE IF NOT EXISTS course_material(
    id UUID PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    link VARCHAR(225) NOT NULL,
    course_id UUID NOT NULL REFERENCES course
);

ALTER TABLE course DROP COLUMN IF EXISTS material_links;