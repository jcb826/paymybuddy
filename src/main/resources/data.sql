DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
  UNIQUE INDEX index_email (email)
)

                CREATE TABLE account (
                    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                    user_id INT NOT NULL,
                    amount DOUBLE(10, 2) NOT NULL,
                    CONSTRAINT FK_userId_id_userAccount FOREIGN KEY (user_id) REFERENCES user(id)
                ) ENGINE=INNODB
                AUTO_INCREMENT=0;


                CREATE TABLE connection (
                    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                    user_id INT NOT NULL,
                    connection_id INT NOT NULL,
                    CONSTRAINT FK_user_id_friend FOREIGN KEY (user_id) REFERENCES user(id),
                    CONSTRAINT FK_connection_id_connection FOREIGN KEY (connection_id) REFERENCES user(id)
                )
                  CREATE TABLE TRANSFER (
                                    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                    from_userId INT NOT NULL,
                                    to_userId INT NOT NULL,
                                    amountBeforeFee DOUBLE(10, 2) NOT NULL,
                                    amountAfterFee DOUBLE(10, 2) NOT NULL,
                                     date DATETIME NOT NULL,
                                    description TEXT,
                                    CONSTRAINT FK_from_userId FOREIGN KEY (from_userId) REFERENCES user(id),
                                    CONSTRAINT FK_to_userId FOREIGN KEY (to_userId) REFERENCES user(id)
                                )
                                ENGINE=INNODB
                                AUTO_INCREMENT=0;


INSERT INTO user(first_name, last_name, email, password) VALUES
  ('Laurent', 'GINA', 'laurentgina@mail.com', 'laurent'),
  ('Sophie', 'FONCEK', 'sophiefoncek@mail.com', 'sophie'),
  ('Agathe', 'FEELING', 'agathefeeling@mail.com', 'agathe');