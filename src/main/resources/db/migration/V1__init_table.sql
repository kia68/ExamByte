CREATE TABLE exam (
    id serial PRIMARY KEY,
    name VARCHAR(300) NOT NULL,
    start_time date NOT NULL,
    end_time date NOT NULL
);
CREATE TABLE aufgabe (
    id serial PRIMARY KEY,
    exam_id integer NOT NULL,
    title VARCHAR(300) NOT NULL,
    punkt integer NOT NULL,
    type VARCHAR(50) NOT NULL,
    beschreibung TEXT,
    FOREIGN KEY (exam_id) REFERENCES exam(id) ON DELETE CASCADE
);


CREATE TABLE antwort (
    id serial PRIMARY KEY,
    aufgabe_id integer NOT NULL,
    antwort_text TEXT NOT NULL,
    is_submitted BOOLEAN NOT NULL,
    FOREIGN KEY (aufgabe_id) REFERENCES aufgabe(id) ON DELETE CASCADE
);
