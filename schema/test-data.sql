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

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (21, 'SPLIT', 'Header Detail', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (22, 'ASSIGN', 'Scanline', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (23, 'MOD', 'MOD10', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (24, 'DROP', 'drop', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (25, 'CODE', 'designate', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (26, 'MERGE', 'designate', TRUE, 0.00);

insert into task_list (task_id, acronym, t_desc, is_billable, price)
values (27, 'NCOA', 'designate', TRUE, 0.00);

--- JCM Demo Data

insert into job (job_id, client_id)
values (37913, 1);

insert into workflow (job_id, wf_id, wf_desc)
values (37913, 1, 'Datamail Demo workflow 1');

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 1, 1, 5, 3,'Convert Live Statement File',70778, 70778,null,10,null ,false);

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 1, 2, 21, 3,'Split',70778, 17745,53033,10,null ,false);

insert into workflow (job_id, wf_id, wf_desc)
values (37913, 2, 'Datamail Demo workflow 2');

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 2, 1, 22, 3,'Scanline',17745, 17745,null,10,null ,false);

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 2, 2, 23, 3,'MOD10',17745, 17745,null,15,null ,false);

insert into workflow (job_id, wf_id, wf_desc)
values (37913, 3, 'Datamail Demo workflow 3');

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 3, 1, 24, 3,'Drop Foreign from months 2,3,5',17745, 17506,239,15,null ,false);

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 3, 2, 15, 3,'to verify',17506, null,null,10,null ,false);

insert into workflow (job_id, wf_id, wf_desc)
values (37913, 4, 'Datamail Demo workflow 4');

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 4, 1, 25, 3,'SponserFlowFlag',17506, 17506,null,20,null ,false);

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 4, 2, 15, 3,'',17506, 0,0,5,null ,false);

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 4, 3, 25, 3,'Text',17506, 17506,null,5,null ,false);

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 4, 4, 15, 3,'',17506, null,null,10,null ,false);

insert into workflow (job_id, wf_id, wf_desc)
values (37913, 6, 'Datamail Demo workflow 6');

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 6, 1, 25, 3,'Apply version code to file',17506, 17506,null,60,null ,false);

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 6, 2, 15, 3,'',17506, null,null,10,null ,false);

insert into workflow (job_id, wf_id, wf_desc)
values (37913, 7, 'Datamail Demo workflow 7');

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 7, 1, 26, 3,'Merge Seeds',7, 7,null,5,null ,false);

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 7, 2, 25, 3,'Code Seeds',7, 266,null,20,null ,false);

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 7, 3, 26, 3,'Merge with mail file',17772, 17772,null,5,null ,false);

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 7, 4, 15, 3,'',17772, null,null,5,null ,false);

insert into workflow (job_id, wf_id, wf_desc)
values (37913, 8, 'Datamail Demo workflow 8');

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 8, 1, 26, 3,'Flag VIP then merge back with live',17772, null,null,20,null ,false);

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 8, 2, 21, 3,'Split off international',17630, 142,null,10,null ,false);

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 8, 3, 15, 3,'',17630, null,null,5,null ,false);

insert into workflow (job_id, wf_id, wf_desc)
values (37913, 9, 'Datamail Demo workflow 9');

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 9, 1, 27, 3,'NCOA Update',17630, 17621,9,15,null ,false);

insert into input_task (job_id, wf_id, task_num, task_id, user_id, task_desc, records_in, records_out, records_dropped, time_taken, time_recorded, is_pcr)
values (37913, 9, 2, 25, 3,'Fixed 2CSV for NonForwardables',9, 9,null,15,null ,false);





Commit;