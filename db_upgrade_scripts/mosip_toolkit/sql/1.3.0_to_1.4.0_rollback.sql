\c mosip_toolkit sysadmin

DROP SEQUENCE IF EXISTS toolkit.batch_step_execution_seq;
DROP SEQUENCE IF EXISTS toolkit.batch_job_execution_seq;
DROP SEQUENCE IF EXISTS toolkit.batch_job_seq;
ALTER TABLE toolkit.batch_job_execution_params DROP CONSTRAINT job_exec_params_fk;
ALTER TABLE toolkit.batch_job_execution_context DROP CONSTRAINT job_exec_ctx_fk;
ALTER TABLE toolkit.batch_job_execution DROP CONSTRAINT job_inst_exec_fk;
ALTER TABLE toolkit.batch_step_execution DROP CONSTRAINT job_exec_step_fk;
ALTER TABLE toolkit.batch_step_execution_context DROP CONSTRAINT step_exec_ctx_fk;
DROP TABLE IF EXISTS toolkit.batch_job_execution_params;
DROP TABLE IF EXISTS toolkit.batch_job_execution_context;
DROP TABLE IF EXISTS toolkit.batch_step_execution;
DROP TABLE IF EXISTS toolkit.batch_step_execution_context;
DROP TABLE IF EXISTS toolkit.batch_job_execution;
DROP TABLE IF EXISTS toolkit.batch_job_instance;

-- partner_profile
DROP TABLE IF EXISTS toolkit.partner_profile;

--ctk_template
DROP TABLE IF EXISTS toolkit.ctk_template;