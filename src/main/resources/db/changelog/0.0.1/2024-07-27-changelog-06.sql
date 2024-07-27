CREATE TABLE IF NOT EXISTS quiz.quiz (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS quiz.question (
    id SERIAL PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    question_type VARCHAR(255) NOT NULL,
    quiz_id INTEGER NOT NULL REFERENCES quiz.quiz(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS quiz.answer (
    id SERIAL PRIMARY KEY,
    question_id INTEGER NOT NULL REFERENCES quiz.question(id) ON DELETE CASCADE,
    answers JSONB NOT NULL
);

ALTER TABLE quiz.question
ADD CONSTRAINT fk_quiz_question FOREIGN KEY (quiz_id) REFERENCES quiz.quiz (id) ON DELETE CASCADE;

ALTER TABLE quiz.answer
ADD CONSTRAINT fk_question_answer FOREIGN KEY (question_id) REFERENCES quiz.question (id) ON DELETE CASCADE;

CREATE INDEX idx_quiz_id ON quiz.question (quiz_id);
CREATE INDEX idx_question_id ON quiz.answer (question_id);
