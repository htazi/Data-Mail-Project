-- Creates the Schema for the database along with any relevant test data

-- Drop any tables here if they exist
DROP TABLE roles CASCADE;

DROP TABLE users CASCADE;

DROP TABLE user_roles;

DROP TABLE Persistent_Logins;

DROP TABLE clients CASCADE;

DROP TABLE jobs CASCADE;

DROP TABLE workflows CASCADE;

DROP TABLE tasks_input CASCADE;

DROP TABLE task_list CASCADE;

-- Set the proper time zone
SET timezone = 'America/New_York';

-- All users of the system
CREATE TABLE users (
  user_id            INT          NOT NULL,
  user_name          VARCHAR(36)  NOT NULL,
  encrypted_password VARCHAR(128) NOT NULL,
  f_name             VARCHAR(30),
  l_name             VARCHAR(30),
  is_active          boolean,
  last_login         timestamp,
  last_logout        timestamp,
  CONSTRAINT user_pk PRIMARY KEY (user_id),
  CONSTRAINT user_name_uk UNIQUE(user_name)
);

-- All roles available to users of the system
CREATE TABLE roles (
  role_id   INT NOT NULL,
  role_name VARCHAR(30),
  CONSTRAINT role_pk PRIMARY KEY (role_id)
);

-- Used by Spring Remember Me API to remember logins.
CREATE TABLE Persistent_Logins (
  username  varchar(64) not null,
  series    varchar(64) not null,
  token     varchar(64) not null,
  last_used timestamp   not null,
  CONSTRAINT persistent_logins_pk PRIMARY KEY (series)
);

-- Users listed with their roles (a user can have multiple)
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  CONSTRAINT user_role_pk PRIMARY KEY (user_id, role_id),
  CONSTRAINT user_role_fk1 FOREIGN KEY (user_id) REFERENCES users (user_id),
  CONSTRAINT user_role_fk2 FOREIGN KEY (role_id) REFERENCES roles (role_id)
);

-- Clients that are associated with data mail jobs
CREATE TABLE clients (
  client_id   INT NOT NULL,
  client_name VARCHAR(30),
  addr        VARCHAR(45),
  CONSTRAINT client_pk PRIMARY KEY (client_id)
);

-- List of data mail jobs and their clients
CREATE TABLE jobs (
  job_id    INT NOT NULL,
  job_desc  VARCHAR(60),
  client_id INT,
  CONSTRAINT job_pk PRIMARY KEY (job_id),
  CONSTRAINT job_fk FOREIGN KEY (client_id) REFERENCES clients (client_id)
);

-- List of all workflows and their descriptions
CREATE TABLE workflows (
  job_id  INT NOT NULL,
  wf_id   INT NOT NULL,
  wf_desc VARCHAR(60),
  CONSTRAINT workflow_pk PRIMARY KEY (job_id, wf_id),
  CONSTRAINT workflow_fk FOREIGN KEY (job_id) REFERENCES jobs (job_id)
);

-- List of all available tasks and information associated with them
CREATE TABLE task_list (
  task_id     INT NOT NULL,
  acronym     VARCHAR(6),
  t_desc      VARCHAR(60),
  is_billable BOOLEAN,
  price       money,
  CONSTRAINT task_list_pk PRIMARY KEY (task_id)
);

-- List of all the recorded tasks input by employees
CREATE TABLE tasks_input (
  job_id        INT NOT NULL,
  wf_id         INT NOT NULL,
  task_id       INT NOT NULL,
  user_id       INT NOT NULL,
  task_desc     VARCHAR(60),
  t_input       INT,
  t_output      INT,
  t_dropped     INT,
  time_taken    INT,
  time_recorded timestamp,
  CONSTRAINT task_input_pk PRIMARY KEY (job_id, wf_id, task_id),
  CONSTRAINT task_input_fk1 FOREIGN KEY (user_id) REFERENCES users (user_id),
  -- this might have to be reworked as must reference both job_id and wf_id from workflows
  CONSTRAINT task_input_fk2 FOREIGN KEY (job_id, wf_id) REFERENCES workflows (job_id, wf_id),
    -- this may have to be removed as job_id is also referenced via workflows table
  CONSTRAINT task_input_fk3 FOREIGN KEY (job_id) REFERENCES jobs (job_id)
);

-- Add any test data here

-- Test User Data
insert into users (user_id, user_name, encrypted_password, is_active)
values (7, 'Manager1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);

insert into users (user_id, user_name, encrypted_password, is_active)
values (6, 'Billing1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);

insert into users (user_id, user_name, encrypted_password, is_active)
values (5, 'DataProcessing1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);

insert into users (user_id, user_name, encrypted_password, is_active)
values (4, 'FileTransfer1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);

insert into users (user_id, user_name, encrypted_password, is_active)
values (3, 'Programmer1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);

insert into users (user_id, user_name, encrypted_password, is_active)
values (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);

insert into users (user_id, user_name, encrypted_password, is_active)
values (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);

-- User Permissions
insert into roles(role_id, role_name)
values (1, 'ROLE_ADMIN');

insert into roles(role_id, role_name)
values (2, 'ROLE_USER');

insert into roles(role_id, role_name)
values (3, 'ROLE_Production_Programmer');

insert into roles(role_id, role_name)
values (4, 'ROLE_File_Transfer');

insert into roles(role_id, role_name)
values (5, 'ROLE_Data_Processing');

insert into roles(role_id, role_name)
values (6, 'ROLE_Billing');

insert into roles(role_id, role_name)
values (7, 'ROLE_Manager');


-- Tie test users to user permissions
insert into user_roles (USER_ID, ROLE_ID)
values (1, 1);

insert into user_roles (USER_ID, ROLE_ID)
values (1, 2);

insert into user_roles (USER_ID, ROLE_ID)
values (2, 2);

insert into user_roles (USER_ID, ROLE_ID)
values (3, 3);

insert into user_roles (USER_ID, ROLE_ID)
values (4, 4);

insert into user_roles (USER_ID, ROLE_ID)
values (5, 5);

insert into user_roles (USER_ID, ROLE_ID)
values (6, 6);

insert into user_roles (USER_ID, ROLE_ID)
values (7, 7);