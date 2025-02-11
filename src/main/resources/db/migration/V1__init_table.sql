CREATE TABLE exam
(
    id         serial PRIMARY KEY,
    fach_id    UUID,
    name       VARCHAR(300) NOT NULL,
    start_time timestamp    NOT NULL,
    end_time   timestamp    NOT NULL
);
CREATE TABLE aufgabe
(
    id           UUID PRIMARY KEY,
    exam_id      INTEGER,
    title        VARCHAR(300) NOT NULL,
    punkt        integer      NOT NULL,
    type         VARCHAR(50)  NOT NULL,
    beschreibung TEXT,
    constraint fk_exam
        foreign key (exam_id) references exam (id)
);


CREATE TABLE antwort
(
    id           serial PRIMARY KEY,
    fach_id      UUID,
    aufgabe_id      UUID,
    github_user  VARCHAR(255) NOT NULL,
    antwort_text TEXT         NOT NULL,
    constraint fk_aufgabe
        foreign key (aufgabe_id) references aufgabe (id)
);
