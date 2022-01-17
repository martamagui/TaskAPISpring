DROP DATABASE IF EXISTS michi_tasks;
CREATE DATABASE IF NOT EXISTS michi_tasks DEFAULT CHARSET = latin1 COLLATE = latin1_spanish_ci;
USE michi_tasks;
CREATE TABLE users(
  user_id INT NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  PRIMARY KEY (user_id)
) ENGINE = InnoDB;
CREATE TABLE lists(
  list_id INT NOT NULL,
  name VARCHAR(250) NOT NULL,
  user_id_fk INT NOT NULL,
  PRIMARY KEY(list_id),
  FOREIGN KEY (user_id_fk) REFERENCES users(user_id) ON DELETE CASCADE
) ENGINE = InnoDB;
CREATE TABLE task(
  task_id INT NOT NULL,
  title VARCHAR(250) NOT NULL,
  description TEXT,
  state VARCHAR(150) NOT NULL,
  list_id_fk INT NOT NULL,
  PRIMARY KEY(task_id),
  FOREIGN KEY (list_id_fk) REFERENCES lists(list_id) ON DELETE CASCADE
) ENGINE = InnoDB;