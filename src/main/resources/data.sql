DROP TABLE IF EXISTS users;

CREATE TABLE users(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
  UNIQUE INDEX index_email (email)
);


INSERT INTO users (first_name, last_name, email, password) VALUES
  ('Laurent', 'GINA', 'laurentgina@mail.com', 'laurent'),
  ('Sophie', 'FONCEK', 'sophiefoncek@mail.com', 'sophie'),
  ('Agathe', 'FEELING', 'agathefeeling@mail.com', 'agathe');