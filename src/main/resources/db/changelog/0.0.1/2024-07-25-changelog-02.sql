CREATE TABLE IF NOT EXISTS article.article_metadata (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    mongo_id VARCHAR(255) NOT NULL
);