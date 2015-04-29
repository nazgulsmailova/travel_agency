CREATE DATABASE IF NOT EXISTS travel;
GRANT ALL PRIVILEGES ON travel.* TO travel@localhost IDENTIFIED BY 'travel';

USE travel;


CREATE TABLE IF NOT EXISTS employees (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  firstName VARCHAR(30),
  lastName VARCHAR(30),
  login VARCHAR(30),
  password VARCHAR(30)
  ) engine=InnoDB;


CREATE TABLE IF NOT EXISTS clients (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  firstName VARCHAR(30),
  lastName VARCHAR(30),
  address VARCHAR(255),
  idNumber VARCHAR(30),
  telephone VARCHAR(20),
  birthday DATE,
  login VARCHAR(30),
  password VARCHAR(30),
  account_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (account_id) REFERENCES accounts(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS tours (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  description VARCHAR(257),
  hot BOOLEAN,
  price LONG,
  duration INT(255),
  employee_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (employee_id) REFERENCES employees(id),
  tourOrder_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (tourOrder_id) REFERENCES tourOrder(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS countries (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80),
  description VARCHAR(257)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS tours_countries (
  tour_id INT(4) UNSIGNED NOT NULL,
  country_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (tour_id) REFERENCES tours(id),
  FOREIGN KEY (country_id) REFERENCES countries(id),
  UNIQUE (tour_id,country_id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS tourOrder (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  price LONG,
  discount LONG,
  client_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (client_id) REFERENCES clients(id)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS accounts (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  amount LONG
) engine=InnoDB;