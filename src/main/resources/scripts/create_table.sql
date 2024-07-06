CREATE SCHEMA IF NOT EXISTS question_schema;
CREATE SCHEMA IF NOT EXISTS question_log_schema;

CREATE TABLE IF NOT EXISTS "quizz-question-db".question_schema.questions (
    id BIGINT PRIMARY KEY NOT NULL,
    category VARCHAR(45) NOT NULL,
    difficulty_lvl VARCHAR(45) NOT NULL,
    question_ttl VARCHAR(1500) NOT NULL,
    right_ans VARCHAR(100) NOT NULL,
    opt_1 VARCHAR(100),
    opt_2 VARCHAR(100),
    opt_3 VARCHAR(100),
    opt_4 VARCHAR(100)
);


CREATE TABLE IF NOT EXISTS "quizz-question-db".question_log_schema.question_history (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    question_id BIGINT NOT NULL,
    category VARCHAR(45) NOT NULL,
    difficulty_lvl VARCHAR(45) NOT NULL,
    question_ttl VARCHAR(1500) NOT NULL,
    right_ans VARCHAR(100) NOT NULL,
    opt_1 VARCHAR(100),
    opt_2 VARCHAR(100),
    opt_3 VARCHAR(100),
    opt_4 VARCHAR(100),
    action_type VARCHAR(10) NOT NULL,
    action_tmst TIMESTAMP
);