-- Postgres: UUID per DB generieren
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

ALTER TABLE aufgabe
    ALTER COLUMN id SET DEFAULT gen_random_uuid();
