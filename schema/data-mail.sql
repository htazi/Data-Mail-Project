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

-- All roles available to users of the system
CREATE TABLE roles(
    role_id   INT NOT NULL,
    role_name VARCHAR(30),
    PRIMARY KEY(role_id)
);

-- All users of the system
CREATE TABLE users(
    user_id INT NOT NULL,
    user_name VARCHAR(36) NOT NULL,
    encrypted_password  VARCHAR(128) NOT NULL,
    f_name VARCHAR(30),
    l_name VARCHAR(30),
    is_active boolean,
    last_login timestamp,
    last_logout timestamp,
    PRIMARY KEY(user_id)
);

-- Used by Spring Remember Me API to remember logins.
CREATE TABLE Persistent_Logins (
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    PRIMARY KEY (series)
);

-- Users listed with their roles (a user can have multiple)
CREATE TABLE user_roles(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY(user_id, role_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id),
    FOREIGN KEY(role_id) REFERENCES roles(role_id)
);

-- Clients that are associated with data mail jobs
CREATE TABLE clients(
    client_id INT NOT NULL,
    client_name VARCHAR(30),
    addr VARCHAR(45),
    PRIMARY KEY(client_id)
);

-- List of data mail jobs and their clients
CREATE TABLE jobs(
    job_id INT NOT NULL,
    job_desc VARCHAR(60),
    client_id INT,
    PRIMARY KEY(job_id),
    FOREIGN KEY(client_id) REFERENCES clients(client_id)
);

-- List of all workflows and their descriptions
CREATE TABLE workflows(
    job_id INT NOT NULL,
    wf_id INT NOT NULL,
    wf_desc VARCHAR(60),
    PRIMARY KEY(job_id, wf_id),
    FOREIGN KEY(job_id) REFERENCES jobs(job_id)
);

-- List of all available tasks and information associated with them
CREATE TABLE task_list(
    task_id INT NOT NULL,
    acronym VARCHAR(6),
    t_desc  VARCHAR(60),
    is_billable BOOLEAN,
    price money,
    PRIMARY KEY(task_id)
);

-- List of all the recorded tasks input by employees
CREATE TABLE tasks_input(
    job_id INT NOT NULL,
    wf_id INT NOT NULL,
    task_id INT NOT NULL,
    user_id INT NOT NULL,
    task_desc VARCHAR(60),
    t_input INT,
    t_output INT,
    t_dropped INT,
    time_taken timestamp,
    time_recorded timestamp,
    PRIMARY KEY(job_id, wf_id, task_id),
    -- this may have to be removed as job_id is also referenced via workflows table
    FOREIGN KEY(job_id) REFERENCES jobs(job_id),
    FOREIGN KEY(user_id) REFERENCES users(user_id),
    -- this might have to be reworked as must reference both job_id and wf_id from workflows
    FOREIGN KEY(job_id, wf_id) REFERENCES workflows(job_id, wf_id)
);

-- Add any test data here