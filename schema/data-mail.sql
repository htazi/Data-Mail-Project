-- Creates the Schema for the database along with any relevant test data

-- Drop any tables here if they exist
DROP TABLE app_user CASCADE;

DROP TABLE app_role CASCADE;

DROP TABLE user_role;

DROP TABLE Persistent_Logins;

DROP TABLE client CASCADE;

DROP TABLE job CASCADE;

DROP TABLE workflow CASCADE;

DROP TABLE input_task CASCADE;

DROP TABLE task_list CASCADE;

-- Set the proper time zone
SET timezone = 'America/New_York';

-- All users of the system
CREATE TABLE app_user (
  user_id            INT          NOT NULL,
  user_name          VARCHAR(36)  NOT NULL,
  encrypted_password VARCHAR(128) NOT NULL,
  f_name             VARCHAR(30),
  l_name             VARCHAR(30),
  last_login         TIMESTAMPTZ,
  last_logout        TIMESTAMPTZ,
  is_active          BOOLEAN      NOT NULL,
  CONSTRAINT app_user_pk PRIMARY KEY (user_id),
  CONSTRAINT app_user_uk UNIQUE (user_name)
);

-- All roles available to users of the system
CREATE TABLE app_role (
  role_id   INT         NOT NULL,
  role_name VARCHAR(30) NOT NULL,
  CONSTRAINT app_role_pk PRIMARY KEY (role_id),
  CONSTRAINT app_role_uk UNIQUE (role_name)
);

-- Used by Spring Remember Me API
CREATE TABLE persistent_logins (
  username  VARCHAR(64) NOT NULL,
  series    VARCHAR(64) NOT NULL,
  token     VARCHAR(64) NOT NULL,
  last_used TIMESTAMP   NOT NULL,
  CONSTRAINT persistent_logins_pk PRIMARY KEY (series)
);

-- Users listed with their app_role (a app_user can have multiple)
CREATE TABLE user_role (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  CONSTRAINT user_role_pk PRIMARY KEY (user_id, role_id),
  CONSTRAINT user_role_fk1 FOREIGN KEY (user_id) REFERENCES app_user (user_id),
  CONSTRAINT user_role_fk2 FOREIGN KEY (role_id) REFERENCES app_role (role_id)
);

-- Clients that are associated with data mail jobs
CREATE TABLE client (
  client_id   INT NOT NULL,
  client_name VARCHAR(30),
  address     VARCHAR(45),
  CONSTRAINT client_pk PRIMARY KEY (client_id)
);

-- List of data mail job and their client
CREATE TABLE job (
  job_id    INT NOT NULL,
  job_desc  VARCHAR(60),
  client_id INT,
  CONSTRAINT job_pk PRIMARY KEY (job_id),
  CONSTRAINT job_fk FOREIGN KEY (client_id) REFERENCES client (client_id)
);

-- List of all workFlows and their descriptions
CREATE TABLE workflow (
  job_id  INT NOT NULL,
  wf_id   INT NOT NULL,
  wf_desc VARCHAR(60),
  CONSTRAINT workflow_pk PRIMARY KEY (job_id, wf_id),
  CONSTRAINT workflow_fk FOREIGN KEY (job_id) REFERENCES job (job_id)
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
CREATE TABLE input_task (
  job_id        INT NOT NULL,
  wf_id         INT NOT NULL,
  task_num      INT NOT NULL,
  task_id       INT NOT NULL,
  user_id       INT NOT NULL,
  task_desc     VARCHAR(60),
  t_input       INT,
  t_output      INT,
  t_dropped     INT,
  time_taken    INT,
  time_recorded TIMESTAMPTZ,
  CONSTRAINT input_task_pk PRIMARY KEY (job_id, wf_id, task_num),
  CONSTRAINT input_task_fk1 FOREIGN KEY (user_id) REFERENCES app_user (user_id),
  CONSTRAINT input_task_fk2 FOREIGN KEY (task_id) REFERENCES task_list (task_id),
  -- this might have to be reworked as must reference both job_id and wf_id from workflow
  CONSTRAINT input_task_fk3 FOREIGN KEY (job_id, wf_id) REFERENCES workflow (job_id, wf_id),
  -- this may have to be removed as job_id is also referenced via workflow table
  CONSTRAINT input_task_fk4 FOREIGN KEY (job_id) REFERENCES job (job_id)
);

-- Add any test data here

-- Test user Data
insert into app_user (user_id, user_name, encrypted_password, is_active)
values (7, 'Manager1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);

insert into app_user (user_id, user_name, encrypted_password, is_active)
values (6, 'Billing1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);

insert into app_user (user_id, user_name, encrypted_password, is_active)
values (5, 'DataProcessing1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);

insert into app_user (user_id, user_name, encrypted_password, is_active)
values (4, 'FileTransfer1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);

insert into app_user (user_id, user_name, encrypted_password, is_active)
values (3, 'Programmer1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);

insert into app_user (user_id, user_name, encrypted_password, is_active)
values (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);

insert into app_user (user_id, user_name, encrypted_password, is_active)
values (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);

-- AppUser Permissions
insert into app_role (role_id, role_name)
values (1, 'ROLE_ADMIN');

insert into app_role (role_id, role_name)
values (2, 'ROLE_USER');

insert into app_role (role_id, role_name)
values (3, 'ROLE_Production_Programmer');

insert into app_role (role_id, role_name)
values (4, 'ROLE_File_Transfer');

insert into app_role (role_id, role_name)
values (5, 'ROLE_Data_Processing');

insert into app_role (role_id, role_name)
values (6, 'ROLE_Billing');

insert into app_role (role_id, role_name)
values (7, 'ROLE_Manager');

-- Tie test app_user to app_user permissions
insert into user_role (USER_ID, ROLE_ID)
values (1, 1);

insert into user_role (USER_ID, ROLE_ID)
values (1, 2);

insert into user_role (USER_ID, ROLE_ID)
values (2, 2);

insert into user_role (USER_ID, ROLE_ID)
values (3, 3);

insert into user_role (USER_ID, ROLE_ID)
values (4, 4);

insert into user_role (USER_ID, ROLE_ID)
values (5, 5);

insert into user_role (USER_ID, ROLE_ID)
values (6, 6);

insert into user_role (USER_ID, ROLE_ID)
values (7, 7);

insert into client (client_id)
values (1);

insert into job (job_id, client_id)
values (1, 1);

insert into workflow (job_id, wf_id, wf_desc)
values (1, 0, 'Wooh if you can see this it works');
---
Commit;