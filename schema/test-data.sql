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

insert into app_user (user_id, user_name, encrypted_password, is_active)
values (8, 'text1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', TRUE);



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

insert into app_role (role_id, role_name)
values (8, 'ROLE_Text_Specialist');

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

insert into user_role (USER_ID, ROLE_ID)
values (8, 8);

insert into client (client_id)
values (1);

insert into job (job_id, client_id)
values (1, 1);

insert into workflow (job_id, wf_id, wf_desc)
values (1, 0, 'Test workflow 0 for job 1');

insert into workflow (job_id, wf_id, wf_desc)
values (1, 1, 'Test workflow 1 for job 1');

insert into task_list (task_id, acronym, t_desc, is_billable)
values (0, 'test', 'this is a test task', FALSE);

insert into input_task (job_id, wf_id, task_num, task_id, user_id)
values (1, 0, 1, 0, 2);

---task_list preload data
insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (1, 'TXSET', 'Letter Text Set Up', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (2, 'Multi', 'Download, Decrypt, File Map & Initial Counts', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (3, 'XFER', 'Upload Client Mail File', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (4, 'MTS', 'Upload for Mail Tracking', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (5, 'CVT', 'Convert to Standard Layout', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (6, 'PGM', 'Programming', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (7, 'PRST', 'USPS, Presort Standard', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (8, 'SEED', 'Append Seeds', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (9, 'SAMP', 'Samples', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (10, 'WFD', 'Sign Offs, Laser', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (11, 'RETYP', '100% Mail, Retypes Processing', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (12, 'NTST', 'Audit Selection', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (13, 'BEF', 'Backend File Processing', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (14, 'CAN', 'Canadian Mail', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (15, 'TAB', 'Counts/Tab Reports', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (16, 'IMB', 'IMB append/update', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (17, 'INTL', 'International Mail', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (18, 'PDFBEF', 'Mail File PDF Archiving', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (19, 'MTRK', 'Mail Tracking', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (20, 'DEDUPE', 'Merge/Purge (Dedupe)', TRUE, 0.00);

---
Commit;