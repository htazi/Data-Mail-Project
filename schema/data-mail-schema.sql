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

-- Data mail job information along with the client of the job
CREATE TABLE job (
  job_id        INT NOT NULL,
  job_desc      VARCHAR(60),
  client_id     INT,
  data_mill_num INT,
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
  task_id     INT     NOT NULL,
  acronym     VARCHAR(6),
  t_desc      VARCHAR(60),
  is_billable BOOLEAN NOT NULL,
  price       NUMERIC,
  CONSTRAINT task_list_pk PRIMARY KEY (task_id)
);

-- List of all the recorded tasks input by employees
CREATE TABLE input_task (
  job_id          INT NOT NULL,
  wf_id           INT NOT NULL,
  task_num        INT NOT NULL,
  task_id         INT NOT NULL,
  user_id         INT NOT NULL,
  task_desc       VARCHAR(60),
  records_in      INT,
  records_out     INT,
  records_dropped INT,
  time_taken      INT,
  time_recorded   TIMESTAMPTZ,
  CONSTRAINT input_task_pk PRIMARY KEY (job_id, wf_id, task_num),
  CONSTRAINT input_task_fk1 FOREIGN KEY (user_id) REFERENCES app_user (user_id),
  CONSTRAINT input_task_fk2 FOREIGN KEY (task_id) REFERENCES task_list (task_id),
  -- this might have to be reworked as must reference both job_id and wf_id from workflow
  CONSTRAINT input_task_fk3 FOREIGN KEY (job_id, wf_id) REFERENCES workflow (job_id, wf_id)
);

---
Commit;