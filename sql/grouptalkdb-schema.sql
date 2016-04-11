drop database if exists grouptalkdb;
create database grouptalkdb;

  use grouptalkdb;

  CREATE TABLE users (
    id BINARY(16) NOT NULL,
    loginid VARCHAR(15) NOT NULL UNIQUE,
    password BINARY(16) NOT NULL,
    email VARCHAR(255) NOT NULL,
    fullname VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
  );

  CREATE TABLE user_roles (
    userid BINARY(16) NOT NULL,
    role ENUM ('registered', 'administrator'),
    FOREIGN KEY (userid) REFERENCES users(id) on delete cascade,
    PRIMARY KEY (userid, role)
  );

  CREATE TABLE auth_tokens (
    userid BINARY(16) NOT NULL,
    token BINARY(16) NOT NULL,
    FOREIGN KEY (userid) REFERENCES users(id) on delete cascade,
    PRIMARY KEY (token)
  );

  CREATE TABLE groups (
    title VARCHAR(255) NOT NULL,
    topictitle VARCHAR(255) NOT NULL,
    loginid VARCHAR(15) NOT NULL,
    content VARCHAR(255) NOT NULL,
    FOREIGN KEY (loginid) REFERENCES users(loginid) on delete cascade,
    PRIMARY KEY (title)
  );
